package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapp.Constants
import com.example.quizapp.MainActivity
import com.example.quizapp.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val username = intent.getStringExtra(Constants.USER_NAME)
        val nameTV:TextView= findViewById(R.id.tv_name)
        nameTV.text = username
        val correctAnswers = intent.getStringExtra(Constants.CORRECT_ANSWERS)
        val scoreTV:TextView = findViewById(R.id.tv_score)

        scoreTV.text = "Your score is $correctAnswers out of 10 Questions"
    }
}