package com.grdj.foodideas.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grdj.foodideas.R
import com.grdj.foodideas.ui.customviews.MultipleDishesBanner
import com.grdj.foodideas.ui.theme.FoodIdeasTheme

@Composable
fun HomeScreen() {
    FoodIdeasTheme {
        Column(Modifier.fillMaxSize()) {
            MultipleDishesBanner("Discover more dishes\nby exploring what’s new")
            Card(
                modifier = Modifier.padding(top = 30.dp),
                elevation = 20.dp,
                shape = RoundedCornerShape(20.dp)
            ) {
                Image(
                    modifier = Modifier
                        .height(450.dp),
                    painter = painterResource(id = R.drawable.hegs),
                    contentDescription = "Dish",
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeScreen()
}