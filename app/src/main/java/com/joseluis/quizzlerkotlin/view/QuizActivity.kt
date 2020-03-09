package com.joseluis.quizzlerkotlin.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.joseluis.quizzlerkotlin.R
import com.joseluis.quizzlerkotlin.model.QuizModel
import kotlinx.android.synthetic.main.activity_quiz.*
import java.util.*
import kotlin.concurrent.schedule

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    private var quizModel: QuizModel = QuizModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        updateView()
        setListeners()
    }

    override fun onClick(v: View?){

        if(quizModel.isACorrectAnswer((v as Button).text.toString())){
            button_option1.setBackgroundColor(Color.GREEN)
        }else{
            v.setBackgroundColor(Color.RED)
        }

        quizModel.updateCurrentQuestion()

        Timer().schedule(300){ updateView() }
    }

    private fun setListeners(){
        button_option1.setOnClickListener(this)
        button_option2.setOnClickListener(this)
        button_option3.setOnClickListener(this)
    }

    private fun updateView(){
        button_option1.text = quizModel.getOptionAnswer(0)
        button_option2.text = quizModel.getOptionAnswer(1)
        button_option3.text = quizModel.getOptionAnswer(2)
        text_view_question.text = quizModel.getCurrentQuestion()
        text_view_score.text = quizModel.getScore()
        progressBar.progress = quizModel.getProgressOfQuestions()
        button_option1.setBackgroundColor(Color.TRANSPARENT)
        button_option2.setBackgroundColor(Color.TRANSPARENT)
        button_option3.setBackgroundColor(Color.TRANSPARENT)
    }

}