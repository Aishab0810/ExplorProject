package com.example.exploraholic

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Pmpml : AppCompatActivity() {

    private lateinit var location1: ImageView
    private lateinit var logout1: ImageView
    private lateinit var homee1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pmpml)

        location1 = findViewById(R.id.location)
        logout1 = findViewById(R.id.log_out)
        homee1 = findViewById(R.id.homee)

        val location1 = findViewById(R.id.location) as ImageView
        // set on-click listener
        location1.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))
            Toast.makeText(this@Pmpml, "Map", Toast.LENGTH_SHORT).show()
        }

        val logout1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        logout1.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
            Toast.makeText(this@Pmpml, "Logout", Toast.LENGTH_SHORT).show()
        }

        val home11 = findViewById(R.id.homee) as ImageView
        // set on-click listener
        home11.setOnClickListener {
            startActivity(Intent(this,Dashboard::class.java))
            Toast.makeText(this@Pmpml, "Homepage", Toast.LENGTH_SHORT).show()
        }
    }
}