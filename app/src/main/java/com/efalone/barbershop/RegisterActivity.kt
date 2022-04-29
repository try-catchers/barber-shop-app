package com.efalone.barbershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
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
            val username = findViewById<EditText>(R.id.etNewUsername).text.toString()
            val password = findViewById<EditText>(R.id.etNewRePassword).text.toString()
            val phoneNumber = findViewById<EditText>(R.id.etNewPhoneNumber).text.toString()
            val emailAddress = findViewById<EditText>(R.id.etNewEmail).text.toString()
            val accountType = spinner.getSelectedItem().toString()

            // check if fields are empty, otherwise, notice the user
            if(username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || emailAddress.isEmpty() || (accountType == "Account Type")) {
                Snackbar.make(findViewById(android.R.id.content),"Error! Please fill all fields",Snackbar.LENGTH_SHORT).show()
            } else {
                signUpUser(username, password, phoneNumber, emailAddress, accountType)
            }
        }
    }

    private fun signUpUser(username: String, password: String, phoneNumber: String, email : String, type: String){
        // Create the ParseUser
        val user = ParseUser()

        // Set fields for the user to be created
        // if accountType==Customer, user.put("CustomerName",name)
        // else user.put("ClientName", name2)
        user.setUsername(username)
        user.setPassword(password)
        user.setEmail(email)
        user.put("Phone",phoneNumber)
        user.put("accountType", type)

        user.signUpInBackground { e ->
            if (e == null) {
                // User has successfully created an account
                goToMainActivity()
                Snackbar.make(findViewById(android.R.id.content), "Account created successfully", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(findViewById(android.R.id.content), "Sign up was not successful", Snackbar.LENGTH_SHORT).show()
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
    }

    companion object {
        const val TAG = "RegisterActivity"
    }
}