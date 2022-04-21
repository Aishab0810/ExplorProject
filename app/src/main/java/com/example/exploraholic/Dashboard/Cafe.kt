package com.example.exploraholic.Dashboard

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.MainScreens.LoginScreen
import com.example.exploraholic.MapScreen.MapsActivity
import com.example.exploraholic.R

//import com.google.firebase.database.DataSnapshot
//import com.google.firebase.database.DatabaseError
//import com.google.firebase.database.FirebaseDatabase
//import com.google.firebase.database.ValueEventListener
//
//import com.squareup.picasso.Picasso;


class Cafe : AppCompatActivity() {

    // Initializing the ImageView
   // var rImage: ImageView? = null

    private lateinit var location1: ImageView
    private lateinit var logout1: ImageView
    private lateinit var homee1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cafe)

        location1 = findViewById(R.id.location)
        logout1 = findViewById(R.id.log_out)
        homee1 = findViewById(R.id.homee)

        // getting ImageView by its id
        //rImage = findViewById(R.id.rImage);

        // we will get the default FirebaseDatabase instance
        //val firebaseDatabase = FirebaseDatabase.getInstance()

        // we will get a DatabaseReference for the database root node
        //val databaseReference = firebaseDatabase.reference

        // Here "image" is the child node value we are getting
        // child node data in the getImage variable
        //val getImage = databaseReference.child("image")

        // Adding listener for a single change
        // in the data at this location.
        // this listener will triggered once
        // with the value of the data at the location
//        getImage.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                // getting a DataSnapshot for the location at the specified
//                // relative path and getting in the link variable
//                val link = dataSnapshot.getValue(String::class.java)
//
//                // loading that data into rImage
//                // variable which is ImageView
//                Picasso.get().load(link).into(rImage)
//            }
//
//            // this will called when any problem
//            // occurs in getting data
//            override fun onCancelled(databaseError: DatabaseError) {
//                // we are showing that error message in toast
//                Toast.makeText(this@Cafe, "Error Loading Image", Toast.LENGTH_SHORT).show()
//            }
//        })

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
}