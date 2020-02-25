package com.quoders.android.app.madridbus.ui.lines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quoders.android.app.madridbus.core.functional.Either
import com.quoders.android.app.madridbus.core.functional.Failure
import com.quoders.android.app.madridbus.data.login.LoginRepositoryImpl
import javax.inject.Inject

class LinesViewModel @Inject constructor() :
    ViewModel() {

    private val mutableLineList = MutableLiveData<Either<Failure, List<LineViewData>>>()
    val lineList = mutableLineList as LiveData<Either<Failure, List<LineViewData>>>

    private fun displayErrorState(failure: Failure) {

    }

    private fun displayLineList(s: String) {

    }

}
