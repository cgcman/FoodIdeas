package com.grdj.foodideas.ui.screens.discover

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grdj.foodideas.R
import com.grdj.foodideas.ui.customviews.ChefBanner
import com.grdj.foodideas.ui.customviews.FollowButton
import com.grdj.foodideas.ui.customviews.MultipleDishesBanner
import com.grdj.foodideas.ui.theme.FoodIdeasTheme
import com.grdj.foodideas.ui.theme.RedesignLightGray

@Composable
fun DiscoverScreen() {
    Column() {
        Text(
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp),
            text = "Chef on spotlight",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h4
        )
        ChefBanner(
            source = R.drawable.chef,
            description = "Pellentesque sollicitudin egestas accumsan egestas amet."
        )
        FollowButton(name = "Ariolla")
        Row(Modifier.height(300.dp)) {
            Image(
                modifier = Modifier
                    .padding(0.dp, 10.dp, 10.dp, 10.dp)
                    .weight(6f)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(20.dp)),
                painter = painterResource(id = R.drawable.recipe3),
                contentDescription = "Dish",
                contentScale = ContentScale.Crop,
            )
            Column(Modifier.weight(4f)) {
                Image(
                    modifier = Modifier
                        .padding(10.dp, 10.dp, 0.dp, 10.dp)
                        .weight(1f)
                        .height(150.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    painter = painterResource(id = R.drawable.recipe2),
                    contentDescription = "Dish",
                    contentScale = ContentScale.Crop,
                )
                Image(
                    modifier = Modifier
                        .padding(10.dp, 10.dp, 0.dp, 10.dp)
                        .weight(1f)
                        .height(150.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    painter = painterResource(id = R.drawable.recipe1),
                    contentDescription = "Dish",
                    contentScale = ContentScale.Crop,
                )
            }
        }
        Divider(
            color = RedesignLightGray,
            thickness = 1.dp,
            modifier = Modifier.padding(10.dp, 20.dp, 10.dp, 20.dp)
        )
        MultipleDishesBanner("Discover more dishes by exploring what’s new")
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    FoodIdeasTheme {
        DiscoverScreen()
    }
}