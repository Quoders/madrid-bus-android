package com.quoders.android.app.madridbus.ui.around

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.quoders.android.app.madridbus.R

class AroundMeFragment : Fragment(), OnMapReadyCallback {

    companion object {
        fun newInstance() = AroundMeFragment()
    }

    private lateinit var viewModel: AroundMeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.around_me_fragment, container, false)
        initialiseMapFragment()
        return view
    }

    private fun initialiseMapFragment() {
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapAround) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.isIndoorEnabled
    }

}
