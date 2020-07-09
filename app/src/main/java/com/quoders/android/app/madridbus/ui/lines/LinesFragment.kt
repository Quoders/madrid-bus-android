package com.quoders.android.app.madridbus.ui.lines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController

import com.quoders.android.app.madridbus.R
import com.quoders.android.app.madridbus.core.functional.Failure
import kotlinx.android.synthetic.main.lines_fragment.*

class LinesFragment : Fragment() {

    private val viewModel by viewModels<LinesViewModel>()
    private val linesAdapter: LinesAdapter = LinesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lines_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewLines.adapter = linesAdapter

        linesAdapter.setClickListener {
/*
            val navDirections =
                LinesFragmentDirections.actionAlbumListToAlbumDetail(it.name, it.number)

            findNavController().navigate(navDirections)
*/
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
