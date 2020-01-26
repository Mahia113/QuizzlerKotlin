package com.joseluis.quizzlerkotlin.controller

import android.util.Log
import com.joseluis.quizzlerkotlin.model.QuizModel
import com.joseluis.quizzlerkotlin.view.QuizActivity

class QuizController {

    private var quizModel: QuizModel = QuizModel()
    private var quizActivity: QuizActivity = QuizActivity()

    fun isACorrectAnswer(answer: String){

        Log.i("Answer by user: ", answer)

        quizModel.isACorrectAnswer(answer)

    }

}