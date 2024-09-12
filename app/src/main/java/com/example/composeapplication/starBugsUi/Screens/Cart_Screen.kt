package com.example.composeapplication.starBugsUi.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Top
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composeapplication.R
import com.example.composeapplication.starBugsUi.Components.IconComponent
import com.example.composeapplication.ui.theme.Background
import com.example.composeapplication.ui.theme.DarkGreen
import com.example.composeapplication.ui.theme.LightRed_1
import com.example.composeapplication.ui.theme.Red
import com.example.composeapplication.ui.theme.TextColor

@Composable
fun Cart_Screen(navHostController: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
        ) {
            items(3) {
                ItemEachRow()
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun ItemEachRow() {

    var selected by rememberSaveable { mutableStateOf(false) }

    Card(shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 10.dp)
            .clickable { }) {

        Row {
            /* Box(
                 modifier = Modifier
                     .background(
                         LightRed_1, RoundedCornerShape(
                             bottomStart = 14.dp, bottomEnd = 14.dp
                         )
                     )
                     .fillMaxHeight()
                     .height(100.dp), contentAlignment = Alignment.Center
             ) {
                 Image(
                     painter = painterResource(id = R.drawable.coffee),
                     contentDescription = "",
                     modifier = Modifier.size(100.dp)
                 )
             }*/
            Card(
                modifier = Modifier
                    .background(
                        LightRed_1, RoundedCornerShape(
                            bottomStart = 14.dp, bottomEnd = 14.dp
                        )
                    )
                    .width(100.dp)
                    .height(100.dp),
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "",
                    modifier = Modifier.size(80.dp)
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 14.dp, bottomEnd = 14.dp
                            )
                        )
                )
            }
            Column(
                modifier = Modifier
                    .padding(15.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = "Coffee", style = TextStyle(color = TextColor, fontSize = 17.sp))

                Text(
                    text = stringResource(id = R.string.chocolate_cappuccino), style = TextStyle(
                        color = TextColor, fontSize = 15.sp, fontWeight = FontWeight.W500
                    )
                )
                Text(
                    text = stringResource(id = R.string._20_00), style = TextStyle(
                        color = DarkGreen, fontSize = 15.sp, fontWeight = FontWeight.W400
                    )
                )

            }
            IconButton(
                onClick = {
                    selected = !selected
                }, modifier = Modifier
                    .size(15.dp)
                    .padding(start = 2.dp)
            ) {
                IconComponent(
                    icon = R.drawable.ic_like_heart,
                    tint = if (selected) Red else Color.Unspecified
                )
            }

        }

    }

}

