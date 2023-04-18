package com.example.android_2_ls_2.utls

import android.app.Application

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initPref()
    }

    private fun initPref() {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.unit(this)
    }
}