package com.example.exploraholic

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class Profile : AppCompatActivity() {

    private lateinit var binding : ActivityProfileBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference : DatabaseReference
    private lateinit var storageReference: StorageReference
    private lateinit var imageUri : Uri
    private lateinit var dialog : Dialog
    private lateinit var dashboard : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dashboard = findViewById(R.id.Dashboard)

        dashboard.setOnClickListener {
            startActivity(Intent(this,Dashboard::class.java))
        }

        auth =FirebaseAuth.getInstance()
        val uid = auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        binding.saveBtn.setOnClickListener{

            showProgressBar()
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastName.text.toString()
            val email = binding.etEmail.text.toString()

            val user = User(firstName,lastName,email)
            if (uid !=null){

                databaseReference.child(uid).setValue(user).addOnCompleteListener {

                    if (it.isSuccessful){
                        uploadProfilePic()
                    }
                    else{

                        hideProgressBar()
                        Toast.makeText(this@Profile,"Failed to update the profile",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun uploadProfilePic() {

        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.profile}")
        storageReference = FirebaseStorage.getInstance().getReference("Users/"+auth.currentUser?.uid)
        storageReference.putFile(imageUri).addOnSuccessListener {

            hideProgressBar()
            Toast.makeText(this@Profile,"Profile successfully updated",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener{

            hideProgressBar()
            Toast.makeText(this@Profile,"Failed to update the Image",Toast.LENGTH_SHORT).show()
        }
    }

    private fun showProgressBar(){

        dialog = Dialog(this@Profile)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_wait)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }

    private fun hideProgressBar(){
        dialog.dismiss()
    }
}