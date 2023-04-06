package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnStart = findViewById<Button>(R.id.startButton)
        var nameTV = findViewById<TextView>(R.id.nameET)
        btnStart.setOnClickListener{
            if(nameTV.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter a name",Toast.LENGTH_SHORT).show()
            }
            else{
                val i = Intent(this,QuizQuestionsActivity::class.java)
                i.putExtra(Constants.USER_NAME,nameTV.text.toString())
                startActivity(i)
                finish()
            }
        }
    }
}