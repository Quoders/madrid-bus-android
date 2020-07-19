package com.quoders.android.app.madridbus.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoders.android.app.madridbus.login.GetUserTokenInteractor
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val getUserTokenInteractor: GetUserTokenInteractor) :
    ViewModel() {

    init {
        viewModelScope.launch {
            val authToken = getUserTokenInteractor.execute()
        }
    }
}