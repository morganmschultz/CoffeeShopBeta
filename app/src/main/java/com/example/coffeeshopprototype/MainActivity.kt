package com.example.coffeeshopprototype

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coffeeshopprototype.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener {

    private lateinit var binding: ActivityMainBinding

    lateinit var gestureDetector: GestureDetector
    var x2:Float = 0.0f
    var x1:Float = 0.0f
    var y2:Float = 0.0f
    var y1:Float = 0.0f

    companion object{
        const val MIN_DISTANCE = 150
    }


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



        gestureDetector = GestureDetector(this, this)

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        gestureDetector.onTouchEvent(event)

        when(event?.action){
            //when starting to swipe
            0->
            {
                x1=event.x
                y1=event.y
            }
            //when swipe ends
            1 ->
            {
                x2=event.x
                y2=event.y

                val valueX:Float = x2-x1
                val valueY:Float = y2-y2

                if(abs(valueX) > MIN_DISTANCE)
                {
                    if(x2>x1)
                    {
                        //right swipe
                        Toast.makeText(this,"Right ", Toast.LENGTH_LONG).show()
                    }
                    else
                    {
                        //left swipe
                        Toast.makeText(this,"left ", Toast.LENGTH_LONG).show()
                    }
                }

            }
        }



        return super.onTouchEvent(event)
    }


    fun sendData(view: View){
        val intent = Intent(this, ThirdActivity::class.java)
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



    override fun onDown(p0: MotionEvent?): Boolean {
        return false
    }

    override fun onShowPress(p0: MotionEvent?) {

    }

    override fun onSingleTapUp(p0: MotionEvent?): Boolean {
        return false
    }

    override fun onScroll(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        return false
    }

    override fun onLongPress(p0: MotionEvent?) {

    }

    override fun onFling(p0: MotionEvent?, p1: MotionEvent?, p2: Float, p3: Float): Boolean {
        return false
    }


}