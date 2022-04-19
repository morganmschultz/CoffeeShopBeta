package com.example.coffeeshopprototype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController

class SecondActivity : AppCompatActivity(R.layout.activity_second) {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setupActionBarWithNavController(navController)

        //setContentView(R.layout.fragment_start)
    }
}