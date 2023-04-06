package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {
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
    private var mSelectedOptionPosition:Int  = 0
    private var mCorrectAnswers = 0
    private var mUsername:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        mQuestionsList = Constants.getQuestions()

        mUsername = intent.getStringExtra(Constants.USER_NAME)

        questionTV = findViewById(R.id.questionTV)
        optionOneTV = findViewById(R.id.optionOneTV)
        optionTwoTV = findViewById(R.id.optionTwoTV)
        optionFourTV = findViewById(R.id.optionFourTV)
        optionThreeTV = findViewById(R.id.optionThreeTV)
        submitBTN = findViewById(R.id.submitBTN)
        progressBar = findViewById(R.id.progressBar)
        progressTV = findViewById(R.id.progressTV)
        setQuestion()

        optionOneTV.setOnClickListener(this)
        optionTwoTV.setOnClickListener(this)
        optionThreeTV.setOnClickListener(this)
        optionFourTV.setOnClickListener(this)

        submitBTN.setOnClickListener(this)
    }

    private fun setQuestion(){
        val question = mQuestionsList!![currentPosition-1]

        defaultOptionsView()

        if(currentPosition > mQuestionsList!!.size){
            submitBTN.text = "Finish"
        }
        else{
            submitBTN.text = "Submit"
        }
        questionTV.text = question.question
        optionOneTV.text = question.optionOne
        optionTwoTV.text = question.optionTwo
        optionThreeTV.text = question.optionThree
        optionFourTV.text = question.optionFour
        progressBar.progress = currentPosition
        progressTV.text = "$currentPosition / ${progressBar.max}"
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,optionOneTV)
        options.add(1,optionTwoTV)
        options.add(2,optionThreeTV)
        options.add(3,optionFourTV)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.edit_text_background)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.optionOneTV ->{
                selectedOptionView(optionOneTV,1)
            }
            R.id.optionTwoTV ->{
                selectedOptionView(optionTwoTV,2)
            }
            R.id.optionThreeTV ->{
                selectedOptionView(optionThreeTV,3)
            }
            R.id.optionFourTV ->{
                selectedOptionView(optionFourTV,4)
            }
            R.id.submitBTN ->{
                if(currentPosition > mQuestionsList!!.size){
                    val i:Intent = Intent(this,ResultActivity::class.java)
                    i.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers.toString())
                    i.putExtra(Constants.USER_NAME,mUsername)
                    i.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                    startActivity(i)
                }
                if(submitBTN.text == "Go to next question"){
                    setQuestion()
                }
                else {
                    if (mSelectedOptionPosition == 0 && currentPosition <= mQuestionsList!!.size) {
                        Toast.makeText(this, "Please Choose an option", Toast.LENGTH_SHORT).show()

                    } else if (currentPosition <= mQuestionsList!!.size) {
                        val correctAns = mQuestionsList!![currentPosition - 1].correctOption
                        if (correctAns != mSelectedOptionPosition) {
                            answerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                        }
                        else{
                            mCorrectAnswers++
                        }
                        answerView(correctAns, R.drawable.correct_option_border_bg)
                        mSelectedOptionPosition = 0
                        currentPosition++
                        if(currentPosition <= mQuestionsList!!.size){
                            submitBTN.text = "Go to next question"
                        }
                    } else {
                        Toast.makeText(this, "You Have Completed the test", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#000000"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border)
    }

    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1 ->{
                optionOneTV.background = ContextCompat.getDrawable(this,drawableView)
            }
            2 ->{
                optionTwoTV.background = ContextCompat.getDrawable(this,drawableView)
            }
            3 ->{
                optionThreeTV.background = ContextCompat.getDrawable(this,drawableView)
            }
            4 ->{
                optionFourTV.background = ContextCompat.getDrawable(this,drawableView)
            }
        }
    }
}