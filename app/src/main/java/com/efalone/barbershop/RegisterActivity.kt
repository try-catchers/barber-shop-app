package com.efalone.barbershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.parse.ParseUser
import kotlin.properties.Delegates

class RegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var spinner : Spinner
    var accountMode by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // initialize spinner
        spinner = findViewById(R.id.spinnerAccountMode)

        ArrayAdapter.createFromResource(
            this,
            R.array.spinnerAccountModeArray,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        spinner.onItemSelectedListener = this

        // add event listeners

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etRePassword).text.toString()
            //val phoneNumber = findViewById<EditText>(R.id.phoneNumber).text.toString() TODO add phone number to user entry
            //val emailAddress = findViewById<EditText>(R.id.email).text.toString() TODO add email address to user entry
            //TODO add account mode election (spinner) to the new user entry
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

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
        accountMode = pos
        Log.i(TAG, "${parent?.getItemAtPosition(pos)}")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    //TODO: Go into main fragment after user registers successfully


    companion object {
        const val TAG = "RegisterActivity"
    }
}