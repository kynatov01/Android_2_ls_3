package com.example.android_2_ls_2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.android_2_ls_2.R
import com.example.android_2_ls_2.utls.PreferenceHelper

class MainActivity : AppCompatActivity() {

private val preferenceHelper = PreferenceHelper()
private lateinit var navController: NavController

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setupNavigation()
    isShown()
}

private fun isShown() {
    preferenceHelper.unit(this)
    if (!preferenceHelper.onSaveOnBoardState) {
        navController.navigate(R.id.homeFragment)
    } else {
        navController.navigate(R.id.onBoardFragment)
    }
}
private fun setupNavigation() {
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
    navController = navHostFragment.navController
}
}