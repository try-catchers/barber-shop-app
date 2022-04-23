package com.efalone.barbershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.parse.ParseUser

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Check if there's a user logged in already
        //If true, begin MainActivity directly
        if(ParseUser.getCurrentUser() != null) {
            goToMainActivity()
        }

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            val username = findViewById<EditText>(R.id.etLoginUsername).text.toString()
            val password = findViewById<EditText>(R.id.etLoginPassword).text.toString()

            // check if fields are empty, otherwise, notice the user
            if(username.isEmpty() || password.isEmpty()) { //TODO require the user to input all fields
                Toast.makeText(this,"Error! Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                logInUser(username, password)
            }
        }

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            goToRegisterActivity()
        }
    }

    private fun logInUser(username: String, password: String) {
        ParseUser.logInInBackground(username,password) { user, e ->
            if (user != null) {
                Log.i(TAG, "User successfully signed in")
                goToMainActivity()
            } else {
                // an error occurred while logging in
                e.printStackTrace()
                Snackbar.make(findViewById(android.R.id.content), "An error occurred logging in!", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToRegisterActivity(){
        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
        //finish()
    }

    companion object {
        const val TAG = "LoginActivity"
    }

}