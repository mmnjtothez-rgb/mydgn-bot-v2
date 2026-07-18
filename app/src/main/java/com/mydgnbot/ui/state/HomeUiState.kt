package com.mydgnbot.ui.state

import com.mydgnbot.data.model.Player
import com.mydgnbot.domain.BotState
import com.mydgnbot.domain.CountdownState

data class HomeUiState(

    val botState: BotState = BotState.Idle,

    val currentPlayer: Player? = null,

    val countdown: CountdownState =
        CountdownState(),

    val isLoading: Boolean = false,

    val errorMessage: String? = null

)
