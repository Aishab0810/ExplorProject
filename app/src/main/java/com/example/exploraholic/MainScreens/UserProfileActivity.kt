package com.example.exploraholic.MainScreens

import android.app.Dialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.R
import com.example.exploraholic.databinding.ActivityUserProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.File

class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUserProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var dialog: Dialog
    private lateinit var user: User
    private lateinit var uid : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        uid = auth.currentUser?.uid.toString()

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        if (uid.isNotEmpty()){

            getuserData()

        }


    }

    private fun getuserData() {
        showProgressBar()
        databaseReference.child(uid).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                user = snapshot.getValue(User::class.java)!!
                binding.name.setText(user.firstname + " " + user.lastname)
                getUserProfile()
            }

            override fun onCancelled(error: DatabaseError) {
                hideProgressBar()
                Toast.makeText(this@UserProfileActivity,"Failed to get user profile data ",Toast.LENGTH_SHORT).show()
            }


        })
    }

    private fun getUserProfile() {
        storageReference = FirebaseStorage.getInstance().reference.child("Users/"+auth.currentUser?.uid+"jpg")
        val localFile = File.createTempFile( "tempImg", "jpg")
        storageReference.getFile(localFile).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
            binding.IVPreviewImage.setImageBitmap(bitmap)
            hideProgressBar()

        }.addOnFailureListener{
            hideProgressBar()
            Toast.makeText(this@UserProfileActivity,"Failed to retrive image",Toast.LENGTH_SHORT).show()

        }
    }

    private fun showProgressBar(){
        dialog = Dialog(this@UserProfileActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_wait)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }

    private fun hideProgressBar(){
        dialog.dismiss()
    }

}