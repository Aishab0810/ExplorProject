package com.example.exploraholic.Dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exploraholic.Adapter.CustomAdapter
import com.example.exploraholic.DataClass.ItemsViewModel
import com.example.exploraholic.MainScreens.LoginScreen
import com.example.exploraholic.MapScreen.MapWithSearchbar
import com.example.exploraholic.R
import pl.droidsonroids.gif.GifImageView

class Hospitals : AppCompatActivity() {

    private lateinit var location1: ImageView
    private lateinit var logout1: ImageView
    private lateinit var homee1: ImageView
    private lateinit var hospital: GifImageView

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemsViewModel>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospitals)

        imageId = arrayOf(
            R.drawable.hp1, R.drawable.hp2, R.drawable.hp3, R.drawable.hp4, R.drawable.hp5,
            R.drawable.hp6, R.drawable.hp7, R.drawable.hp8, R.drawable.hp9, R.drawable.hp10,
        )
        heading = arrayOf("Jehangir Hospital,32, Sasoon Rd, Opposite Railway Station, Central Excise Colony, Sangamvadi, Pune 411001",
            "Sahyadri Hospital,near Hermes Heritage Phase II, Hermes Heritage Society Phase 1, Shastrinagar, Yerawada, Pune 411006",
            "Deccan Hardikar Hospital, 1160/61, University Rd, Revenue Colony, Shivajinagar, Pune 411005",
            "Manipal Hospital, 22, 2A, Mundhwa - Kharadi Rd, Near Nyati Empire, Santipur, Thite Nagar, Kharadi, Pune 411014",
            "Shree Hospital, Nagar Rd, Opp Aga Khan Palace, Hermes Heritage Phase 2, Hermes Heritage Society Phase 1, Shastrinagar, Yerawada, Pune 411006",
            "Ranka Hospital, 157 / 5, SS Dhage Rd, near Swargate, Mukund Nagar, Pune, Maharashtra 411037",
            "Ruby Hall Clinic, 40, Sasoon Rd, Sangamvadi, Pune, Maharashtra 411001",
            "Apollo Spectra Hospitals, Saras Baug Rd, opp. Sanas Play Ground, Vijayanagar Colony, Sadashiv Peth, Pune 411030",
            "N. M. Wadia Hospital, 32, Sasoon Rd, Central Excise Colony, Sangamvadi, Pune, Maharashtra 411001",
            "Nobel hospital, 153, Magarpatta Rd, Magarpatta, Hadapsar, Pune, Maharashtra 411013")

        // getting the recyclerview by its id
        newRecyclerView = findViewById(R.id.recyclerview)

        // this creates a vertical layout Manager
        newRecyclerView.layoutManager = LinearLayoutManager(this)

        //If we have a RecyclerView with match_parent as height/width, we should add setHasFixedSize(true) since the size of the RecyclerView itself does not change inserting or deleting items into it.
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<ItemsViewModel>()

        getUserData()

        location1 = findViewById(R.id.location)
        logout1 = findViewById(R.id.log_out)
        homee1 = findViewById(R.id.homee)
        hospital = findViewById(R.id.hospg)

        val url =
            "https://firebasestorage.googleapis.com/v0/b/exploraholic-a1daf.appspot.com/o/Gif's%2Fhospg.gif?alt=media&token=b4f5f28f-6b8f-4dd1-a6cf-8da2ed79cd6e"
        Glide.with(applicationContext).load(url).into(hospital)

        val location1 = findViewById(R.id.location) as ImageView
        // set on-click listener
        location1.setOnClickListener {
            startActivity(Intent(this, MapWithSearchbar::class.java))
            Toast.makeText(this@Hospitals, "Map", Toast.LENGTH_SHORT).show()
        }

        val logout1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        logout1.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            Toast.makeText(this@Hospitals, "Logout", Toast.LENGTH_SHORT).show()
        }

        val home11 = findViewById(R.id.homee) as ImageView
        // set on-click listener
        home11.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this@Hospitals, "Homepage", Toast.LENGTH_SHORT).show()
        }
    }



    private fun getUserData() {

        for(i in imageId.indices){
            val itemsViewModel = ItemsViewModel(imageId[i],heading[i])
            newArrayList.add(itemsViewModel)
        }

        newRecyclerView.adapter = CustomAdapter(newArrayList)

    }
}