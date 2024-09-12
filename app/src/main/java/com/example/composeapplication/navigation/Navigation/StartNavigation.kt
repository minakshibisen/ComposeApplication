package com.example.composeapplication.navigation.Navigation

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.navigation.screens.FirstScreen
import com.example.composeapplication.navigation.screens.SecondScreen
import com.example.composeapplication.navigation.screens.ThiredScreen
import com.example.composeapplication.navigation.utills.NavigationScreen

@Composable
fun StartNavigation(context:Activity){

    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = NavigationScreen.FirstScreen.route){
        composable (NavigationScreen.FirstScreen.route){
            FirstScreen(navController)
        }

        composable(NavigationScreen.SecondScreen.route){
            val data = it.arguments?.getString("data")
            SecondScreen(context,navController )
        }
        composable(NavigationScreen.ThriedScreen.route) {
            ThiredScreen()
        }
    }

}



//all screen ki information rakhega like kaha se kaha gaya
//isi ke through navigate kar payenge