package com.example.composeapplication.utills

data class User(
    val description :String
)

fun DumyData():List<User>{
    return listOf(User("Rahul Krushna Vaidya is an Indian singer and music composer"),
        User("Rahul Krushna Vaidya is an Indian singer and music composer."))
}
