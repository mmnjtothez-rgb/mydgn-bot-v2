package com.mydgnbot

import android.app.Application
import com.mydgnbot.core.AppContainer


class MyDGNBotApp : Application() {


    override fun onCreate() {

        super.onCreate()

        AppContainer.initialize(
            this
        )

    }

}
