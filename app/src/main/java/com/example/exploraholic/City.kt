package com.example.exploraholic

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class City : AppCompatActivity(){

//    private lateinit var mMap: GoogleMap
//
//    val Mahabaleshwar = LatLng( 17.921721,73.655602)
//    val TigerHill = LatLng( 18.74220901,73.405119945)
//    val Rajgad = LatLng(  21.17855,80.40143)
//    val Lohgad = LatLng( 18.694317,73.487259)
//    val Khadakwasla = LatLng( 18.50305,73.90075)
//    val Mulashi = LatLng( 18.505007,73.518105)

   // private var locationArrayList: ArrayList<LatLng>?= null

    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var text3: TextView
    private lateinit var image1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

//        val map = supportFragmentManager
//            .findFragmentById(R.id.myMap) as SupportMapFragment
//        map.getMapAsync(this)
//
//        locationArrayList = ArrayList()
//
//        locationArrayList!!.add(Mahabaleshwar)
//        locationArrayList!!.add(TigerHill)
//        locationArrayList!!.add(Rajgad)
//        locationArrayList!!.add(Lohgad)
//        locationArrayList!!.add(Khadakwasla)
//        locationArrayList!!.add(Mulashi)

        text1 = findViewById(R.id.placesText)
        text2 = findViewById(R.id.mapText)
        text3 = findViewById(R.id.infoText)
        image1 = findViewById(R.id.log_out)

        // get reference to textview
        val text1 = findViewById(R.id.placesText) as TextView
        // set on-click listener
        text1.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))

            Toast.makeText(this@City, "Map", Toast.LENGTH_SHORT).show()
        }

        val text2 = findViewById(R.id.mapText) as TextView
        // set on-click listener
        text2.setOnClickListener {
            startActivity(Intent(this,HomePage::class.java))
            Toast.makeText(this@City, "Places", Toast.LENGTH_SHORT).show()
        }

        val text3 = findViewById(R.id.infoText) as TextView
        // set on-click listener
        text3.setOnClickListener {
            startActivity(Intent(this,Info::class.java))
            Toast.makeText(this@City, "Information", Toast.LENGTH_SHORT).show()
        }

        val image1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        image1.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
            Toast.makeText(this@City, "Logout", Toast.LENGTH_SHORT).show()
        }
    }

//    override fun onMapReady(googleMap: GoogleMap) {
//
//        mMap = googleMap
//
//        for (i in locationArrayList!!.indices){
//
//            mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Marker"))
//            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!![i]))
//        }
//
//    }
}