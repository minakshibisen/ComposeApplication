package com.example.composeapplication.navigation.utills

import okhttp3.Route

sealed class NavigationScreen (val route: String){
    object FirstScreen:NavigationScreen("firstscreen")
    object SecondScreen:NavigationScreen("{data}/secondscreen"){
        fun CreateRoute(data:String)= "$data/secondscreen"//like 1st screen koi data send krregi to second screen receive kregi
    }
    object ThriedScreen:NavigationScreen("thriedscreen")
}

//unique tag name dene ke liye jisse navhostcontroller understand kar paye ki kis activity me jana hai
