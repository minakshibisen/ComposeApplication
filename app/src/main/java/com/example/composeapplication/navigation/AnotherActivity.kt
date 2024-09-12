package com.example.composeapplication.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class AnotherActivity:ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent{
            ComposeApplicationTheme {
                Surface() {
                    
                }
            }
        }
    }
}