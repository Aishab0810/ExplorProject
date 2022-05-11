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
import com.example.exploraholic.MapScreen.MapWithSearchbar
import com.example.exploraholic.R

class Hotel : AppCompatActivity() {

    private lateinit var location1: ImageView
    private lateinit var logout1: ImageView
    private lateinit var homee1: ImageView

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemsViewModel>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)

        imageId = arrayOf(R.drawable.food, R.drawable.food, R.drawable.food,R.drawable.food,R.drawable.food,
            R.drawable.food,R.drawable.food,R.drawable.food,R.drawable.food,R.drawable.food,
        )
        heading = arrayOf("Marriott Suites,  81, Mundhwa Rd, Fatima Nagar, Koregaon Park Annexe, Mundhwa, Pune, Maharashtra 411036",
            "Hotel Hyatt, Adjacent To Aga Khan Palace, 88, Nagar Rd, Kalyani Nagar, Pune, Maharashtra 411006",
            "Hotel Sudarshan, Plot No. 18, Clover Water Gardens, Lane Number 7, Kalyani Nagar, Pune, Maharashtra 411014",
            "Royal Orchid Golden Suites, adjacent to Kumar city Marisoft Annexe, Kalyani Nagar, Pune, Maharashtra 411014",
            "Blue Diamond, 11, Koregaon Park Rd, Vasani Nagar, Koregaon Park, Pune, Maharashtra 411001",
            "Conrad Hotel, 7, Mangaldas Rd, Sangamvadi, Pune, Maharashtra 411001",
            "Lemon Tree Premier, 15 & 15A City Center, 40, Connaught Rd, Modi Colony, Pune, Maharashtra 411001",
            "KB'S Woodland, B J Road Railway Station, Sadhu Vaswani Rd, near Pune, Maharashtra 411001",
            "Ratna Veg, Near Jakat Naka, Karvenagar Rd, Pune, Maharashtra 411052 ",
            "Swarna Vegitarian, Chaudhari heights, Near warje flyover, Warje Pune 411058")

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
            startActivity(Intent(this, MapWithSearchbar::class.java))
            Toast.makeText(this@Hotel, "Map", Toast.LENGTH_SHORT).show()
        }

        val logout1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        logout1.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            Toast.makeText(this@Hotel, "Logout", Toast.LENGTH_SHORT).show()
        }

        val home11 = findViewById(R.id.homee) as ImageView
        // set on-click listener
        home11.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this@Hotel, "Homepage", Toast.LENGTH_SHORT).show()
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