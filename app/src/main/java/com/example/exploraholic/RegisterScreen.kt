package com.example.exploraholic

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.example.myapp.R
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern

class RegisterScreen() : AppCompatActivity() {
    private var email: TextInputLayout? = null
    private var password: TextInputLayout? = null
    private var confirmpassword: TextInputLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)

        // Referencing email and password
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        confirmpassword = findViewById(R.id.cnfmpswd)
    }

    private fun validateEmail(): Boolean {

        // Extract input from EditText
        val emailInput = email!!.editText!!.text.toString().trim { it <= ' ' }

        // if the email input field is empty
        if (emailInput.isEmpty()) {
            email!!.error = "Field can not be empty"
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email!!.error = "Please enter a valid email address"
            return false
        } else {
            email!!.error = null
            return true
        }
    }

    private fun validatePassword(): Boolean {
        val passwordInput = password!!.editText!!.text.toString().trim { it <= ' ' }
        // if password field is empty
        // it will display error message "Field can not be empty"
        if (passwordInput.isEmpty()) {
            password!!.error = "Field can not be empty"
            return false
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            password!!.error = "Password is too weak"
            return false
        } else {
            password!!.error = null
            return true
        }
    }

    private fun validateConfirmPassword(): Boolean {
        val passwordInput = confirmpassword!!.editText!!.text.toString().trim { it <= ' ' }
        // if password field is empty
        // it will display error message "Field can not be empty"
        if (passwordInput.isEmpty()) {
            confirmpassword!!.error = "Field can not be empty"
            return false
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            confirmpassword!!.error = "Password is too weak"
            return false
        } else {
            confirmpassword!!.error = null
            return true
        }
    }

    fun confirmInput(v: View?) {
        if (!validateEmail() or !validatePassword() or !validateConfirmPassword()) {
            return
        }

        // if the email and password matches, a toast message
        // with email and password is displayed
        var input: String = "Email: " + email!!.editText!!.text.toString()
        input += "\n"
        input += "Password: " + password!!.editText!!.text.toString()
        input += "Confirm Password: " + confirmpassword!!.editText!!.text.toString()
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show()
        val intent= Intent(this,HomePage::class.java)
        startActivity(intent)
    }

    companion object {
        // defining our own password pattern
        private val PASSWORD_PATTERN = Pattern.compile(
            "^" +
                    "(?=.*[@#$%^&+=])" +  // at least 1 special character
                    "(?=\\S+$)" +  // no white spaces
                    ".{4,}" +  // at least 4 characters
                    "$"
        )
    }
}