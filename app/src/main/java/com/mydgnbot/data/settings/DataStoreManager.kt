
package com.mydgnbot.data.settings

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.mydgnbot.data.model.UserSettings
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStore by preferencesDataStore(
    name = "mydgn_settings"
)


class DataStoreManager(
    private val context: Context
) {


    private object Keys {

        val API_USER =
            stringPreferencesKey("api_user")

        val SECRET_KEY =
            stringPreferencesKey("secret_key")

        val PLATFORM =
            stringPreferencesKey("platform")

        val BOT_APP =
            stringPreferencesKey("bot_app")

        val PLAYER_TYPE =
            intPreferencesKey("player_type")

        val MIN_PRICE =
            intPreferencesKey("min_price")

        val MAX_PRICE =
            intPreferencesKey("max_price")

        val POLLING_INTERVAL =
            longPreferencesKey("polling_interval")

    }



    val settings: Flow<UserSettings> =

        context.dataStore.data.map { preferences ->


            UserSettings(

                apiUser =
                    preferences[Keys.API_USER]
                        ?: "",


                secretKey =
                    preferences[Keys.SECRET_KEY]
                        ?: "",


                platform =
                    preferences[Keys.PLATFORM]
                        ?: "pc",


                botApp =
                    preferences[Keys.BOT_APP]
                        ?: "MyDGNBotV2",


                playerType =
                    preferences[Keys.PLAYER_TYPE]
                        ?: 2,


                minBuyPrice =
                    preferences[Keys.MIN_PRICE]
                        ?: 4000,


                maxBuyPrice =
                    preferences[Keys.MAX_PRICE]
                        ?: 300000,


                pollingInterval =
                    preferences[Keys.POLLING_INTERVAL]
                        ?: 10000L

            )

        }



    suspend fun saveSettings(
        settings: UserSettings
    ) {


        context.dataStore.edit { preferences ->


            preferences[Keys.API_USER] =
                settings.apiUser


            preferences[Keys.SECRET_KEY] =
                settings.secretKey


            preferences[Keys.PLATFORM] =
                settings.platform


            preferences[Keys.BOT_APP] =
                settings.botApp


            preferences[Keys.PLAYER_TYPE] =
                settings.playerType


            preferences[Keys.MIN_PRICE] =
                settings.minBuyPrice


            preferences[Keys.MAX_PRICE] =
                settings.maxBuyPrice


            preferences[Keys.POLLING_INTERVAL] =
                settings.pollingInterval

        }

    }

}
