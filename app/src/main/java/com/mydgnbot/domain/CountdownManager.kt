package com.mydgnbot.domain

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountdownManager {

    private val scope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main
    )

    private var countdownJob: Job? = null

    private val _remainingSeconds =
        MutableStateFlow(0L)

    val remainingSeconds: StateFlow<Long> =
        _remainingSeconds.asStateFlow()

    fun start(lockExpires: Long) {

        stop()

        countdownJob = scope.launch {

            while (isActive) {

                val now =
                    System.currentTimeMillis() / 1000

                val remaining =
                    (lockExpires - now).coerceAtLeast(0)

                _remainingSeconds.value =
                    remaining

                if (remaining == 0L) {

                    break

                }

                delay(1000)

            }

        }

    }

    fun stop() {

        countdownJob?.cancel()

        countdownJob = null

        _remainingSeconds.value = 0

    }

}
