package com.quoders.android.app.madridbus.ui.lines

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quoders.android.app.madridbus.core.functional.Either
import com.quoders.android.app.madridbus.core.functional.Failure

class LinesViewModel @ViewModelInject constructor() :
    ViewModel() {

    private val mutableLineList = MutableLiveData<Either<Failure, List<LineViewData>>>()
    val lineList = mutableLineList as LiveData<Either<Failure, List<LineViewData>>>

    private fun displayErrorState(failure: Failure) {

    }

    private fun displayLineList(s: String) {

    }

}
