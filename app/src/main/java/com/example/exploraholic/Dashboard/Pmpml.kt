package com.example.exploraholic.Dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exploraholic.Adapter.CustomAdapter
import com.example.exploraholic.DataClass.ItemsViewModel
import com.example.exploraholic.MainScreens.LoginScreen
import com.example.exploraholic.MapScreen.MapsActivity
import com.example.exploraholic.R

class Pmpml : AppCompatActivity() {

    private lateinit var location1: ImageView
    private lateinit var logout1: ImageView
    private lateinit var homee1: ImageView

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemsViewModel>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pmpml)

        imageId = arrayOf(R.drawable.bus, R.drawable.bus, R.drawable.bus,R.drawable.bus,R.drawable.bus,
            R.drawable.bus,R.drawable.bus,R.drawable.bus,R.drawable.bus,R.drawable.bus,
        )
        heading = arrayOf("301- Bhosari to Pimprigaon \n Morning 5.10 AM Two buses time between 0.15 Hours. Night at 10.35 Pm.",
            "80 - Garden city to MANAPA \n Morning 7.00 AM Two buses time between 0.15 Hours. Night at 10.00 Pm.",
            "305 - Wadgaon to Hinjewadi \n 	Morning 6.10Am Two buses time between 0.40 Hours. Night at 9.50Pm.",
            "98 - Warje to Wagholi \n Morning 6.00Am Two buses time between 0.30 Hours. Night at 10.00Pm.",
            "281 - Ganeshkhind to Warje \n Morning 6.10Am Two buses time between 0.40 Hours. Night at 9.50Pm.",
            "202 - Hadapsar to Karve road \n Morning 6.30Am Two buses time between 0.20 Hours. Night at 11.00Pm.",
            "115 - Katraj to Hinjewadi \n Morning 6.20Am Two buses time between 0.10 Hours. Night at 12.00Am.",
            "313 - Hadapsar to Kothrud \n Morning 7.20Am Two buses time between 0.10 Hours. Night at 11.00Pm.",
            "43 - Kothrud to Manapa \n Morning 6.00Am Two buses time between 0.10 Hours. Night at 12.00Am.",
            "144 - Saisayajinagar to Pune station \n Morning 6.20Am Two buses time between 0.10 Hours. Night at 12.00Am.")

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

        val location1 = findViewById(R.id.location) as ImageView
        // set on-click listener
        location1.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
            Toast.makeText(this@Pmpml, "Map", Toast.LENGTH_SHORT).show()
        }

        val logout1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        logout1.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            Toast.makeText(this@Pmpml, "Logout", Toast.LENGTH_SHORT).show()
        }

        val home11 = findViewById(R.id.homee) as ImageView
        // set on-click listener
        home11.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this@Pmpml, "Homepage", Toast.LENGTH_SHORT).show()
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