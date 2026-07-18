package com.mydgnbot.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.mydgnbot.data.model.Player
import com.mydgnbot.domain.BotState
import com.mydgnbot.ui.state.HomeUiState

class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState()
    )

    val uiState: StateFlow<HomeUiState> =
        _uiState.asStateFlow()

    fun startBot() {

        _uiState.value = _uiState.value.copy(
            botState = BotState.Monitoring
        )

    }

    fun stopBot() {

        _uiState.value = HomeUiState()

    }

    fun playerFound(player: Player) {

        _uiState.value = _uiState.value.copy(
            botState = BotState.PlayerFound,
            currentPlayer = player
        )

    }

    fun purchaseCompleted() {

        _uiState.value = _uiState.value.copy(
            botState = BotState.Monitoring,
            currentPlayer = null
        )

    }

}
