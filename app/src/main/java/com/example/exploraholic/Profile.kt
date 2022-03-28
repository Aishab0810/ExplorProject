package com.example.exploraholic

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import androidx.appcompat.app.ActionBar
import com.example.exploraholic.databinding.ActivityProfileBinding
import com.example.exploraholic.databinding.ActivityRegisterScreenBinding
import com.google.firebase.auth.FirebaseAuth

class Profile : AppCompatActivity() {
    //viewBinding
    private lateinit var binding: ActivityProfileBinding
    //actionBar
    //private lateinit var actionBar: ActionBar
    //progressDialog
//    private lateinit var progressDialog: ProgressDialog
    //firebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure actionbar, enable back button
//        actionBar = supportActionBar!!
//        actionBar.title ="Profile"

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //handle click logout
        binding.logout.setOnClickListener{
            firebaseAuth.signOut()
            checkUser()
        }
    }

    private fun checkUser() {
        //check user is logged in or not
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            //user not null, user logged in, get user info
            val email =firebaseUser.email
                //set to text view
            binding.emailTv.text=email
        }
        else{
            //user is null, user is not logged in, goto login activity
            startActivity(Intent(this,LoginScreen::class.java))
            finish()
        }
    }
}