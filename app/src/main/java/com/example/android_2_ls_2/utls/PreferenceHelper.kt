package com.example.android_2_ls_2.utls

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {

    private lateinit var sharePreference: SharedPreferences

    fun unit(context: Context) {
        sharePreference = context.getSharedPreferences("setting", Context.MODE_PRIVATE)
    }

    var onSaveOnBoardState: Boolean
        set(value) = sharePreference.edit().putBoolean("yes", value).apply()
        get() = sharePreference.getBoolean("yes", true)
}