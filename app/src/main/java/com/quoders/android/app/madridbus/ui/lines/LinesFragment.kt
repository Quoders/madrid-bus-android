package com.quoders.android.app.madridbus.ui.lines

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.quoders.android.app.madridbus.R
import dagger.android.support.DaggerFragment

class LinesFragment : DaggerFragment() {

    companion object {
        fun newInstance() = LinesFragment()
    }

    private lateinit var viewModel: LinesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.lines_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LinesViewModel::class.java)

        viewModel.doLogin()
    }

}
