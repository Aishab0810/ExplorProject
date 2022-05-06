package com.example.exploraholic.MainScreens

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.Dashboard.Dashboard
import com.example.exploraholic.R
import com.example.exploraholic.databinding.ActivityEditProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import de.hdodenhof.circleimageview.CircleImageView

class EditProfile : AppCompatActivity() {
    // One Button
   private lateinit var bSelectImage: Button

    // One Preview Image
    private lateinit var iVPreviewImage: CircleImageView

    //binding
    private lateinit var binding: ActivityEditProfileBinding
    //instance of firebase auth
    private lateinit var auth: FirebaseAuth
    //define reference variable for the realtime database
    private lateinit var databaseReference: DatabaseReference
    //storage reference
    private lateinit var storageReference: StorageReference
    //image uri
    private lateinit var imageUri: Uri
    //dialog box
    private lateinit var dialog: Dialog

//    private lateinit var Name: TextInputLayout
//    private lateinit var Email: TextInputLayout
//    private lateinit var Address: TextInputLayout
//    private lateinit var gender: Spinner
//    private lateinit var Update: Button

    // constant to compare
    // the activity result code
//    var SELECT_PICTURE = 200
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)



        auth = FirebaseAuth.getInstance()
        val uid =  auth.currentUser?.uid
        databaseReference = FirebaseDatabase.getInstance().getReference("Users")


        binding.updatebtn.setOnClickListener {
            //here we get values of name,email,address and gender
            //when user click on update btn, it wil show progressbar
            showProgressBar()
            val Name = binding.name.editText.toString()
            val Email = binding.email.editText.toString()

            val user = User(Name, Email)
            if(uid != null ){

                databaseReference.child(uid).setValue(user).addOnCompleteListener {

                    if (it.isSuccessful){

                        uploadProfilePic()

                    }else{
                        hideProgressBar()
                        Toast.makeText(this@EditProfile,"Failed to update profile",Toast.LENGTH_SHORT).show()
                    }


                }

            }
        }



        // register the UI widgets with their appropriate IDs
        bSelectImage = findViewById(com.example.exploraholic.R.id.BSelectImage)
        iVPreviewImage = findViewById(com.example.exploraholic.R.id.IVPreviewImage)

//        Name = findViewById(R.id.name)
//        Email = findViewById(R.id.email)
//        Address = findViewById(R.id.address)
//        gender = findViewById(R.id.gender_spinner)
//        Update = findViewById(R.id.updatebtn)

//        Update.setOnClickListener {
//            startActivity(Intent(this, Dashboard::class.java))
//
//            Toast.makeText(this@EditProfile, "Profile Updated", Toast.LENGTH_SHORT).show()
//        }

//        // Create an ArrayAdapter for spinner
//        val adapter = ArrayAdapter.createFromResource(this,
//            R.array.gender_list, android.R.layout.simple_spinner_item)
//        // Specify the layout to use when the list of choices appears
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        // Apply the adapter to the spinner
//        gender.adapter = adapter
//
//        // handle the Choose Image button to trigger
//        // the image chooser function
//        bSelectImage.setOnClickListener(View.OnClickListener { imageChooser() })
    }

    private fun uploadProfilePic() {

        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.person}")
        storageReference = FirebaseStorage.getInstance().getReference("Users"+auth.currentUser?.uid+".jpg")
        storageReference.putFile(imageUri).addOnSuccessListener {

            hideProgressBar()
            Toast.makeText(this@EditProfile,"Profile Successfully uploaded",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@EditProfile,Dashboard::class.java))

        }.addOnFailureListener{
            hideProgressBar()
            Toast.makeText(this@EditProfile,"Failed to upload the image",Toast.LENGTH_SHORT).show()
        }

    }
//
//    fun getValues(view: View) {
//        Toast.makeText(this, "Spinner 1 " + gender.selectedItem.toString(),Toast.LENGTH_SHORT).show()
//    }

    // this function is triggered when
    // the Select Image Button is clicked
//    fun imageChooser() {
//
//        // create an instance of the
//        // intent of the type image
//        val i = Intent()
//        i.type = "image/*"
//        i.action = Intent.ACTION_GET_CONTENT
//
//        // pass the constant to compare it
//        // with the returned requestCode
//        startActivityForResult(Intent.createChooser(i, "Select Picture"), SELECT_PICTURE)
//    }

    private fun showProgressBar(){
        dialog = Dialog(this@EditProfile)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_wait)
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()

    }

    private fun hideProgressBar(){
        dialog.dismiss()
    }



    // this function is triggered when user
    // selects the image from the imageChooser
//    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == RESULT_OK) {
//
//            // compare the resultCode with the
//            // SELECT_PICTURE constant
//            if (requestCode == SELECT_PICTURE) {
//                // Get the url of the image from data
//                val selectedImageUri = data!!.data
//                if (null != selectedImageUri) {
//                    // update the preview image in the layout
//                    iVPreviewImage!!.setImageURI(selectedImageUri)
//                }
//            }
//        }
//    }
}