package com.mydgnbot.ui.components.player


fun Any?.cardValueOrNull(): String {

    return this?.toString() ?: "-"

}
