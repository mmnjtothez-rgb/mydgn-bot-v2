package com.mydgnbot.ui.viewmodel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.mydgnbot.domain.BotState


class BotViewModel : ViewModel() {


    private val _state =
        MutableStateFlow<BotState>(
            BotState.Idle
        )


    val state: StateFlow<BotState> =
        _state



    fun startBot() {

        _state.value =
            BotState.Monitoring

    }



    fun stopBot() {

        _state.value =
            BotState.Idle

    }



    fun playerFound() {

        _state.value =
            BotState.PlayerFound

    }



    fun boughtPlayer() {

        _state.value =
            BotState.PurchaseCompleted

    }


}
