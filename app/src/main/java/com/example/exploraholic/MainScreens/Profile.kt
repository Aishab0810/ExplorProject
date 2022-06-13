package com.example.exploraholic.MainScreens

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.exploraholic.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import java.util.*

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val CAMERA_REQUEST_CODE = 1
    private val GALLERY_REQUEST_CODE = 2

    private lateinit var auth:FirebaseAuth
//    private lateinit var databaseReference: DatabaseReference
//    private lateinit var storageReference: StorageReference
    private lateinit var database: FirebaseDatabase
    private lateinit var storage: FirebaseStorage
    private lateinit var imageUri : Uri
    private lateinit var dialog: AlertDialog.Builder
    private lateinit var dashboardtxt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog = AlertDialog.Builder(this)
            .setMessage("Updating profile...")
            .setCancelable(false)

//        dialog.show()      13-6-2022

        database = FirebaseDatabase.getInstance()
        storage = FirebaseStorage.getInstance()
        auth = FirebaseAuth.getInstance()

        //13-6-2022 Upload Profile image
        binding.profileImage.setOnClickListener{
            val intent = Intent()
            intent.action = Intent.ACTION_GET_CONTENT
            intent.type = "image/*"
            startActivityForResult(intent, 1)
        }

        binding.saveBtn.setOnClickListener{
            if (binding.etFirstName.text!!.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }else if (binding.etLastName.text!!.isEmpty()) {
                Toast.makeText(this, "Please enter your last name", Toast.LENGTH_SHORT).show()
            }
            else if (binding.etEmail.text!!.isEmpty()) {
                Toast.makeText(this, "Please enter your email address", Toast.LENGTH_SHORT).show()
            }
            else if (imageUri == null) {
                Toast.makeText(this, "Please select your image", Toast.LENGTH_SHORT).show()
            }else uploadData()
        }


//        dashboardtxt = findViewById(R.id.dashboard)
//
//        dashboardtxt.setOnClickListener {
//            startActivity(Intent(this, Dashboard::class.java))
//            Toast.makeText(this@Profile, "Dashboard", Toast.LENGTH_SHORT).show()
//        }
//
//        auth = FirebaseAuth.getInstance()
//        val uid =  auth.currentUser?.uid
//        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

//        binding.saveBtn.setOnClickListener {
//
//            showProgressBar()
//            val firstName = binding.etFirstName.text.toString()
//            val lastName =  binding.etLastName.text.toString()
//            val email =  binding.etEmail.text.toString()
//
//            val user = User(firstName,lastName,email)
//            if(uid != null ){
//
//                databaseReference.child(uid).setValue(user).addOnCompleteListener {
//                        if (it.isSuccessful){
//                            uploadProfilePic()
//                        }else{
//                        hideProgressBar()
//                        Toast.makeText(this@Profile,"Failed to update profile",Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//        }



        //when you click on the Profileimage
//        binding.profileImage.setOnClickListener {
//            val pictureDialog = AlertDialog.Builder(this)
//            pictureDialog.setTitle("Select Action")
//            val pictureDialogItem = arrayOf("Select photo from Gallery",
//                "Capture photo from Camera")
//            pictureDialog.setItems(pictureDialogItem) { dialog, which ->
//                when (which) {
//                    0 -> gallery()
//                    1 -> camera()
//                }
//            }
//            pictureDialog.show()
//        }
    }

    private fun uploadData() {
        val reference = storage.reference.child("Profile Image").child(Date().time.toString())
        reference.putFile(imageUri).addOnCompleteListener{
            if (it.isSuccessful){
                reference.downloadUrl.addOnSuccessListener { task ->
                    uploadInfo(task.toString())
                }
            }
        }
    }

    private fun uploadInfo(imgUrl: String) {
        val user = User(auth.uid.toString(), binding.etFirstName.text.toString(), binding.etLastName.text.toString(), binding.etEmail.text.toString())

        database.reference.child("users")
            .child(auth.uid.toString())
            .setValue(user)
            .addOnSuccessListener {
                Toast.makeText(this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginScreen::class.java))
                finish()
            }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)

        if (data!=null){
            if (data.data != null){
                imageUri = data.data!!
                binding.profileImage.setImageURI(imageUri)
            }
        }
    }


