package com.mydgnbot.core

import android.content.Context
import com.mydgnbot.data.settings.DataStoreManager
import com.mydgnbot.data.settings.SettingsRepository


object AppContainer {


    private lateinit var dataStoreManager: DataStoreManager


    val settingsRepository: SettingsRepository by lazy {

        SettingsRepository(
            dataStoreManager
        )

    }


    fun initialize(
        context: Context
    ) {

        dataStoreManager =
            DataStoreManager(
                context.applicationContext
            )

    }

}
