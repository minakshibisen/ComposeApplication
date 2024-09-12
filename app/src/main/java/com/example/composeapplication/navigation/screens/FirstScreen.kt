package com.example.composeapplication.navigation.screens

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composeapplication.navigation.utills.NavigationScreen

@Composable

fun FirstScreen(navHostController: NavHostController) {
    Button(onClick = { navHostController.navigate(NavigationScreen.SecondScreen.CreateRoute("hey")) }) {
        Text(text = "Click here")

    }
}
//data ko use krne ke liye route ki jagah createroute ka use kra jayega