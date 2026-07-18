package com.mydgnbot.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mydgnbot.data.model.UserSettings
import com.mydgnbot.data.settings.SettingsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class SettingsViewModel(
    private val repository: SettingsRepository
) : ViewModel() {


    private val _settings =
        MutableStateFlow(
            UserSettings()
        )


    val settings: StateFlow<UserSettings> =
        _settings.asStateFlow()



    init {

        loadSettings()

    }



    private fun loadSettings() {

        viewModelScope.launch {

            repository.settings.collectLatest {

                _settings.value = it

            }

        }

    }



    fun updateSettings(
        newSettings: UserSettings
    ) {

        _settings.value = newSettings

    }



    fun saveSettings() {

        viewModelScope.launch {

            repository.saveSettings(
                _settings.value
            )

        }

    }



    fun updateApiUser(
        value: String
    ) {

        _settings.value =
            _settings.value.copy(
                apiUser = value
            )

    }



    fun updateSecretKey(
        value: String
    ) {

        _settings.value =
            _settings.value.copy(
                secretKey = value
            )

    }



    fun updatePlatform(
        value: String
    ) {

        _settings.value =
            _settings.value.copy(
                platform = value
            )

    }



    fun updatePlayerType(
        value: Int
    ) {

        _settings.value =
            _settings.value.copy(
                playerType = value
            )

    }



    fun updateMinPrice(
        value: Int
    ) {

        _settings.value =
            _settings.value.copy(
                minBuyPrice = value
            )

    }



    fun updateMaxPrice(
        value: Int
    ) {

        _settings.value =
            _settings.value.copy(
                maxBuyPrice = value
            )

    }



    fun updatePollingInterval(
        value: Long
    ) {

        _settings.value =
            _settings.value.copy(
                pollingInterval = value
            )

    }

}
