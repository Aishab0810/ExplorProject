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

class Cafe : AppCompatActivity() {

    private lateinit var location1: ImageView
    private lateinit var logout1: ImageView
    private lateinit var homee1: ImageView

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemsViewModel>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafe)

        imageId = arrayOf(R.drawable.cafe, R.drawable.cafe, R.drawable.cafe,R.drawable.cafe,R.drawable.cafe,
            R.drawable.cafe,R.drawable.cafe,R.drawable.cafe,R.drawable.cafe,R.drawable.cafe,
        )
            heading = arrayOf(
                "CAFE BEANS, near AADITYA GARDAN CITY,\n Aditya Garden City, Warje,\n Pune, Maharashtra 411058",
                "Grandmama's Cafe, Survey No.21,\n Koregaon Park, 394,\n S Main Rd, Pune, Maharashtra 411001",
                "Mocha LG 4/5 Power Plaza,\n Lane No. 7, Koregaon Park,\n Pune, Maharashtra 411001",
                "Irani Café Shop No 2, Turning Point 2,\n opp. Rosary School, Viman Nagar,\n Pune, Maharashtra 411014",
                "Pocket cafe, Shop No-7, Dodke Tower,\n Pune - Bengaluru Hwy, opposite Tata Motors,\n Giridhar Nagar, Warje",
                "Pagdandi - Books Chai Café, Shop 6,\n Regent Plaza, Baner Pashan Link Road,\n Behind Symantec, Baner, Pune",
                "Fat Cat's Café Shop no 5, Clover Heights Shopping, Salunke Vihar Road, Wanowrie",
                "Cafe Eastwood Chintamani Pride, Near Citypride, Kothrud, Pune",
                "Cafe Bread N Butter Shop 20, Swapnanagari, Karve Road, Erandwane, Pune",
                "Waari Book Café Off Karve Road, Kothrud, Pune"
            )

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
            Toast.makeText(this@Cafe, "Map", Toast.LENGTH_SHORT).show()
        }

        val logout1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        logout1.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            Toast.makeText(this@Cafe, "Logout", Toast.LENGTH_SHORT).show()
        }

        val home11 = findViewById(R.id.homee) as ImageView
        // set on-click listener
        home11.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this@Cafe, "Homepage", Toast.LENGTH_SHORT).show()
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