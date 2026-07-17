package com.mydgnbot.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mydgnbot.demo.DemoBotController
import com.mydgnbot.domain.BotState
import com.mydgnbot.data.model.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class BotViewModel : ViewModel() {


    private val controller =
        DemoBotController()



    private val _state =
        MutableStateFlow<BotState>(
            BotState.Idle
        )


    val state: StateFlow<BotState> =
        _state



    private val _player =
        MutableStateFlow<Player?>(null)


    val player: StateFlow<Player?> =
        _player



    fun startBot() {


        _state.value =
            BotState.Monitoring



        viewModelScope.launch {


            val found =
                controller.findPlayer()



            if(found) {


                _player.value =
                    controller.getPlayer()



                _state.value =
                    BotState.PlayerFound


            }


        }


    }



    fun stopBot() {

        _state.value =
            BotState.Idle


        _player.value =
            null

    }



    fun boughtPlayer() {


        _state.value =
            BotState.PurchaseCompleted



        viewModelScope.launch {


            kotlinx.coroutines.delay(1500)


            _state.value =
                BotState.Monitoring


        }


    }

}
