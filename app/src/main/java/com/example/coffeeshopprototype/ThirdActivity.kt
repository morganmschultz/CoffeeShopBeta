package com.example.coffeeshopprototype

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import kotlin.math.abs

class ThirdActivity : AppCompatActivity(), GestureDetector.OnGestureListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        gestureDetector = GestureDetector(this, this)
    }

    lateinit var gestureDetector: GestureDetector
    var x2:Float = 0.0f
    var x1:Float = 0.0f
    var y2:Float = 0.0f
    var y1:Float = 0.0f

    companion object{
        const val MIN_DISTANCE = 150
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

                if(abs(valueX) > MainActivity.MIN_DISTANCE)
                {
                    if(x2>x1)
                    {
                        //right swipe

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    }
                    else
                    {
                        //left swipe

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        val toast = Toast.makeText(applicationContext, "Order Completed!", Toast.LENGTH_LONG)
                        toast.show()
                    }

                }


            }
        }



        return super.onTouchEvent(event)
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