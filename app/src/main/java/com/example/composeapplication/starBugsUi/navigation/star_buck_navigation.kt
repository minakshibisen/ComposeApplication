package com.example.composeapplication.starBugsUi.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapplication.starBugsUi.Screens.Cart_Screen
import com.example.composeapplication.starBugsUi.Screens.Product_detail_screen
import com.example.composeapplication.starBugsUi.Screens.home_screen
import com.example.composeapplication.starBugsUi.Screens.start_screen

@Composable
fun StarBuchNavigation(){

    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = start){
        composable (start){
            start_screen(navHostController = navHostController)
        }

        composable(home){
            home_screen(navHostController = navHostController )
        }
        composable(detail) {
            Product_detail_screen(navHostController = navHostController )
        }
        composable(cart){
            Cart_Screen(navHostController=navHostController)

        }
    }

}

const val start =  "start_screen"
const val home =  "home_screen"
const val detail =  "Product_detail_screen"
const val cart =  "Cart_screen"