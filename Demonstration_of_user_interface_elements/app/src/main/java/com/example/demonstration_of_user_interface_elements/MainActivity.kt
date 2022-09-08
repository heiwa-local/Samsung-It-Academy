package com.example.demonstration_of_user_interface_elements

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var toggleButton: ToggleButton
    private lateinit var radioButton: RadioButton
    private lateinit var radioButton2: RadioButton
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editText)
        checkBox = findViewById(R.id.checkBox)
        toggleButton = findViewById(R.id.toggleButton)
        radioButton = findViewById(R.id.radioButton)
        radioButton2 = findViewById(R.id.radioButton2)
        textView = findViewById(R.id.textView)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        setValue()
        observeViewModel()
    }
    fun setValue() {
        button.setOnClickListener {
            val editTextValue = editText.text.toString()
            val checkBoxValue: String = if (checkBox.isChecked == true) "ON" else "OFF"
            val toggleButtonValue: String = toggleButton.text.toString()
            val radioButtonValue: String = if (radioButton.isChecked == true)
                radioButton.text.toString()
            else radioButton2.text.toString()
            viewModel.setValue(editTextValue, checkBoxValue, toggleButtonValue, radioButtonValue)
        }
    }
    private fun observeViewModel() {
        viewModel.msg.observe(this, Observer {
            textView.text  = it
        })
    }
}