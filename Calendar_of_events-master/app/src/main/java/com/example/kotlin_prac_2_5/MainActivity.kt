package com.example.kotlin_prac_2_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var imageViewReact: ImageView
    private lateinit var vevent: TextView
    private lateinit var vtime: TextView
    private lateinit var vdata: TextView
    private lateinit var post: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageViewReact = findViewById(R.id.imageView)
        vevent = findViewById(R.id.vevent)
        vtime = findViewById(R.id.vtime)
        vdata = findViewById(R.id.vdata)
        post = findViewById(R.id.post)
    }

    fun setGoodPicture(view: View) {
        imageViewReact.setImageResource(R.drawable.smile)
    }

    fun setBadPicture(view: View) {
        imageViewReact.setImageResource(R.drawable.sad)
    }

    fun setToast(view: View) {
        when {
            vevent.text.trim().isNotEmpty() and vtime.text.trim().isNotEmpty() and vdata.text.trim().isNotEmpty() and post.text.trim().isNotEmpty() ->{
                val msg = """
                    Записано!
                    Событие: ${vevent.text}
                    Дата: ${vdata.text}
                    Время: ${vtime.text}
                    Заметки: ${post.text}
                """.trimIndent()
                val toast = Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
            } else -> {
            Toast.makeText(
                applicationContext,
                "Не все поля заполнены!",
                Toast.LENGTH_SHORT
            ).show()
        }
        }
    }
}