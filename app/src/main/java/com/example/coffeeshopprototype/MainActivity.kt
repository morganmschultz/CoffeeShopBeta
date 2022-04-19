package com.example.coffeeshopprototype

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coffeeshopprototype.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_order, R.id.navigation_menu
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun sendData(view: View){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }

    fun launchGPS(view: View){
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    fun rotator1(view: View){
        val ImageView = view.findViewById<ImageView>(R.id.black_coffee)
        ImageView.animate().apply{
            duration = 1000
            rotationBy(360f)
        }.start()
    }

    fun rotator2(view: View){
        val ImageView = view.findViewById<ImageView>(R.id.latte)
        ImageView.animate().apply{
            duration = 1000
            rotationBy(360f)
        }.start()
    }

    fun rotator3(view: View){
        val ImageView = view.findViewById<ImageView>(R.id.cappuccino)
        ImageView.animate().apply{
            duration = 1000
            rotationBy(360f)
        }.start()
    }
}