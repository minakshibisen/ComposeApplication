package com.example.composeapplication.starBugsUi.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.composeapplication.starBugsUi.Components.LogoComponent
import com.example.composeapplication.starBugsUi.navigation.home
import com.example.composeapplication.ui.theme.Background
import kotlinx.coroutines.delay

@Composable

fun start_screen(navHostController: NavHostController) {
    LaunchedEffect(key1 = Unit) {
        delay(2000)
        navHostController.navigate(home)
        
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background), contentAlignment = Alignment.Center
    ) {
        LogoComponent()
    }
}