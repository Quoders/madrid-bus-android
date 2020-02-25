package com.quoders.android.app.madridbus.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.quoders.android.app.madridbus.R
import com.quoders.android.app.madridbus.core.functional.observe
import com.quoders.android.app.madridbus.core.functional.viewModel
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()

        viewModel = viewModel(viewModelFactory) {
        }
    }


    private fun setupBottomNavigation() {
        val navController = navHostFragment.findNavController()
        bottomNavViewHome.setupWithNavController(navController)
    }
}
