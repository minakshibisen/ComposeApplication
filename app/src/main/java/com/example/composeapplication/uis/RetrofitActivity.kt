package com.example.composeapplication.uis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

import com.example.composeapplication.retrofit.Post
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import com.example.composeapplication.utills.ApiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    GETData(mainViewModel = mainViewModel)
                }

            }
        }
    }

    @Composable
    fun EachRow(post: Post) {
        Card(
            modifier = Modifier
                .padding(horizontal = 5.dp, vertical = 5.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(3.dp)
        ) {
            Text(text = post.body, modifier = Modifier.padding(5.dp), fontStyle = FontStyle.Normal)
        }
    }

    @Composable
    fun GETData(mainViewModel: MainViewModel) {
        when (val result = mainViewModel.response.value) {
            is ApiState.Success -> {
                LazyColumn {
                    items(result.data) { response ->
                        EachRow(response)

                    }
                }
            }

            is ApiState.Failure -> {
                Text(text = "${result.msg}")
            }

            ApiState.Loading -> {
                CircularProgressIndicator()
            }

            ApiState.Empty -> {

            }


        }
    }

}
