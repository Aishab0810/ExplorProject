package com.example.exploraholic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val Mahabaleshwar = LatLng( 17.921721,73.655602)
        mMap.addMarker(MarkerOptions().position(Mahabaleshwar).title("Marker in Mahabaleshwar"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mahabaleshwar))

        val TigerHill = LatLng( 18.74220901,73.405119945)
        mMap.addMarker(MarkerOptions().position(TigerHill).title("Marker in TigerHill"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TigerHill))

        val Rajgad = LatLng(  18.516726,73.856255)
        mMap.addMarker(MarkerOptions().position(Rajgad).title("Marker in Rajgad"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rajgad))

        val Lohgad = LatLng( 18.694317,73.487259)
        mMap.addMarker(MarkerOptions().position(Lohgad).title("Marker in Lohgad"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Lohgad))

        val Khadakwasla = LatLng( 18.50305,73.90075)
        mMap.addMarker(MarkerOptions().position(Khadakwasla).title("Marker in Khadakwasla"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Khadakwasla))

        val Mulashi = LatLng( 18.505007,73.518105)
        mMap.addMarker(MarkerOptions().position(Mulashi).title("Marker in Mulashi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mulashi))
    }
}