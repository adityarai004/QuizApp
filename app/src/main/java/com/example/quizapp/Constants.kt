package com.example.quizapp

object Constants{

    const val USER_NAME: String = "Username"
    const val  TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions():ArrayList<Questions>{
        val questionList=ArrayList<Questions>()
        val que1 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
        "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        val que2 = Questions(1,"Which one of the following is the capital of Pakistan?",R.drawable.my_gradient,
            "Karachi","Islamabad","Quetta","Lahore",1)
        val que3 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
        "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        val que4 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
            "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        val que5 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
            "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        val que6 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
            "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        val que7 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
            "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        val que8 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
            "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        val que9 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
            "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        val que10 = Questions(1,"Which on of the following is the Capital of India?",R.drawable.my_gradient,
            "Delhi","New Delhi","Jammu and Kashmir","Mumbai",2)
        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)

        return questionList
    }
}