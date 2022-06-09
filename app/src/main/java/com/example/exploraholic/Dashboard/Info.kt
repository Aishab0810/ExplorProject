package com.example.exploraholic.Dashboard

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.exploraholic.MainScreens.LoginScreen
import com.example.exploraholic.R
import pl.droidsonroids.gif.GifImageView

class Info : AppCompatActivity() {

    private lateinit var pune_id1: TextView
    private lateinit var iv11: GifImageView
    private lateinit var homee: ImageView
    private lateinit var log_out: ImageView
    private lateinit var imageview8: ImageView
    private lateinit var imageview9: ImageView
    private lateinit var imageview10: ImageView
    private lateinit var imageview11: ImageView
    private lateinit var imageview12: ImageView
    private lateinit var imageview13: ImageView
    private lateinit var imageview14: ImageView

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
        imageview8 = findViewById(R.id.imageView8)
        imageview9 = findViewById(R.id.imageView9)
        imageview10 = findViewById(R.id.imageView10)
        imageview11 = findViewById(R.id.imageView11)
        imageview12 = findViewById(R.id.imageView12)
        imageview13 = findViewById(R.id.imageView13)
        imageview14 = findViewById(R.id.imageView14)

        homee.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
        }

        log_out.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
        }

        val url =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/Gif's%2Froad-trip.gif?alt=media&token=c44f2d06-dfe4-40d5-8ba5-e8e7915a0cef"
        Glide.with(applicationContext).load(url).into(iv11)

        val url1 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/wtrfl1.jpg?alt=media&token=d84ff509-be07-435c-8976-3889eb3b9b46" //Retrieved url as mentioned above
        Glide.with(applicationContext).load(url1).into(imageview8)

        val url2 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/mhill.JPG?alt=media&token=63edbd68-4ebd-4bb9-a01b-673b35e33184"
        Glide.with(applicationContext).load(url2).into(imageview9)

        val url3 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/frt1.jpg?alt=media&token=369247c7-3211-480a-87c4-4a6da06be9d4" //Retrieved url as mentioned above
        Glide.with(applicationContext).load(url3).into(imageview10)

        val url4 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/pune.JPG?alt=media&token=d9873d20-8f34-48ef-8772-44568a9f9597"
        Glide.with(applicationContext).load(url4).into(imageview11)

        val url5 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/rfort.JPG?alt=media&token=9158360a-0d60-4b5e-8c2c-b62d0389a15b"
        Glide.with(applicationContext).load(url5).into(imageview12)

        val url6 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/tighill.JPG?alt=media&token=80530df7-1313-45e1-b341-033bc4895d02"
        Glide.with(applicationContext).load(url6).into(imageview13)

        val url7 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/wtrfall.jpg?alt=media&token=cdd58eae-c016-4ce9-a85a-ee29b6b91e8a"
        Glide.with(applicationContext).load(url7).into(imageview14)


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