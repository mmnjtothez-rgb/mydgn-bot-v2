package com.mydgnbot.domain.manager

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountdownManager @Inject constructor() {

    private val _state = MutableStateFlow(0L)
    val state: StateFlow<Long> = _state.asStateFlow()

    private var job: Job? = null

    fun start(seconds: Long) {

        job?.cancel()

        job = CoroutineScope(Dispatchers.Default).launch {

            var time = seconds

            while (time >= 0) {

                _state.value = time

                delay(1000)

                time--
            }

        }
    }

    fun stop() {
        job?.cancel()
        _state.value = 0
    }
}
