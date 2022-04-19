package com.efalone.barbershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.parse.ParseClassName
import com.parse.ParseUser
import kotlin.properties.Delegates

class RegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var spinner : Spinner
    private var accountMode by Delegates.notNull<Int>()

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
            val phone = findViewById<EditText>(R.id.etPhoneNumber).text.toString() //TODO add phone number to user entry
            val email = findViewById<EditText>(R.id.etEmail).text.toString() //TODO add email address to user entry
            //TODO add account mode election (spinner) to the new user entry

            val accountType = spinner.getSelectedItem().toString()

            // check if fields are empty, otherwise, notice the user
            if(username.isEmpty() || password.isEmpty()) { //TODO require the user to input all fields
                Toast.makeText(this,"Error! Please fill all fields",Toast.LENGTH_SHORT).show()
            } else {

                signUpUser(username, password, email, phone, accountType)
            }
        }
    }

    private fun signUpUser(
        username: String, password: String,
        emailAddress: String, phoneNumber: String,
        accountType: String){
        // Create the ParseUser
        val user = ParseUser()

        // Set fields for the user to be created
        user.setUsername(username)
        user.setPassword(password)
        user.setEmail(emailAddress);
        user.put("Phone", phoneNumber);
        user.put("accountType", accountType)

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
        // 0 -> N/A
        // 1 -> Customer
        // 2 -> Stylist
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