package com.example.broadcast_receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var print: TextView
    private lateinit var button: Button
    private var time = 0
    private val tickReceiver by lazy { makeBroadcastReceiver() }

    companion object {
        private fun getCurrentTimeStamp(): String {
            val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US)
            val now = Date()
            return simpleDateFormat.format(now)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        print = findViewById(R.id.print)
        button = findViewById(R.id.button)

        button.setOnClickListener { View->
            unregisterReceiver(tickReceiver)
            Toast.makeText(this, getString(R.string.toast_text) ,Toast.LENGTH_SHORT).show()
            print.text = "Ожидание..."
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_TIME_TICK))
        registerReceiver(tickReceiver, IntentFilter(Intent.ACTION_BATTERY_LOW))
    }

    override fun onPause() {
        super.onPause()
        try {
            unregisterReceiver(tickReceiver)
        } catch (e: IllegalArgumentException) {
            Log.e("Broadcast", "Time tick Receiver not registered", e)
        }
    }


    private fun makeBroadcastReceiver(): BroadcastReceiver {
        return object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent?) {
                if (intent?.action == Intent.ACTION_TIME_TICK) {
//                    dateTimeTextView.text = getCurrentTimeStamp()
                    time++
                    print?.text = "время созерцания: $time мин."
                }
                if (intent?.action == Intent.ACTION_BATTERY_LOW){
                    print?.text = "накормите Ждуна, силы на исходе!"
                }
            }
        }
    }
}