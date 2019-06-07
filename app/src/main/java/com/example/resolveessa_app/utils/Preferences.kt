package com.example.resolveessa_app.utils

import android.content.Context
import android.content.SharedPreferences

object Preferences {

    private lateinit var preferences: SharedPreferences

    fun getInstance(context: Context): Preferences {
        if (!this::preferences.isInitialized) preferences =
            context.getSharedPreferences("rosolve", Context.MODE_PRIVATE)
        return this
    }

    var token: String
        get() {
            return preferences.getString("token", null) ?: ""
        }
        set(value) {
            preferences.edit().putString("token", value).apply()
        }

    var isExistToken: Boolean = false
        get() = token.isNotEmpty()
        private set
}