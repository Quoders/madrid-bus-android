package com.quoders.android.app.madridbus.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.quoders.android.app.madridbus.R
import com.quoders.android.app.madridbus.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()

    }


    private fun setupBottomNavigation() {
        val navController = navHostFragment.findNavController()
        bottomNavViewHome.setupWithNavController(navController)
    }
}
