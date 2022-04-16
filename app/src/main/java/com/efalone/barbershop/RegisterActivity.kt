package com.efalone.barbershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.parse.ParseUser

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etRePassword).text.toString()
            //val phoneNumber = findViewById<EditText>(R.id.phoneNumber).text.toString()
            //val emailAddress = findViewById<EditText>(R.id.email).text.toString()
            signUpUser(username, password)
        }


    }

    private fun signUpUser(username: String, password: String){
        // Create the ParseUser
        val user = ParseUser()

        // Set fields for the user to be created
        user.setUsername(username)
        user.setPassword(password)
        //user.setPhoneNumber(phoneNumber)

        user.signUpInBackground { e ->
            if (e == null) {
                // User has successfully created an account

                goToMainActivity()
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Sign up was not successful", Toast.LENGTH_SHORT).show()
                e.printStackTrace()
            }
        }
    }

    private fun goToMainActivity(){
        val intent = Intent(this@RegisterActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    //TODO: Go into main fragment after user registers successfully
}