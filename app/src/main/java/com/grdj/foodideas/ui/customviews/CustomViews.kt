package com.grdj.foodideas.ui.customviews

import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.grdj.foodideas.R
import com.grdj.foodideas.ui.theme.*

@Composable
fun DishAvatar(
    source: Int,
    description: String,
    padding: Int,
    zIndex: Float){
    FoodIdeasTheme() {
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .border(3.dp, Color.White, CircleShape)
            .padding(start = padding.dp)
            .zIndex(zIndex)) {
            Image(
                painter = painterResource(id = source),
                contentDescription = description,
                modifier = Modifier
                    .size(60.dp)
                    .padding(5.dp)
                    .background(MaterialTheme.colors.primary),
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}

@Composable
fun MultipleDishAvatars(){
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .width(IntrinsicSize.Max)
    ) {
        DishAvatar(R.drawable.dish4, "Chicken", 40, 2f)
        DishAvatar(R.drawable.dish5, "Pizza", 20, 3f)
        DishAvatar(R.drawable.dish6, "Chicken", 0, 4f)
    }
}

@Composable
fun MultipleDishesBanner(text: String){
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            MultipleDishAvatars()
            Text(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(3f),
                text = text,
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.subtitle1,)
            Image(
                painter = painterResource(R.drawable.baseline_arrow_circle_right_24),
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .size(30.dp)
            )
        }
    }
}

@Composable
fun ChefBanner(source: Int, description: String){
    Box(
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 10.dp)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colors.primary)
            ) {
                Image(
                    painter = painterResource(id = source),
                    contentDescription = description,
                    modifier = Modifier
                        .size(80.dp)
                        .padding(5.dp)
                        .background(MaterialTheme.colors.primary),
                    contentScale = ContentScale.FillHeight,
                )
            }
            Column(Modifier.padding(start = 20.dp)) {
                Text(
                    text = description,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth())
                Text(
                    text = "- Ariolla",
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth())
            }

        }
    }
}

@Composable
fun IngredientsBanner(
        source: Int,
        description: String,
        weight: Int
    ){
    Box(
        modifier = Modifier
            .padding(top = 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.background)
            .padding(0.dp, 10.dp, 0.dp, 10.dp)
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colors.background)
            ) {
                Image(
                    painter = painterResource(id = source),
                    contentDescription = description,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(5.dp),
                    contentScale = ContentScale.FillHeight,
                )
            }
            Column(Modifier.padding(start = 20.dp)) {
                Text(
                    text = "$weight"+"g",
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxWidth())
                Text(
                    text = description,
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .fillMaxWidth())
            }

        }
    }
}

@Composable
fun FollowButton(name: String){
    Box(modifier = Modifier
        .padding(0.dp, 20.dp, 0.dp, 20.dp)
        .width(IntrinsicSize.Max)
        .clip(RoundedCornerShape(20.dp))
        .background(MaterialTheme.colors.surface)
        .padding(5.dp)
    ) {
        Row() {
            Image(
                painter = painterResource(R.drawable.baseline_add_circle_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .size(20.dp)
            )
            Text(
                text = "Follow $name",
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .padding(2.dp, 2.dp, 10.dp, 0.dp)
                    .fillMaxWidth())
        }
    }
}

@Composable
fun ServingsBanner(amount: Int){
    Box(modifier = Modifier
        .padding(0.dp, 20.dp, 0.dp, 20.dp)
        .width(IntrinsicSize.Max)
        .clip(RoundedCornerShape(5.dp))
        .background(MaterialTheme.colors.primaryVariant)
        .padding(5.dp)
    ) {
        Row() {
            Text(
                text = "$amount Servings",
                style = MaterialTheme.typography.h6,
                modifier = Modifier
                    .padding(2.dp, 2.dp, 10.dp, 0.dp)
                    .fillMaxWidth()
                    .weight(6f),
                color = MaterialTheme.colors.secondary
            )
            Image(
                painter = painterResource(R.drawable.baseline_add_circle_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
                    .size(30.dp)
                    .weight(2f),
                colorFilter = ColorFilter.tint(RedesignDarkBrown)
            )
            Image(
                painter = painterResource(R.drawable.baseline_remove_circle_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(1.dp)
                    .size(30.dp)
                    .weight(2f),
                colorFilter = ColorFilter.tint(RedesignDarkBrown)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodIdeasTheme {
        ChefBanner(
            source = R.drawable.chef,
            description = "Pellentesque sollicitudin egestas accumsan egestas amet."
        )
    }
}
