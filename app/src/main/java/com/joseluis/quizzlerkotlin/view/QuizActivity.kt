package com.joseluis.quizzlerkotlin.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        if(quizModel.isACorrectAnswer(v!!.tag.toString())){
            v.setBackgroundColor(Color.GREEN)
        }else{
            v.setBackgroundColor(Color.RED)
        }

        quizModel.updateCurrentQuestion()

        Timer().schedule(300){
            updateView()
        }
    }

    private fun setListeners(){
        button_true.setOnClickListener(this)
        button_false.setOnClickListener(this)
    }

    private fun updateView(){
        text_view_question.text = quizModel.getCurrentQuestion()
        text_view_score.text = quizModel.getScore()
        progressBar.progress = quizModel.getProgressOfQuestions()
        button_true.setBackgroundColor(Color.TRANSPARENT)
        button_false.setBackgroundColor(Color.TRANSPARENT)
    }












/*    fun showCorrectAnswer(){

    }

    fun showWrongAnswer(){

    }*/

}