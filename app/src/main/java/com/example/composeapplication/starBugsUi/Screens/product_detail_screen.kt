package com.example.composeapplication.starBugsUi.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.composeapplication.R
import com.example.composeapplication.starBugsUi.Components.AppIconComponent
import com.example.composeapplication.starBugsUi.Components.IconComponent
import com.example.composeapplication.starBugsUi.Components.LogoComponent
import com.example.composeapplication.ui.theme.Background
import com.example.composeapplication.ui.theme.DarkGreen
import com.example.composeapplication.ui.theme.Gray400_1
import com.example.composeapplication.ui.theme.Gray500
import com.example.composeapplication.ui.theme.LightRed_1
import com.example.composeapplication.ui.theme.TextColor

@Composable

fun Product_detail_screen(navHostController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)

        ) {
            ProductHeader { navHostController.navigateUp() }
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    ShowProduct()
                    ProductDescription()
                }
            }
        }

        ButtonComponent(
            modifier = Modifier
                .padding(20.dp)
                .align(Alignment.BottomCenter),
                 navHostController = navHostController

        )
    }
}

@Composable
fun ProductDescription(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp)
    ) {

        Text(
            text = "Coffee", style = TextStyle(
                fontSize = 18.sp,
                color = DarkGreen,
                fontWeight = FontWeight.W400
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.chocolate_cappuccino),
                fontSize = 22.sp,
                fontWeight = FontWeight.W500,
                modifier = Modifier.weight(0.8f)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.2f)
            ) {
                IconComponent(
                    icon = R.drawable.ic_star,
                    size = 20.dp,
                    modifier = Modifier
                        .align(CenterVertically)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "4.5",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                        color = Gray400_1
                    ),
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(id = R.string.lorem_ipsum_dolor_sit_amet_consectetur_adipiscing_elit_etiam_at_mi_vitae_augue_feugiat_scelerisque_in_a_eros),
            style = TextStyle(
                fontSize = 18.sp,
                color = Gray500,
                fontWeight = FontWeight.W400
            )
        )
    }

}


@Composable
fun ShowProduct() {
    var counter by remember { mutableIntStateOf(0) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightRed_1, RoundedCornerShape(14.dp)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 20.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.img),
                contentDescription = "",
                modifier = Modifier.fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 14.dp, bottomEnd = 14.dp
                        )

            ))

            Spacer(modifier = Modifier.size(20.dp))

            Box(modifier = Modifier.background(Color.White, RoundedCornerShape(10.dp))) {
                Row {
                    AppIconComponent(icon = R.drawable.ic_remove, background = DarkGreen,tint = Color.White, modifier = Modifier.size(30.dp)) {
                        if (counter > 0)
                            counter--
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "$counter", style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W500,
                            color = TextColor
                        ),
                        modifier = Modifier.align(CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    AppIconComponent(icon = R.drawable.ic_add, background = DarkGreen,tint = Color.White,modifier = Modifier.size(30.dp)) {
                        counter++
                    }

                }
            }

        }
    }

}

@Composable
private fun ButtonComponent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController

) {

    Button(
            onClick = {   navHostController.navigate("Cart_screen")},
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = DarkGreen
        ),
        shape = RoundedCornerShape(37.dp),
        contentPadding = PaddingValues(vertical = 15.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp)
    ) {

        Text(
            text = "Add to beg", style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.W500
            )
        )
    }

}

@Composable
private fun ProductHeader(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        AppIconComponent(icon = R.drawable.ic_menu) {
            onClick()
        }
        LogoComponent(size = 50.dp)
        AppIconComponent(icon = R.drawable.ic_like_heart)
    }

}
