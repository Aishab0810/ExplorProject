package com.example.exploraholic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class City : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    val Mahabaleshwar = LatLng( 17.921721,73.655602)
    val TigerHill = LatLng( 18.74220901,73.405119945)
    val Rajgad = LatLng(  21.17855,80.40143)
    val Lohgad = LatLng( 18.694317,73.487259)
    val Khadakwasla = LatLng( 18.50305,73.90075)
    val Mulashi = LatLng( 18.505007,73.518105)

    private var locationArrayList: ArrayList<LatLng>?= null

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var image1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

        val map = supportFragmentManager
            .findFragmentById(R.id.myMap) as SupportMapFragment
        map.getMapAsync(this)

        locationArrayList = ArrayList()

        locationArrayList!!.add(Mahabaleshwar)
        locationArrayList!!.add(TigerHill)
        locationArrayList!!.add(Rajgad)
        locationArrayList!!.add(Lohgad)
        locationArrayList!!.add(Khadakwasla)
        locationArrayList!!.add(Mulashi)

        button1 = findViewById(R.id.b1)
        button2 = findViewById(R.id.b2)
        button3 = findViewById(R.id.b3)
        image1 = findViewById(R.id.log_out)

        // get reference to textview
        val button1 = findViewById(R.id.b1) as Button
        // set on-click listener
        button1.setOnClickListener {
            //startActivity(Intent(this,LoginScreen::class.java))
            Toast.makeText(this@City, "Map", Toast.LENGTH_SHORT).show()
        }

        val button2 = findViewById(R.id.b2) as Button
        // set on-click listener
        button2.setOnClickListener {
            startActivity(Intent(this,HomePage::class.java))
            Toast.makeText(this@City, "Places", Toast.LENGTH_SHORT).show()
        }

        val button3 = findViewById(R.id.b3) as Button
        // set on-click listener
        button3.setOnClickListener {
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

    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        for (i in locationArrayList!!.indices){

            mMap.addMarker(MarkerOptions().position(locationArrayList!![i]).title("Marker"))
            mMap.animateCamera(CameraUpdateFactory.zoomTo(18.0f))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locationArrayList!!.get(i)))
        }

    }
}