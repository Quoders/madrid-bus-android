package com.quoders.android.app.madridbus.ui.lines

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.quoders.android.app.madridbus.core.functional.Either
import com.quoders.android.app.madridbus.core.functional.Failure
import com.quoders.android.app.madridbus.domain.lines.GetAllLinesInteractor

class LinesViewModel @ViewModelInject constructor(private val getAllLinesInteractor: GetAllLinesInteractor) :
    ViewModel() {

    private val _lineList = MutableLiveData<Either<Failure, List<LineViewData>>>()
    val lineList = _lineList as LiveData<Either<Failure, List<LineViewData>>>

    init {
        getAllLinesInteractor.getAllLines()
    }

    private fun displayErrorState(failure: Failure) {

    }

    private fun displayLineList(s: String) {

    }

}
