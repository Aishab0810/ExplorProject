package com.example.exploraholic.Dashboard

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.MainScreens.LoginScreen
import com.example.exploraholic.R
import pl.droidsonroids.gif.GifImageView


class Info : AppCompatActivity() {

    private lateinit var pune_id1: TextView
    private lateinit var iv11: GifImageView
    private lateinit var logout1: ImageView
    private lateinit var homee1: ImageView
    private lateinit var infm1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        pune_id1 = findViewById(R.id.pune_id)
        logout1 = findViewById(R.id.log_out)
        iv11 = findViewById(R.id.histg)
        infm1 = findViewById(R.id.infm)
        homee1 = findViewById(R.id.homee)

        infm1.setMovementMethod(ScrollingMovementMethod())


        val logout1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        logout1.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            Toast.makeText(this@Info, "Logout", Toast.LENGTH_SHORT).show()
        }

        val homee1 = findViewById(R.id.homee) as ImageView
        // set on-click listener
        homee1.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this@Info, "Homepage", Toast.LENGTH_SHORT).show()
        }
    }
}