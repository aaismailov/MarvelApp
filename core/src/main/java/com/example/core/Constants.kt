package com.example.core

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com/v1/public/"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val PUBLIC_KEY = "cd04ad75a1def81c6df1e547a1f8b04b"
        private const val PRIVATE_KEY = "029236ac6b4e0ae7b03bd951b0e956f06be3340e"

        fun hash(): String {
            val input = "$timeStamp$PRIVATE_KEY$PUBLIC_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }

    object HttpKeys {
        const val API_KEY = "apikey"
        const val TIMESTAMP = "ts"
        const val HASH_KEY = "hash"
    }

    object DatabaseConstants {
        const val DATABASE_NAME = "marvel_database"
        const val TABLE_NAME = "character_table"
        const val VERSION = 2
    }

    object ThemeConstants {
        const val LIGHT = "light"
        const val DARK = "dark"
    }
}