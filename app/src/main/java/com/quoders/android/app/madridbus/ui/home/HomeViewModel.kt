package com.quoders.android.app.madridbus.ui.home

import androidx.lifecycle.ViewModel
import com.quoders.android.app.madridbus.data.login.LoginRepositoryImpl
import com.quoders.android.app.madridbus.domain.login.GetUserTokenInteractor
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val getUserTokenInteractor: GetUserTokenInteractor) :
    ViewModel() {


}