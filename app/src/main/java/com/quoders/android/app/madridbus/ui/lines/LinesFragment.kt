package com.quoders.android.app.madridbus.ui.lines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.quoders.android.app.madridbus.R
import com.quoders.android.app.madridbus.core.functional.*
import kotlinx.android.synthetic.main.lines_fragment.*
import javax.inject.Inject

class LinesFragment : InjectorBaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: LinesViewModel
    private lateinit var lineList: LiveData<Either<Failure, List<LineViewData>>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lines_fragment, container, false)

        recyclerViewLines.adapter = linesAdapter

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.doLogin()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = viewModel(viewModelFactory) {
            viewLifecycleOwner.observe(lineList, {
                it.fold(::showErrorState, ::showLineList)
            })
        }
    }

    private fun showLineList(list: List<LineViewData>) {

    }

    private fun showErrorState(failure: Failure) {

    }

    companion object {
        fun newInstance() = LinesFragment()
    }
}
