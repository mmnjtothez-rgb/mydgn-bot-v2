package com.mydgnbot.data.settings

import com.mydgnbot.data.model.UserSettings
import kotlinx.coroutines.flow.Flow


class SettingsRepository(
    private val dataStoreManager: DataStoreManager
) {


    val settings: Flow<UserSettings> =
        dataStoreManager.settings



    suspend fun saveSettings(
        settings: UserSettings
    ) {

        dataStoreManager.saveSettings(
            settings
        )

    }

}
