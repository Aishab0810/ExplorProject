package com.example.exploraholic.MapScreen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.R
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

    lateinit var mapFragment : SupportMapFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            mMap = it
            Log.d("GoogleMap", "before isMyLocationEnabled")
//            googleMap.isMyLocationEnabled = true
            val location1 = LatLng(18.5204, 73.8567)
            mMap.addMarker(MarkerOptions().position(location1).title("My Location"))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location1, 5f))

            Log.d("GoogleMap", "before Mahabaleshwar")
            val location2 = LatLng(17.921721, 73.655602)
            mMap.addMarker(MarkerOptions().position(location2).title("Mahabaleshwar"))

            Log.d("GoogleMap", "before TigerHill")
            val location3 = LatLng(18.74220901, 73.405119945)
            mMap.addMarker(MarkerOptions().position(location3).title("Tiger Hill"))

            Log.d("GoogleMap", "before Rajgad")
            val location4 = LatLng(18.516726, 73.856255)
            mMap.addMarker(MarkerOptions().position(location4).title("Rajgad"))

            Log.d("GoogleMap", "before Lohgad")
            val location5 = LatLng(18.694317, 73.487259)
            mMap.addMarker(MarkerOptions().position(location5).title("Lohgad"))

            Log.d("GoogleMap", "before Khadakwasla")
            val location6 = LatLng(18.50305, 73.90075)
            mMap.addMarker(MarkerOptions().position(location3).title("Khadakwasla"))

            Log.d("GoogleMap", "before Mulashi")
            val location7 = LatLng(18.505007, 73.518105)
            mMap.addMarker(MarkerOptions().position(location7).title("Mulashi"))

        } )
    }
    fun getDirectionURL(origin:LatLng,dest:LatLng) : String{
        return "https://maps.googleapis.com/maps/api/directions/json?origin=${origin.latitude},${origin.longitude}&destination=${dest.latitude},${dest.longitude}&sensor=false&mode=driving"
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
        val sydney = LatLng(33.8688, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val Pune = LatLng(18.5204, 73.8567)
        mMap.addMarker(MarkerOptions().position(Pune).title("Marker in Pune"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        val Mahabaleshwar = LatLng(17.921721, 73.655602)
        mMap.addMarker(MarkerOptions().position(Mahabaleshwar).title("Marker in Mahabaleshwar"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mahabaleshwar))

        val TigerHill = LatLng(18.74220901, 73.405119945)
        mMap.addMarker(MarkerOptions().position(TigerHill).title("Marker in TigerHill"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(TigerHill))

        val Rajgad = LatLng(18.516726, 73.856255)
        mMap.addMarker(MarkerOptions().position(Rajgad).title("Marker in Rajgad"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Rajgad))

        val Lohgad = LatLng(18.694317, 73.487259)
        mMap.addMarker(MarkerOptions().position(Lohgad).title("Marker in Lohgad"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Lohgad))

        val Khadakwasla = LatLng(18.50305, 73.90075)
        mMap.addMarker(MarkerOptions().position(Khadakwasla).title("Marker in Khadakwasla"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Khadakwasla))

        val Mulashi = LatLng(18.505007, 73.518105)
        mMap.addMarker(MarkerOptions().position(Mulashi).title("Marker in Mulashi"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Mulashi))


//        val startPoint = Location("Pune")
//        startPoint.setLatitude(18.5204)
//        startPoint.setLongitude(73.8567)
//
//        val endPoint = Location("Tiger Hill")
//        endPoint.setLatitude(18.74220901)
//        endPoint.setLongitude(73.405119945)
//
//        val distance: Float = startPoint.distanceTo(endPoint)

    }

}