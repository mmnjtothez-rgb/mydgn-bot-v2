package com.mydgnbot.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mydgnbot.data.model.Player
import com.mydgnbot.data.model.UserSettings
import com.mydgnbot.data.repository.MyDGNRepository
import com.mydgnbot.data.security.HashGenerator
import com.mydgnbot.data.settings.SettingsRepository
import com.mydgnbot.domain.BotState
import com.mydgnbot.ui.state.HomeUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class HomeViewModel(
    private val repository: MyDGNRepository,
    private val settingsRepository: SettingsRepository
) : ViewModel() {


    private val _uiState =
        MutableStateFlow(
            HomeUiState()
        )


    val uiState: StateFlow<HomeUiState> =
        _uiState.asStateFlow()



    private var botJob: Job? = null



    fun startBot() {


        if (botJob != null) return


        botJob =
            viewModelScope.launch {


                val settings =
                    settingsRepository.settings.first()


                _uiState.value =
                    _uiState.value.copy(
                        botState =
                            BotState.Monitoring
                    )


                while (true) {


                    fetchPlayer(settings)


                    // User controlled interval
                    delay(
                        settings.pollingInterval
                    )


                    // If a player is waiting for action,
                    // stop searching
                    if (
                        _uiState.value.currentPlayer != null
                    ) {
                        break
                    }

                }

            }

    }



    private suspend fun fetchPlayer(
        settings: UserSettings
    ) {


        _uiState.value =
            _uiState.value.copy(
                botState =
                    BotState.Searching
            )


        val timestamp =
            System.currentTimeMillis() / 1000



        val hash =
            HashGenerator.createHash(

                platform =
                    settings.platform,

                user =
                    settings.apiUser,

                timestamp =
                    timestamp,

                secretKey =
                    settings.secretKey

            )



        val result =
            repository.getTransfer(

                user =
                    settings.apiUser,

                platform =
                    settings.platform,

                timestamp =
                    timestamp,

                hash =
                    hash,

                maximumBuyOutPrice =
                    settings.maxBuyPrice,

                minimumBuyOutPrice =
                    settings.minBuyPrice,

                botApp =
                    settings.botApp,

                playerType =
                    settings.playerType

            )



        result.onSuccess { player ->


            playerFound(
                player
            )


        }



        result.onFailure {


            _uiState.value =
                _uiState.value.copy(

                    botState =
                        BotState.Monitoring

                )

        }

    }



    fun stopBot() {


        botJob?.cancel()

        botJob = null


        _uiState.value =
            HomeUiState()

    }



    fun playerFound(
        player: Player
    ) {


        _uiState.value =
            _uiState.value.copy(

                botState =
                    BotState.PlayerFound(
                        player.playerName
                    ),

                currentPlayer =
                    player

            )


    }



    fun purchaseCompleted() {


        _uiState.value =
            _uiState.value.copy(

                botState =
                    BotState.Monitoring,

                currentPlayer =
                    null

            )


        restartMonitoring()

    }



    private fun restartMonitoring() {


        if (botJob == null) {

            startBot()

        }

    }



    override fun onCleared() {


        botJob?.cancel()


        super.onCleared()

    }

}
