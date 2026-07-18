package com.mydgnbot.data.security

import java.security.MessageDigest

object HashGenerator {

    fun md5(text: String): String {

        val bytes = MessageDigest
            .getInstance("MD5")
            .digest(text.toByteArray())

        return bytes.joinToString("") {
            "%02x".format(it)
        }
    }

    fun createHash(
        platform: String,
        user: String,
        timestamp: Long,
        secretKey: String
    ): String {

        return md5(
            platform +
            user +
            timestamp +
            secretKey
        )

    }

}
