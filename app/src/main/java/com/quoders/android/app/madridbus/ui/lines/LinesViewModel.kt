package com.quoders.android.app.madridbus.ui.lines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoders.android.app.madridbus.data.LoginRepositoryImpl
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

class LinesViewModel @Inject constructor(private val loginRepository: LoginRepositoryImpl) :
    ViewModel() {

    fun doLogin() {

        viewModelScope.launch {
            val userToken = loginRepository.getUserToken(
                "",
                ""
            )

            if (userToken.isNotEmpty()) {
                Timber.i(userToken)
            }
        }
    }

}
