package com.example.composeapplication

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Toolbar
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text("Demo App ", style = TextStyle(fontSize = 20.sp)) },
                            navigationIcon = {
                                IconButton(onClick = {}) {

                                    Icon(Icons.Filled.Menu, contentDescription = "menu")

                                }
                            },
                            actions = {
                                IconButton(onClick = {}) {

                                    Icon(
                                        Icons.Filled.Notifications,
                                        contentDescription = "Notification"
                                    )

                                }
                                IconButton(onClick = {}) {

                                    Icon(Icons.Filled.Search, contentDescription = "search")

                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Magenta)

                        )
                    },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { }) {
                            Icon(Icons.Filled.Add, contentDescription = "add")

                        }
                    },
                    floatingActionButtonPosition = FabPosition.Center,
                    containerColor = Color.Transparent,

                    content = {
                        Greeting(name = "Hello")

                    }
                    )

                ShowSwitch()
            }
        }

    }

    @Composable
    fun Greeting(name: String) {
        Text(
            text = "Hello $name!"
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        ComposeApplicationTheme {
            Greeting("Android")
        }
    }
    @Composable
    fun ShowSwitch(){
        //mutablestateof data lost  n hone deta

        val isChacked = remember {
            mutableStateOf(true)
        }

        Switch(checked = isChacked.value,
            onCheckedChange ={
                isChacked.value=it
            },
            modifier =Modifier.run {
                size(20.dp)
                padding(100.dp)
            }
            )
    }
}