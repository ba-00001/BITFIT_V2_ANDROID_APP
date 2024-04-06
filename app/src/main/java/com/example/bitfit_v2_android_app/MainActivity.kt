package com.example.bitfit_v2_android_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentManager: FragmentManager = supportFragmentManager

        // define your fragments here
        val foodListFragment: Fragment = FoodListFragment()
        val analyticsFragment: Fragment = AnalyticsFragment()


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        //Handle Activity Switching
        findViewById<Button>(R.id.addFoodButton)?.setOnClickListener{
            val intent = Intent(this, AddFoodDetailActivity::class.java)
            startActivity(intent)
        }

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_home -> fragment = foodListFragment
                R.id.action_analytics -> fragment = analyticsFragment

            }
            fragmentManager.beginTransaction().replace(R.id.food_frame_layout, fragment).commit()
            true
        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.action_home



    }
}