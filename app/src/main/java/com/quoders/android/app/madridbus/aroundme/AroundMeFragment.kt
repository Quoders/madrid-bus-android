package com.quoders.android.app.madridbus.aroundme

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.quoders.android.app.madridbus.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class AroundMeFragment : Fragment(), OnMapReadyCallback {

    private val viewModel by viewModels<AroundMeViewModel>()
    private var locationPermissionGranted: Boolean = false
    private var googleMap: GoogleMap? = null
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var lastKnownLocation: Location? = null
    private val defaultLocation = LatLng(40.416819, -3.703792)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.around_me_fragment, container, false)
        initialiseMapFragment()
        return view
    }

    private fun initialiseMapFragment() {
        val mapFragment =
            childFragmentManager.findFragmentById(R.id.mapAround) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())

        getLocationPermission()
    }

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map
        googleMap?.isMyLocationEnabled = true

    }

    private fun getLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            == PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionGranted = true
            getDeviceLocation()
            updateLocationUI()
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
            )
        }
    }

    private fun updateLocationUI() {
        try {
            if (locationPermissionGranted) {
                googleMap?.isMyLocationEnabled = true
                googleMap?.uiSettings?.isMyLocationButtonEnabled = true
            } else {
                googleMap?.isMyLocationEnabled = false
                googleMap?.uiSettings?.isMyLocationButtonEnabled = false
                lastKnownLocation = null
                getLocationPermission()
            }
        } catch (e: SecurityException) {
            Timber.e(e)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        locationPermissionGranted = false

        if (requestCode == PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION) {
            if (grantResults.isNotEmpty()
                && grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                locationPermissionGranted = true
                updateLocationUI()
                getDeviceLocation()
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getDeviceLocation() {

        try {
            if (locationPermissionGranted) {
                val locationResult = fusedLocationProviderClient.lastLocation
                locationResult.addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        lastKnownLocation = task.result
                        googleMap?.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(
                                LatLng(
                                    lastKnownLocation?.latitude!!,
                                    lastKnownLocation?.longitude!!
                                ),
                                DEFAULT_MAP_ZOOM
                            )
                        )
                    } else {
                        Timber.i("Unable to get device location")
                        googleMap?.moveCamera(
                            CameraUpdateFactory.newLatLngZoom(defaultLocation,
                                DEFAULT_MAP_ZOOM
                            )
                        )
                        googleMap?.uiSettings?.isMyLocationButtonEnabled = false
                    }
                }
            }

        } catch (exception: Exception) {
            Timber.e(exception)
        }
    }

    companion object {
        private const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0x0001
        private const val DEFAULT_MAP_ZOOM = 17f

        fun newInstance() =
            AroundMeFragment()
    }
}
