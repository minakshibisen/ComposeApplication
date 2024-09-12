package com.example.composeapplication.navigation.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.composeapplication.navigation.AnotherActivity
import com.example.composeapplication.navigation.NavigationActivity
import com.example.composeapplication.navigation.utills.NavigationScreen

@Composable
fun SecondScreen(context: Activity,navHostController: NavHostController){
    Button(onClick = {/*val intent= Intent(context,AnotherActivity::class.java)
    context.startActivity(intent)*/
        navHostController.navigate(NavigationScreen.ThriedScreen.route){
          popUpTo(NavigationScreen.FirstScreen.route){
               // inclusive = true//abc teen screen hai usme agr c se back ho to application se bahar ho jayega  isliye inclusive ka use kiya jata hai
            } //supose  three screen hai a,b,c agr screen c se a me aana ho to is code ka use hota hai yadi 4 ,5 screen bhi ho to
        }


    }) {
        Text(text = "go to another activity here")
    }
    }

//putextra krke bhi data pass kar shte hai
