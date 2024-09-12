package com.example.composeapplication.BottomNavigation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.composeapplication.LoginActivity
import com.example.composeapplication.R
import com.example.composeapplication.starBugsUi.Screens.Cart_Screen
import com.example.composeapplication.starBugsUi.Screens.home_screen
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class BottomNavigationActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ComposeApplicationTheme {
                Surface {

                    TabNavigator(tab = HomeTab) {
                        Scaffold(
                            bottomBar = {
                                BottomNavigation {
                                    TabNavigationItems(tab = HomeTab)
                                    TabNavigationItems(tab = AddTab)
                                    TabNavigationItems(tab = ProfileTab)
                                }
                            }

                        )

                        {
                            CurrentTab() // Display the content of the selected tab
                        }
                    }


                }
            }

        }
    }
}

@Composable
fun RowScope.TabNavigationItems(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current
    BottomNavigationItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab }, // This line sets the current tab
        icon = { Icon(tab.options.icon!!, contentDescription = tab.options.title) }
    )
}

object HomeTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Home"
            val icon = rememberVectorPainter(Icons.Default.Home)

            return remember {
                TabOptions(
                    0u, title, icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navController = rememberNavController()

        home_screen(navHostController = navController)

    }


}

object AddTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Add"
            val icon = rememberVectorPainter(Icons.Default.Add)
            return remember {
                TabOptions(
                    1u, title, icon
                )
            }
        }

    @Composable
    override fun Content() {
        val navController = rememberNavController()

        Cart_Screen(navHostController = navController)



    }

}

object ProfileTab : Tab {
    override val options: TabOptions
        @Composable
        get() {
            val title = "Profile"
            val icon = rememberVectorPainter(Icons.Default.Person)
            return remember {
                TabOptions(
                    2u, title, icon
                )
            }
        }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        val tabNavigator = LocalTabNavigator.current
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            TopAppBar(
                title = {
                    Text(
                        "Profile",
                        style = TextStyle(fontSize = 20.sp),
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )

            )
            Image(
                painter = painterResource(id = R.drawable.book), // Replace with your image resource
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(128.dp)
                    .padding(top = 16.dp)
            )

            Text(text = "Profile Name")
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    tabNavigator.current = HomeTab
                }) {
                    Text(text = "Logout")
                }
            }

        }



    }


}

