package com.mydgnbot.domain

data class CountdownState(

    val totalSeconds: Long = 0,

    val remainingSeconds: Long = 0,

    val isRunning: Boolean = false

) {

    val progress: Float
        get() {
            if (totalSeconds <= 0) return 0f

            return remainingSeconds.toFloat() /
                    totalSeconds.toFloat()
        }

    val formattedTime: String
        get() {

            val minutes = remainingSeconds / 60
            val seconds = remainingSeconds % 60

            return String.format(
                "%02d:%02d",
                minutes,
                seconds
            )
        }

}
