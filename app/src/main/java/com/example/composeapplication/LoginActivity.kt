package com.example.composeapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.BottomNavigation.BottomNavigationActivity
import com.example.composeapplication.starBugsUi.navigation.StarBuchNavigation
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.utills.DumyData
import com.example.composeapplication.utills.User

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                Surface(color = MaterialTheme.colorScheme.surfaceBright) {
                   //RecyclerView(data = DumyData())
                   // LoginScreen()
                    StarBuchNavigation()
                }
            }
        }
    }

    private fun logged(username: String, password: String) {
        if (username == "Minu" && password == "1234") {
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong Credential", Toast.LENGTH_SHORT).show()
        }
    }

    @Composable
    fun LoginScreen() {
        val context = LocalContext.current
        val username = remember {
            mutableStateOf(value = "")
        }

        val password = remember {
            mutableStateOf(value = "")
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Log in to your account", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username.value,
                onValueChange = {
                    username.value = it

                },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "userImage")
                },
                label = {
                    Text(text = "User Name")
                },
                placeholder = {
                    Text(text = "Enter Username")
                },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it

                },
                leadingIcon = {
                    Icon(Icons.Default.Info, contentDescription = "password")
                },
                label = {
                    Text(text = "password")
                },
                placeholder = {
                    Text(text = "Enter password")
                },
                modifier = Modifier.fillMaxWidth()

            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Forgot Password?", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {    val intent = Intent(this@LoginActivity, BottomNavigationActivity::class.java)
                startActivity(intent)
                }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Login")

            }
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Don’t have an account? Sign in")
        }
    }
    /*    fun LoginScreen() {

            val username = remember {
                mutableStateOf(value = "")
            }

            val password = remember {
                mutableStateOf(value = "")
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Hello Again!", color = Color.Blue, fontSize = 25.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Welcome", color = Color.Blue, fontSize = 25.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Back", color = Color.Blue, fontSize = 25.sp,
                    fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold
                )


                OutlinedTextField(
                    value = username.value,
                    onValueChange = {
                        username.value = it

                    },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = "userImage")
                    },
                    label = {
                        Text(text = "User Name")
                    },
                    placeholder = {
                        Text(text = "Enter Username")
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = password.value,
                    onValueChange = {
                        password.value = it

                    },
                    leadingIcon = {
                        Icon(Icons.Default.Info, contentDescription = "password")
                    },
                    label = {
                        Text(text = "password")
                    },
                    placeholder = {
                        Text(text = "Enter password")
                    },
                    modifier = Modifier.fillMaxWidth()

                )

                OutlinedButton(
                    onClick = { logged(username.value, password.value) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                ) {
                    Text(text = "Login")

                }
            }

        }*/

    @Composable
    fun EachRow(user: User) {
        Card(
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(CornerSize(8.dp)),
        ) {
            Row(modifier = Modifier.padding(5.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.book),
                    contentDescription = "Image",
                    modifier = Modifier
                        .padding(5.dp)
                        .size(60.dp)
                        .align(Alignment.CenterVertically)
                        .clip(
                            RoundedCornerShape(CornerSize(8.dp))
                        )
                )
                Text(text = user.description, modifier = Modifier.padding(8.dp))

            }

        }

    }

    @Composable
    fun RecyclerView(data: List<User>) {
        LazyColumn {
            items(data) { user ->
                EachRow(user)
            }
        }

    }
}