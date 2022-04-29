package com.efalone.barbershop.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.efalone.barbershop.LoginActivity
import com.efalone.barbershop.MainActivity
import com.efalone.barbershop.R
import com.google.android.material.snackbar.Snackbar
import com.parse.ParseException
import com.parse.ParseUser


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set onClickListeners and setup logic


        val newUsername = view?.findViewById<EditText>(R.id.etNewUsername)
        val newPassword = view?.findViewById<EditText>(R.id.etNewPassword)
        val newRePassword = view?.findViewById<EditText>(R.id.etNewRePassword)
        val newEmail = view?.findViewById<EditText>(R.id.etNewEmail)
        val newPhone = view?.findViewById<EditText>(R.id.etNewPhoneNumber)

        val newUsernameText = newUsername?.text.toString()
        val newPasswordText = newPassword?.text.toString()
        val newRePasswordText = newRePassword?.text.toString()
        val newEmailText = newEmail?.text.toString()
        val newPhoneText = newPhone?.text.toString()

        view?.findViewById<Button>(R.id.btnSubmitNew)?.setOnClickListener {
            Log.i(TAG, "Working")

            if (newUsernameText.isNotEmpty()) {
                ParseUser.getCurrentUser().username = newUsernameText

            }

            if ((newPasswordText.isNotEmpty() && newRePasswordText.isNotEmpty()) && (newPasswordText == newRePasswordText)) {
                ParseUser.getCurrentUser().setPassword(newPasswordText)
            }

            if(newEmailText.isNotEmpty()) {
                ParseUser.getCurrentUser().email = newEmailText

            }

            if(newPhoneText.isNotEmpty()) {
                ParseUser.getCurrentUser().put("Phone",newPhoneText)
            }

            val imm: InputMethodManager =
                requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(requireView().windowToken, 0)

            try {
                ParseUser.getCurrentUser().saveInBackground()
                Snackbar.make(requireView(),"Changes saved successfully!",Snackbar.LENGTH_SHORT).show()
                Log.i(TAG, "Changes saved successfully!")
            } catch (e: ParseException) {
                Log.e(TAG, e.printStackTrace().toString())
                Snackbar.make(requireView(),"An error occurred saving your changes!",Snackbar.LENGTH_SHORT).show()
            }
        }

        view?.findViewById<Button>(R.id.btnLogOut)?.setOnClickListener {
            Log.i(TAG, "User signed out")
            ParseUser.logOutInBackground()

            val currentUser = ParseUser.getCurrentUser() // this will now be null

            if(currentUser == null) {
                Log.i(TAG,"User successfully logged out")
                goToLogin()
            } else {
                Log.i(TAG, "error occurred while logging out")
            }

            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    private fun goToLogin() {
        //create intent and start
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
    }
    companion object {
        const val TAG = "SettingsFragment"
    }
}