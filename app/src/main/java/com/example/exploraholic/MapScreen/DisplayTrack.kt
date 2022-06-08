package com.example.exploraholic.MapScreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.R

class DisplayTrack : AppCompatActivity() {

    //Initialize the variables
    private lateinit var source : EditText
    private lateinit var dest : EditText
    private lateinit var track : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_track)

        //Assign the variables
        source = findViewById(R.id.et_source)
        dest = findViewById(R.id.et_destination)
        track = findViewById(R.id.bt_track)

        track.setOnClickListener{
            startActivity(Intent(this, MapsActivity::class.java))
            Toast.makeText(this@DisplayTrack, "Your location with map", Toast.LENGTH_SHORT).show()
        }
    }
}