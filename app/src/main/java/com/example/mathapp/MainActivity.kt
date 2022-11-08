package com.example.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var firstNumberEditText: EditText
    lateinit var secondNumberEditText: EditText

    var firstNumber : Int? = null
    var secondNumber : Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstNumberEditText = findViewById(R.id.editFirstNumber)
        secondNumberEditText = findViewById(R.id.editSecondNumber)

        Log.d("!!!", firstNumber.toString())
        val button1 = findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            getNumbers()
            sendNumbers()
        }

    }

    override fun onResume() {
        super.onResume()

        firstNumberEditText.setText("")
        secondNumberEditText.setText("")
    }
    fun getNumbers() {
        val firstNumberText = firstNumberEditText.text.toString()
        firstNumber = firstNumberText.toIntOrNull()
        val secondNumberText = secondNumberEditText.text.toString()
        secondNumber = secondNumberText.toIntOrNull()
    }
    fun sendNumbers() {
        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra("firstNumber", firstNumber)
        intent.putExtra("secondNumber", secondNumber)
        startActivity(intent)

    }

}