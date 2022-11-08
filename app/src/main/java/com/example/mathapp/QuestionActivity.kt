package com.example.mathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class QuestionActivity : AppCompatActivity() {

    var questionTextView : TextView? = null
    lateinit var answerEditText : EditText

    var firstNumber = 0
    var secondNumber = 0
    var mathMethodNumber = (1..3).random()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        firstNumber = intent.getIntExtra("firstNumber",0)
        Log.d("!!!", firstNumber.toString())
        secondNumber = intent.getIntExtra("secondNumber",0)
        Log.d("!!!", secondNumber.toString())

        questionTextView = findViewById(R.id.QuestionTextView)
        answerEditText = findViewById(R.id.answerEditText)

        val button = findViewById<Button>(R.id.button2)
        button.setOnClickListener {
            checkAnswerAndStartAnswerActivity()
        }
        questionTextView?.text = "$firstNumber + $secondNumber"

    }

    override fun onResume() {
        super.onResume()

        answerEditText.setText("")
    }
    fun checkAnswerAndStartAnswerActivity () {
        val answerText = answerEditText.text.toString()
        val answer = answerText.toIntOrNull()
        val mathMethod = when (mathMethodNumber) {
            1 -> firstNumber - secondNumber
            2 -> firstNumber + secondNumber
            3 -> firstNumber * secondNumber

            else -> {+}
        }
        val correctAnswer = mathMethod

        var answeredCorrect = false
        if (answer == correctAnswer) {
            answeredCorrect = true
        }

        val intent = Intent(this, AnswerActivity::class.java)
        intent.putExtra("answeredCorrect", answeredCorrect)
        intent.putExtra("facit",correctAnswer)
        startActivity(intent)
    }

}