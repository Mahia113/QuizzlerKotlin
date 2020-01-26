package com.joseluis.quizzlerkotlin.model

class QuizModel {

    private var currentQuestion: Int = 0
    private var score: Int = 0
    private val quiz = listOf(
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
    )

    fun isACorrectAnswer(answerByUser: String) : Boolean {
        val correctAnswer = quiz[currentQuestion].answer

        if (answerByUser == correctAnswer){
            score += 1
            return true
        }
        return false
    }

    fun updateCurrentQuestion(){
        if (currentQuestion+1 < quiz.size){
            currentQuestion += 1
        }else{
            currentQuestion = 0
            score = 0
        }
    }

    fun getCurrentQuestion() : String{
        return ""+quiz[currentQuestion].question
    }

    fun getProgressOfQuestions() : Int{
        val progressBarValue = ( (currentQuestion.toFloat() + 1) / (quiz.size.toFloat()) ) * 100
        return progressBarValue.toInt()
    }

    fun getScore() : String{
        return "Score: "+score
    }

}