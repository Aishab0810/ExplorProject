package com.example.exploraholic

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Info : AppCompatActivity() {

    private lateinit var pune_id1: TextView
    private lateinit var log_out1: ImageView
    private lateinit var iv11: ImageView
    private lateinit var infm1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        pune_id1 = findViewById(R.id.pune_id)
        log_out1 = findViewById(R.id.log_out)
        iv11 = findViewById(R.id.iv1)
        infm1 = findViewById(R.id.infm)


        val image1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        image1.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
            Toast.makeText(this@Info, "Logout", Toast.LENGTH_SHORT).show()
        }
    }
}