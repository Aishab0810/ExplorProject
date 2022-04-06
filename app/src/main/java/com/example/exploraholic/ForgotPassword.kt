package com.example.exploraholic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {

    private lateinit var resetEmail: TextInputLayout
    private lateinit var resetButton: Button
    private lateinit var rememberPassword: TextView
    private lateinit var createAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        resetEmail = findViewById(R.id.reset)
        resetButton = findViewById(R.id.resetbtn)
        rememberPassword = findViewById(R.id.remember)
        createAccount = findViewById(R.id.create)

        // get reference to button
        val resetButton = findViewById(R.id.resetbtn) as Button
        // set on-click listener
        resetButton.setOnClickListener {
            val resetEmail : String = resetEmail.toString().trim()
            if (resetEmail.isEmpty())
            {
                Toast.makeText(this@ForgotPassword,"Please enter your email",Toast.LENGTH_SHORT).show()
            }
            else
            {
                FirebaseAuth.getInstance().sendPasswordResetEmail(resetEmail)
                    .addOnCompleteListener{task ->
                        if (task.isSuccessful){
                            Toast.makeText(
                                this@ForgotPassword,
                                "Email sent successfully to reset your password",
                                Toast.LENGTH_LONG
                            ).show()
                            finish()
                        }
                        else{
                            Toast.makeText(
                                this@ForgotPassword,
                                task.exception!!.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
            }
//            Toast.makeText(this@ForgotPassword, "Your resent link is sent", Toast.LENGTH_SHORT).show()
//            startActivity(Intent(this,LoginScreen::class.java))

        }

        // get reference to textview
        val rememberPassword = findViewById(R.id.remember) as TextView
        // set on-click listener
        rememberPassword.setOnClickListener {
            startActivity(Intent(this,LoginScreen::class.java))
        }

        // get reference to textview
        val createAccount = findViewById(R.id.create) as TextView
        // set on-click listener
        createAccount.setOnClickListener {
            startActivity(Intent(this,RegisterScreen::class.java))
        }

    }



}