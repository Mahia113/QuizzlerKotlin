package com.joseluis.quizzlerkotlin.model

import android.util.Log

class QuizModel {

    private var currentQuestion: Int = 0
    private var score: Int = 0
    /*private val quiz = listOf(
        Question("A slug's blood is green.", "True"),
        Question("Approximately one quarter of human bones are in the feet.", "True"),
        Question("The total surface area of two human lungs is approximately 70 square metres.", "True"),
        Question("In West Virginia, USA, if you accidentally hit an animal with your car, you are free to take it home to eat.", "True"),
        Question("In London, UK, if you happen to die in the House of Parliament, you are technically entitled to a state funeral, because the building is considered too sacred a place.", "False"),
        Question("It is illegal to pee in the Ocean in Portugal.", "True"),
        Question("You can lead a cow down stairs but not up stairs", "False"),
        Question("Google was originally called 'Backrub'.", "True"),
        Question("Buzz Aldrin's mother's maiden name was 'Moon'.", "True"),
        Question("The loudest sound produced by any animal is 188 decibels. That animal is the African Elephant.", "False"),
        Question("No piece of square dry paper can be folded in half more than 7 times.", "False"),
        Question("Chocolate affects a dog's heart and nervous system; a few ounces are enough to kill a small dog.", "True")
    )*/

    private val quiz2 = listOf(
        Question("Which is the largest organ in the human body?", listOf("Heart", "Skin", "Large Intestine"), "Skin"),
    Question("Five dollars is worth how many nickels?", listOf("25", "50", "100"),  "100"),
    Question("What do the letters in the GMT time zone stand for?", listOf("Global Meridian Time", "Greenwich Mean Time", "General Median Time"), "Greenwich Mean Time"),
    Question("What is the French word for 'hat'?", listOf("Chapeau", "Écharpe", "Bonnet"), "Chapeau"),
    Question("In past times, what would a gentleman keep in his fob pocket?", listOf("Notebook", "Handkerchief", "Watch"), "Watch"),
    Question("How would one say goodbye in Spanish?", listOf("Au Revoir", "Adiós", "Salir"), "Adiós"),
    Question("Which of these colours is NOT featured in the logo for Google?", listOf("Green", "Orange", "Blue"),"Orange"),
    Question("What alcoholic drink is made from molasses?", listOf("Rum", "Whisky", "Gin"), "Rum"),
    Question("What type of animal was Harambe?", listOf("Panda", "Gorilla", "Crocodile"), "Gorilla"),
    Question("Where is Tasmania located?", listOf("Indonesia", "Australia", "Scotland"), "Australia")
    )

    fun isACorrectAnswer(answerByUser: String) : Boolean {
        val correctAnswer = quiz2[currentQuestion].answer

        Log.i("com.joseluis.", "correct: "+correctAnswer)
        Log.i("com.joseluis.", "user: "+answerByUser)

        if (answerByUser == correctAnswer){
            score += 1
            return true
        }
        return false
    }

    fun updateCurrentQuestion(){
        if (currentQuestion+1 < quiz2.size){
            currentQuestion += 1
        }else{
            currentQuestion = 0
            score = 0
        }
    }

    fun getCurrentQuestion() : String{
        return quiz2[currentQuestion].question
    }

    fun getOptionAnswer(positionOption: Int) : String{
        return quiz2[currentQuestion].options[positionOption]
    }

    fun getProgressOfQuestions() : Int{
        val progressBarValue = ( (currentQuestion.toFloat() + 1) / (quiz2.size.toFloat()) ) * 100
        return progressBarValue.toInt()
    }

    fun getScore() : String{
        return "Score: "+score
    }

}