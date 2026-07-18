package com.mydgnbot.domain.manager

import com.mydgnbot.domain.CountdownState
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountdownManager {

    private val scope =
        CoroutineScope(
            SupervisorJob() +
            Dispatchers.Default
        )

    private var countdownJob: Job? = null


    private val _state =
        MutableStateFlow(
            CountdownState()
        )

    val state: StateFlow<CountdownState> =
        _state.asStateFlow()


    fun start(seconds: Long) {

        stop()

        _state.value =
            CountdownState(
                totalSeconds = seconds,
                remainingSeconds = seconds,
                isRunning = true
            )


        countdownJob =
            scope.launch {

                while (
                    _state.value.remainingSeconds > 0
                ) {

                    delay(1000)

                    val current =
                        _state.value.remainingSeconds


                    _state.value =
                        _state.value.copy(
                            remainingSeconds =
                                current - 1
                        )

                }


                _state.value =
                    _state.value.copy(
                        isRunning = false
                    )
            }

    }


    fun stop() {

        countdownJob?.cancel()

        countdownJob = null

        _state.value =
            CountdownState()

    }


}
