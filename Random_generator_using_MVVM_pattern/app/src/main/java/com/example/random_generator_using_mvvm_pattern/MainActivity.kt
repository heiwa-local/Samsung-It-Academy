package com.example.random_generator_using_mvvm_pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: RandomViewModel
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.rndNum)
        button = findViewById(R.id.getRnd)

        viewModel = RandomViewModel()

        val provider = ViewModelProvider(this)
        Singletonclass.getInstance().setState(provider.get(RandomViewModel::class.java))

        button.setOnClickListener { view ->

            viewModel = Singletonclass.getInstance().getState()
            viewModel.generateRandomNumber()


            viewModel.currentRandomNumber.observe( this, Observer {
                editText.setText(it.toString())
            })
        }
        }

}