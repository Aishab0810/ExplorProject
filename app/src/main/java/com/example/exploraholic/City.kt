package com.example.exploraholic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class City : AppCompatActivity() {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var image1 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)

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
}