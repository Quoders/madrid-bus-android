package com.quoders.android.app.madridbus.ui.around

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.quoders.android.app.madridbus.R

class AroundMeFragment : Fragment() {

    companion object {
        fun newInstance() = AroundMeFragment()
    }

    private lateinit var viewModel: AroundMeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.around_me_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AroundMeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