//    private fun uploadProfilePic() {
//        imageUri = Uri.parse("android.resource://$packageName/${R.drawable.proficon}")
//        storageReference = FirebaseStorage.getInstance().getReference( "Users/"+auth.currentUser?.uid+"jpg")
//        storageReference.putFile(imageUri).addOnSuccessListener {
//            hideProgressBar()
//            Toast.makeText(this@Profile,"Profile successfully uploaded",Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this, Dashboard::class.java))
//
//        }.addOnFailureListener {
//            hideProgressBar()
//            Toast.makeText(this@Profile,"Failed to update image",Toast.LENGTH_SHORT).show()
//        }
//    }

//    private fun showProgressBar(){
//        dialog = Dialog(this@Profile)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setContentView(R.layout.dialog_wait)
//        dialog.setCanceledOnTouchOutside(false)
//        dialog.show()
//    }
//
//    private fun hideProgressBar(){
//        dialog.dismiss()
//    }

//    private fun galleryCheckPermission() {
//
//        Dexter.withContext(this).withPermission(
//            android.Manifest.permission.READ_EXTERNAL_STORAGE
//        ).withListener(object : PermissionListener {
//            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
//                gallery()
//            }
//
//            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
//                Toast.makeText(
//                    this@Profile,
//                    "You have denied the storage permission to select image",
//                    Toast.LENGTH_SHORT
//                ).show()
//                showRotationalDialogForPermission()
//            }
//
//            override fun onPermissionRationaleShouldBeShown(
//                p0: PermissionRequest?, p1: PermissionToken?) {
//                showRotationalDialogForPermission()
//            }
//        }).onSameThread().check()
//    }

//    private fun gallery() {
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, GALLERY_REQUEST_CODE)
//    }


//    private fun cameraCheckPermission() {
//
//        Dexter.withContext(this)
//            .withPermissions(
//                android.Manifest.permission.READ_EXTERNAL_STORAGE,
//                android.Manifest.permission.CAMERA).withListener(
//
//                object : MultiplePermissionsListener {
//                    override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
//                        report?.let {
//
//                            if (report.areAllPermissionsGranted()) {
//                                camera()
//                            }
//
//                        }
//                    }
//
//                    override fun onPermissionRationaleShouldBeShown(
//                        p0: MutableList<PermissionRequest>?,
//                        p1: PermissionToken?) {
//                        showRotationalDialogForPermission()
//                    }
//
//                }
//            ).onSameThread().check()
//    }


//    private fun camera() {
//        val intent = Intent(ACTION_IMAGE_CAPTURE)
//        startActivityForResult(intent, this.CAMERA_REQUEST_CODE)
//    }


//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (resultCode == Activity.RESULT_OK) {
//
//            when (requestCode) {
//
//                CAMERA_REQUEST_CODE -> {
//
//                    val bitmap = data?.extras?.get("data") as Bitmap
//
//                    //we are using coroutine image loader (coil)
//                    binding.profileImage.load(bitmap)
//                }
//
//                GALLERY_REQUEST_CODE -> {
//
//                    binding.profileImage.load(data?.data) {
//                    }
//
//                }
//            }
//
//        }

    }


//    private fun showRotationalDialogForPermission() {
//        AlertDialog.Builder(this)
//            .setMessage("It looks like you have turned off permissions"
//                    + "required for this feature. It can be enable under App settings!!!")
//
//            .setPositiveButton("Go TO SETTINGS") { _, _ ->
//
//                try {
//                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
//                    val uri = Uri.fromParts("package", packageName, null)
//                    intent.data = uri
//                    startActivity(intent)
//
//                } catch (e: ActivityNotFoundException) {
//                    e.printStackTrace()
//                }
//            }
//
//            .setNegativeButton("CANCEL") { dialog, _ ->
//                dialog.dismiss()
//            }.show()
//    }
//}