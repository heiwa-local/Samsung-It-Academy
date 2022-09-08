package com.example.practice4_9

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {


    private var count :Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val btC = findViewById<Button>(R.id.clicker)
        val btP = findViewById<Button>(R.id.startprocess)
        btP.setOnClickListener {
            val data = Data.Builder().putInt("click",count).build()
            val process1 = OneTimeWorkRequest.Builder(TextWorker::class.java).build()
            val process2 = OneTimeWorkRequest.Builder(LongWorker::class.java).setInputData(data).build()
            WorkManager.getInstance(this)
                .beginWith(process1)
                .then(process2)
                .enqueue()
        }

        btC.setOnClickListener {
            count++
            btC.text = count.toString()
        }




    }

    override fun onDestroy() {
        super.onStop()
        WorkManager.getInstance(this).cancelAllWorkByTag("song")
    }
}