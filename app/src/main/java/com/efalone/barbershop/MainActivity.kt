package com.efalone.barbershop

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.efalone.barbershop.fragments.DetailFragment
import com.efalone.barbershop.fragments.HomeFragment
import com.efalone.barbershop.fragments.NewAppointmentFragment
import com.efalone.barbershop.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val fragmentManager: FragmentManager = supportFragmentManager
        // define fragments
        val fragmentHome: Fragment = HomeFragment()
        val fragmentNew: Fragment = NewAppointmentFragment()
        val fragmentDetail: Fragment = DetailFragment()
        val fragmentSettings: Fragment = SettingsFragment()
        // initialize bottom navigation view
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        // go to a fragment when the user taps a button within the bottom navigation view
        bottomNavigationView.setOnItemSelectedListener { item ->

            var fragmentToShow: Fragment? = null

            when (item.itemId) {
                R.id.action_home -> {
                    fragmentToShow = fragmentHome
                }
                R.id.action_new_appointment -> {
                    fragmentToShow = fragmentNew
                }
                R.id.action_appointment -> {
                    fragmentToShow = fragmentDetail
                }
                R.id.action_settings -> {
                    fragmentToShow = fragmentSettings
                }
            }
            //check if null. if not, go to fragment
            if(fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }

            true
        }
        // Set default selection (home button)
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }

    // Menu icons are inflated just as they were with actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.bottom_navigation_menu, menu)
        return true
    }
}