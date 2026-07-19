package com.mydgnbot.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mydgnbot.data.repository.MyDGNRepository
import com.mydgnbot.domain.BotState
import com.mydgnbot.domain.manager.CountdownManager
import com.mydgnbot.ui.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MyDGNRepository,
    private val countdownManager: CountdownManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())

    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private var monitoringJob: Job? = null

    init {
        observeCountdown()
    }

    private fun observeCountdown() {
        viewModelScope.launch {
            countdownManager.state.collect { countdown ->
                _uiState.update {
                    it.copy(
                        countdown = countdown
                    )
                }
            }
        }
    }

    fun startBot(platform: String) {

        if (monitoringJob != null) return

        _uiState.update {
            it.copy(
                botState = BotState.Monitoring,
                errorMessage = null
            )
        }

        monitoringJob = viewModelScope.launch {

            while (true) {

                try {

                    _uiState.update {
                        it.copy(
                            isLoading = true
                        )
                    }

                    val player = repository.findPlayer(platform)

                    if (player != null) {

                        _uiState.update {
                            it.copy(
                                botState = BotState.PlayerFound,
                                currentPlayer = player,
                                isLoading = false
                            )
                        }

                        countdownManager.start(seconds = 300)

                        break
                    }

                } catch (e: Exception
