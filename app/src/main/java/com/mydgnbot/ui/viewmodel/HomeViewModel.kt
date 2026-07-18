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


                    delay(
                        settings.pollingInterval
                    )


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
        .onSuccess {

            playerFound(it)

        }
        .onFailure {

            _uiState.value =
                _uiState.value.copy(
                    botState =
                        BotState.Monitoring
                )

        }

    }



    fun markAsBought() {


        sendStatus(
            status = "bought"
        )

    }



    fun cancelPlayer() {


        sendStatus(
            status = "cancel"
        )

    }



    private fun sendStatus(
        status: String
    ) {


        val player =
            _uiState.value.currentPlayer
                ?: return



        viewModelScope.launch {


            val settings =
                settingsRepository.settings.first()



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



            repository.updateStatus(

                user =
                    settings.apiUser,

                platform =
                    settings.platform,

                timestamp =
                    timestamp,

                hash =
                    hash,

                transactionId =
                    player.transactionId.toInt(),

                status =
                    status,

                emailHash =
                    settings.emailHash

            )



            purchaseCompleted()

        }

    }



    fun stopBot() {


        botJob?.cancel()

        botJob = null


        _uiState.value =
            HomeUiState()

    }



    private fun playerFound(
        player: Player
    ) {


        _uiState.value =
            _uiState.value.copy(

                botState =
                    BotState.PlayerFound(
                        player.name
                    ),

                currentPlayer =
                    player

            )

    }



    private fun purchaseCompleted() {


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
