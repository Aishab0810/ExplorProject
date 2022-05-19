package com.example.exploraholic.Dashboard

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.MainScreens.LoginScreen
import com.example.exploraholic.R
import pl.droidsonroids.gif.GifImageView


class Info : AppCompatActivity() {

    private lateinit var pune_id1: TextView
    private lateinit var iv11: GifImageView
    private lateinit var homee: ImageView
    private lateinit var log_out: ImageView

//    private lateinit var logout1: ImageView
//    private lateinit var homee1: ImageView

    private lateinit var infm1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        pune_id1 = findViewById(R.id.pune_id)
        iv11 = findViewById(R.id.histg)
        infm1 = findViewById(R.id.infm)
        homee = findViewById(R.id.homee)
        log_out = findViewById(R.id.log_out)

        homee.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
        }

        log_out.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
        }

//        logout1 = findViewById(R.id.log_out)
//        homee1 = findViewById(R.id.homee)

        infm1.setMovementMethod(ScrollingMovementMethod())


//        val logout1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
//        logout1.setOnClickListener {
//            startActivity(Intent(this, LoginScreen::class.java))
//            Toast.makeText(this@Info,"Logged out",Toast.LENGTH_SHORT).show()
//        }
//
////        val home11 = findViewById(R.id.homee) as ImageView
//        // set on-click listener
//        homee1.setOnClickListener {
//            startActivity(Intent (this,Dashboard::class.java))
//            Toast.makeText(this@Info,"Dashboard",Toast.LENGTH_SHORT).show()
//        }
    }
}