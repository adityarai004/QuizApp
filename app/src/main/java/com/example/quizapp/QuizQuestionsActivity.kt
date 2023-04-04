package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    private lateinit var questionTV: TextView
    private lateinit var optionOneTV: TextView
    private lateinit var optionTwoTV:TextView
    private lateinit var optionThreeTV:TextView
    private lateinit var optionFourTV:TextView
    private lateinit var progressTV:TextView
    private lateinit var submitBTN:Button
    private lateinit var progressBar:ProgressBar

    private var currentPosition:Int = 1
    private var mQuestionsList:ArrayList<Questions> ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        var questionsList = Constants.getQuestions()

        var currentPosition = 1
        var Question:Questions? = questionsList[currentPosition-1]
        questionTV = findViewById(R.id.questionTV)
        optionOneTV = findViewById(R.id.optionOnTVe)
        optionTwoTV = findViewById(R.id.optionTwoTV)
        optionFourTV = findViewById(R.id.optionFourTV)
        optionThreeTV = findViewById(R.id.optionThreeTV)
        submitBTN = findViewById(R.id.submitBTN)
        progressBar = findViewById(R.id.progressBar)
        progressTV = findViewById(R.id.progressTV)

        questionTV.text = Question!!.question
        optionOneTV.text = Question.optionOne
        optionTwoTV.text = Question.optionTwo
        optionThreeTV.text = Question.optionThree
        optionFourTV.text = Question.optionFour
        progressBar.progress = currentPosition
        progressTV.text = "$currentPosition / ${progressBar.max}"

    }
}