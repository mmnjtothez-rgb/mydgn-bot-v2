package com.mydgnbot.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mydgnbot.data.repository.MyDGNRepository
import com.mydgnbot.domain.BotState
import com.mydgnbot.domain.manager.CountdownManager
import com.mydgnbot.ui.state.HomeUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class HomeViewModel(
    private val repository: MyDGNRepository,
    private val countdownManager: CountdownManager
) : ViewModel() {


    private val _uiState =
        MutableStateFlow(
            HomeUiState()
        )

    val uiState: StateFlow<HomeUiState> =
        _uiState.asStateFlow()



    private var monitoringJob: Job? = null



    init {

        observeCountdown()

    }



    private fun observeCountdown() {

        viewModelScope.launch {

            countdownManager.state
                .collect { countdown ->

                    _uiState.update {

                        it.copy(
                            countdown = countdown
                        )

                    }

                }

        }

    }




    fun startBot(
        platform: String
    ) {

        if (monitoringJob != null)
            return


        _uiState.update {

            it.copy(
                botState = BotState.Monitoring,
                errorMessage = null
            )

        }



        monitoringJob =
            viewModelScope.launch {


                while(true) {


                    try {


                        _uiState.update {

                            it.copy(
                                isLoading = true
                            )

                        }



                        val player =
                            repository.findPlayer(
                                platform
                            )



                        if(player != null) {


                            _uiState.update {

                                it.copy(

                                    botState =
                                        BotState.PlayerFound,

                                    currentPlayer =
                                        player,

                                    isLoading =
                                        false

                                )

                            }



                            countdownManager.start(
                                seconds = 300
                            )



                            break

                        }



                    }
                    catch(e: Exception) {


                        _uiState.update {

                            it.copy(

                                botState =
                                    BotState.Error,

                                errorMessage =
                                    e.message,

                                isLoading =
                                    false

                            )

                        }


                    }



                    delay(10000)

                }


            }

    }





    fun stopBot() {

        monitoringJob?.cancel()

        monitoringJob = null


        countdownManager.stop()


        _uiState.value =
            HomeUiState()

    }






    fun playerBought() {


        countdownManager.stop()


        _uiState.update {


            it.copy(

                botState =
                    BotState.Completed,

                currentPlayer =
                    null

            )

        }


        resumeMonitoring()

    }






    fun cancelPlayer() {


        countdownManager.stop()


        _uiState.update {


            it.copy(

                currentPlayer =
                    null,

                botState =
                    BotState.Monitoring

            )

        }


        resumeMonitoring()

    }





    private fun resumeMonitoring() {

        monitoringJob = null

    }



    override fun onCleared() {

        super.onCleared()

        monitoringJob?.cancel()

        countdownManager.stop()

    }

}
