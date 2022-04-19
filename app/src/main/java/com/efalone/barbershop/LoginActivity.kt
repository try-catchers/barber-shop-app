package com.efalone.barbershop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.btnSubmit).setOnClickListener {

        }

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            goToRegisterActivity()
        }
    }

    private fun goToRegisterActivity(){
        val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
        startActivity(intent)
        //finish()
    }

    //TODO create fragments
    /*private fun goToMainFragment() {

    }*/
}