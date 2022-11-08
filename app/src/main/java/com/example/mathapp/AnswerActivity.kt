package com.example.mathapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView

class AnswerActivity : AppCompatActivity() {

    lateinit var resultView : TextView
    lateinit var facitView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answer)

        resultView = findViewById(R.id.answerView)
        facitView = findViewById(R.id.facitTextView)
        val facit = intent.getIntExtra("facit",0)
        facitView.setText("facit: $facit")

        val answeredCorrect = intent.getBooleanExtra("answeredCorrect", false)


        if (answeredCorrect) {
            resultView.text = "Rätt!!"
        } else {
            resultView.text = "Fel!!"
        }
    }
}