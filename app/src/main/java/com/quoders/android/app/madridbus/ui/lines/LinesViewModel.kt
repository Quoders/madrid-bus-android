package com.quoders.android.app.madridbus.ui.lines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.quoders.android.app.madridbus.core.functional.Failure
import com.quoders.android.app.madridbus.data.LoginRepositoryImpl
import kotlinx.coroutines.launch
import javax.inject.Inject

class LinesViewModel @Inject constructor(private val loginRepository: LoginRepositoryImpl) :
    ViewModel() {

    fun doLogin() {

        viewModelScope.launch {
            val userToken = loginRepository.getUserToken(
                "",
                ""
            )

            userToken.fold(::displayErrorState, ::displayLineList)
        }
    }

    private fun displayErrorState(failure: Failure) {

    }

    private fun displayLineList(s: String) {

    }

}
