package com.example.exploraholic

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity(){

    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var img5: ImageView
    private lateinit var img6: ImageView
    private lateinit var img7: ImageView
    private lateinit var img8: ImageView
    private lateinit var img9: ImageView
    private lateinit var img10: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        img1 = findViewById(R.id.history)
        img2 = findViewById(R.id.pmpml)
        img3 = findViewById(R.id.hospitals)
        img4 = findViewById(R.id.cafe)
        img5 = findViewById(R.id.temple)
        img6 = findViewById(R.id.hotel)
        img7 = findViewById(R.id.places)
        img8 = findViewById(R.id.log_out)
        img9 = findViewById(R.id.location)
        img1 = findViewById(R.id.profile)

        // get reference to textview

        val img1 = findViewById(R.id.history) as ImageView
        // set on-click listener
        img1.setOnClickListener {
            startActivity(Intent(this,Info::class.java))
            Toast.makeText(this@Dashboard, "History", Toast.LENGTH_SHORT).show()
        }

        val img2 = findViewById(R.id.pmpml) as ImageView
        // set on-click listener
        img2.setOnClickListener {
            startActivity(Intent(this,Pmpml::class.java))
            Toast.makeText(this@Dashboard, "PMPML", Toast.LENGTH_SHORT).show()
        }

        val img3 = findViewById(R.id.hospitals) as ImageView
        // set on-click listener
        img3.setOnClickListener {
            startActivity(Intent(this,Hospitals::class.java))
            Toast.makeText(this@Dashboard, "Hospitals", Toast.LENGTH_SHORT).show()
        }

        val img4 = findViewById(R.id.cafe) as ImageView
        // set on-click listener
        img4.setOnClickListener {
            startActivity(Intent(this,Cafe::class.java))
            Toast.makeText(this@Dashboard, "Cafes", Toast.LENGTH_SHORT).show()
        }

        val img5 = findViewById(R.id.temple) as ImageView
        // set on-click listener
        img5.setOnClickListener {
            startActivity(Intent(this,Temple::class.java))
            Toast.makeText(this@Dashboard, "Temples", Toast.LENGTH_SHORT).show()
        }

        val img6 = findViewById(R.id.hotel) as ImageView
        // set on-click listener
        img6.setOnClickListener {
            startActivity(Intent(this,Hotel::class.java))
            Toast.makeText(this@Dashboard, "Hotels", Toast.LENGTH_SHORT).show()
        }

        val img7 = findViewById(R.id.places) as ImageView
        // set on-click listener
        img7.setOnClickListener {
            startActivity(Intent(this,HomePage::class.java))
            Toast.makeText(this@Dashboard, "Places", Toast.LENGTH_SHORT).show()
        }

        val img8 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        img8.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
            Toast.makeText(this@Dashboard, "Logout", Toast.LENGTH_SHORT).show()
        }

        val img9 = findViewById(R.id.location) as ImageView
        // set on-click listener
        img9.setOnClickListener {
            startActivity(Intent(this,MapsActivity::class.java))

            Toast.makeText(this@Dashboard, "Map", Toast.LENGTH_SHORT).show()
        }

        val img10 = findViewById(R.id.profile) as ImageView
        // set on-click listener
        img10.setOnClickListener {
            startActivity(Intent(this,Profile::class.java))

            Toast.makeText(this@Dashboard, "Profile", Toast.LENGTH_SHORT).show()
        }
    }
}