package com.mydgnbot.ui.state

import com.mydgnbot.data.model.Player
import com.mydgnbot.domain.BotState

data class HomeUiState(

    val botState: BotState = BotState.Idle,

    val currentPlayer: Player? = null,

    val isLoading: Boolean = false

)
