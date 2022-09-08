package com.example.myfirstprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val NCREATE = "Activity CREATED"
    val NSTART = "Activity STARTED"
    val NRESUME = "Activity RESUME"
    val NPAUSE = "Activity PAUSED"
    val NSTOP = "Activity STOPPED"
    val NRESTART = "Activity RESTARTED"
    val NDESTROY = "Activity DESTROYED"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toast = Toast.makeText(baseContext,NCREATE ,Toast.LENGTH_SHORT)
        toast.show()
    }

    override fun onStart() {
        super.onStart()
        val toast = Toast.makeText(baseContext,NSTART ,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.LEFT,0,0)
        toast.show()

    }

    override fun onResume() {
        super.onResume()
        val toast = Toast.makeText(baseContext,NRESUME ,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.TOP,0,0)
        toast.show()
    }
    override fun onRestart() {
        super.onRestart()
        val toast = Toast.makeText(baseContext,NRESTART ,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.FILL_HORIZONTAL,0,0)
        toast.show()
    }

    override fun onPause() {
        super.onPause()
        val toast = Toast.makeText(baseContext,NPAUSE ,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.RIGHT,0,0)
        toast.show()
    }

    override fun onStop() {
        super.onStop()
        val toast = Toast.makeText(baseContext,NSTOP ,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        val toast = Toast.makeText(baseContext,NDESTROY ,Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.FILL,0,0)
        toast.show()
    }
}

