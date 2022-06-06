package com.example.exploraholic.Dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.exploraholic.MainScreens.LoginScreen
import com.example.exploraholic.MainScreens.Profile
import com.example.exploraholic.MapScreen.MapWithSearchbar
import com.example.exploraholic.R
import pl.droidsonroids.gif.GifImageView

class Dashboard : AppCompatActivity(){

//    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
//    private lateinit var drawerLayout: DrawerLayout
//    private lateinit var navigationView: NavigationView
//    private lateinit var navController: NavController
//    private lateinit var appBarConfiguration: AppBarConfiguration

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
    private lateinit var dash: GifImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

//        toolbar = findViewById(R.id.mytoolbar)
//        setSupportActionBar(toolbar)
//
//        drawerLayout = findViewById(R.id.drawer)
//        navigationView = findViewById(R.id.navigationView)
//
//        navController = findNavController(R.id.fragmentContainerView)
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.id_editProfile, R.id.id_city_info, R.id.id_mapWithSearchbar), drawerLayout)
//        setupActionBarWithNavController(navController, drawerLayout)
//        navigationView.setupWithNavController(navController)


        img1 = findViewById(R.id.history)
        img2 = findViewById(R.id.pmpml)
        img3 = findViewById(R.id.hospitals)
        img4 = findViewById(R.id.cafe)
        img5 = findViewById(R.id.temple)
        img6 = findViewById(R.id.hotel)
        img7 = findViewById(R.id.places)
        img8 = findViewById(R.id.log_out)
        img9 = findViewById(R.id.location)
        img10 = findViewById(R.id.profile)
        dash = findViewById(R.id.go)

        val url =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/Gif's%2Froad-trip.gif?alt=media&token=c44f2d06-dfe4-40d5-8ba5-e8e7915a0cef"
        Glide.with(applicationContext).load(url).into(dash)

        val url1 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/icons%2Fhistory.png?alt=media&token=d9d03c52-ce43-436b-b423-25b382789fe9"
        Glide.with(applicationContext).load(url1).into(img1)

        val url2 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/icons%2Fpmpml.png?alt=media&token=7c723149-dbe6-4de4-80eb-a9db39e22cfc"
        Glide.with(applicationContext).load(url2).into(img2)

        val url3 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/icons%2Fhospital.jpg?alt=media&token=d7defb88-aa05-42d1-8444-3dd3d728f910"
        Glide.with(applicationContext).load(url3).into(img3)

        val url4 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/icons%2Fcafe.jpg?alt=media&token=6190e85c-798d-4f18-97c8-c8b3c3daad26"
        Glide.with(applicationContext).load(url4).into(img4)

        val url5 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/icons%2Ftemple.jpg?alt=media&token=10a331be-249e-4464-ab42-c7062da348af"
        Glide.with(applicationContext).load(url5).into(img5)

        val url6 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/icons%2Ffood.png?alt=media&token=80597ed8-beef-48ca-b747-6f8ec99e5602"
        Glide.with(applicationContext).load(url6).into(img6)

        val url7 =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/icons%2Fplace.jpg?alt=media&token=bd71b5ed-36c7-4686-aab5-76522deaa387"
        Glide.with(applicationContext).load(url7).into(img7)

        // get reference to textview

        val img1 = findViewById(R.id.history) as ImageView
        // set on-click listener
        img1.setOnClickListener {
            startActivity(Intent(this, Info::class.java))
            Toast.makeText(this@Dashboard, "History", Toast.LENGTH_SHORT).show()
        }

        val img2 = findViewById(R.id.pmpml) as ImageView
        // set on-click listener
        img2.setOnClickListener {
            startActivity(Intent(this, Pmpml::class.java))
            Toast.makeText(this@Dashboard, "PMPML", Toast.LENGTH_SHORT).show()
        }

        val img3 = findViewById(R.id.hospitals) as ImageView
        // set on-click listener
        img3.setOnClickListener {
            startActivity(Intent(this, Hospitals::class.java))
            Toast.makeText(this@Dashboard, "Hospitals", Toast.LENGTH_SHORT).show()
        }

        val img4 = findViewById(R.id.cafe) as ImageView
        // set on-click listener
        img4.setOnClickListener {
            startActivity(Intent(this, Cafe::class.java))
            Toast.makeText(this@Dashboard, "Cafes", Toast.LENGTH_SHORT).show()
        }

        val img5 = findViewById(R.id.temple) as ImageView
        // set on-click listener
        img5.setOnClickListener {
            startActivity(Intent(this, Temple::class.java))
            Toast.makeText(this@Dashboard, "Temples", Toast.LENGTH_SHORT).show()
        }

        val img6 = findViewById(R.id.hotel) as ImageView
        // set on-click listener
        img6.setOnClickListener {
            startActivity(Intent(this, Hotel::class.java))
            Toast.makeText(this@Dashboard, "Hotels", Toast.LENGTH_SHORT).show()
        }

        val img7 = findViewById(R.id.places) as ImageView
        // set on-click listener
        img7.setOnClickListener {
            startActivity(Intent(this, HomePage::class.java))
            Toast.makeText(this@Dashboard, "Places", Toast.LENGTH_SHORT).show()
        }

        val img8 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        img8.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            Toast.makeText(this@Dashboard, "Logout", Toast.LENGTH_SHORT).show()
        }

        val img9 = findViewById(R.id.location) as ImageView
        // set on-click listener
        img9.setOnClickListener {
            startActivity(Intent(this, MapWithSearchbar::class.java))

            Toast.makeText(this@Dashboard, "Map", Toast.LENGTH_SHORT).show()
        }

        val img10 = findViewById(R.id.profile) as ImageView
        // set on-click listener
        img10.setOnClickListener {
            startActivity(Intent(this, Profile::class.java))

            Toast.makeText(this@Dashboard, "Profile", Toast.LENGTH_SHORT).show()
        }
//
//        fun onSupportNavigateUp(): Boolean{
//            val navController = findNavController(R.id.fragmentContainerView)
//            return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
//        }
    }

}