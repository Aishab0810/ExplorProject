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

class Temple : AppCompatActivity() {

    private lateinit var location1: ImageView
    private lateinit var logout1: ImageView
    private lateinit var homee1: ImageView

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<ItemsViewModel>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temple)

        imageId = arrayOf(R.drawable.temple, R.drawable.temple, R.drawable.temple,R.drawable.temple,R.drawable.temple,
            R.drawable.temple,R.drawable.temple,R.drawable.temple,R.drawable.temple,R.drawable.temple,
        )
        heading = arrayOf("Shri Chattushringi Devi Mandir, Gr Floor, Seva Samiti Building, Senapati Bapat Rd, Chattushringi, Pune, Maharashtra 411016",
            "Shreemant Dagdusheth Halwai Ganpati Mandir, Ganpati Bhavan, Chhatrapati Shivaji Maharaj Rd, Mehunpura, Budhwar Peth, Pune,411002",
            "Shree Omkareshwar Temple, Balgandharva Bridge, 233 Near, Chandrashekhar Govind Aapte Rd, Shaniwar Peth, Pune, Maharashtra 411030",
            "Shri Mahalaxmi Mandir, Shukrawar Peth - Mahatma Gandhi Rd, opposite Sarasbaug, Dadawadi, Ganesh Peth, Pune, Maharashtra 411002",
            "Iskon Temple, Katraj - Kondhwa Rd, Tilekar Nagar, Kondhwa Budruk, Pune, Maharashtra 411048",
            "Pataleshwar Temple, 1170/15B, Kushabhau Jejurikar Rd, Revenue Colony, Shivajinagar, Pune, Maharashtra 411005",
            "Shree Kasba Ganapati, 159, Kasba Peth Rd, Durvankur Society, Phadke Haud, Kasba Peth, Pune, Maharashtra 411011",
            "BAPS Swaminarayan Mandir, A1-B1, Mumbai-Bengaluru National Higway, 4, Narhe Ambegaon Rd, Narhe, Pune, Maharashtra 411041",
            "Shri Someshwar Mandir, Ward No. 8, Someshwarwadi, Pashan, Pune, Maharashtra 411008",
            "Sarasbaug Ganesh Temple, Survey no 2170 Saras Baug Road Opp. Nehru Stadium, Sadashiv Peth, Pune, Maharashtra 411030")

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
            Toast.makeText(this@Temple, "Map", Toast.LENGTH_SHORT).show()
        }

        val logout1 = findViewById(R.id.log_out) as ImageView
        // set on-click listener
        logout1.setOnClickListener {
            startActivity(Intent(this, LoginScreen::class.java))
            Toast.makeText(this@Temple, "Logout", Toast.LENGTH_SHORT).show()
        }

        val home11 = findViewById(R.id.homee) as ImageView
        // set on-click listener
        home11.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java))
            Toast.makeText(this@Temple, "Homepage", Toast.LENGTH_SHORT).show()
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