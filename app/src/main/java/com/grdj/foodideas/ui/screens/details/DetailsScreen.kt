package com.grdj.foodideas.ui.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grdj.foodideas.R
import com.grdj.foodideas.ui.customviews.FollowButton
import com.grdj.foodideas.ui.customviews.IngredientsBanner
import com.grdj.foodideas.ui.customviews.ServingsBanner
import com.grdj.foodideas.ui.theme.FoodIdeasTheme

@Composable
fun DetailsScreen(){
    Column(Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
            elevation = 20.dp,
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                modifier = Modifier
                    .height(220.dp),
                painter = painterResource(id = R.drawable.dish4),
                contentDescription = "Dish",
                contentScale = ContentScale.Crop,
            )
        }
        Text(
            modifier = Modifier.padding(top = 30.dp),
            text = "Octopus with citrus salad & herbs",
            color = Color.Black,
            style = MaterialTheme.typography.h4
        )
        Text(
            modifier = Modifier.padding(top = 30.dp),
            text = "Sem aliquet sit urna aliquam vitae nisl convallis ac, tristique. Nec lectus eget feugiat ornare. ",
            color = Color.Black,
            style = MaterialTheme.typography.subtitle1
        )
        Row(modifier = Modifier.
        padding(top = 20.dp)) {
            Text(
                modifier = Modifier
                    .padding(top = 30.dp)
                    .weight(1f),
                text = "Ingredients",
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.h6
            )
            ServingsBanner(amount = 3)
        }
        IngredientsBanner(
            source = R.drawable.chicken_ico,
            description = "Diam magna purus enim ipsum. Scelerisque blandit.",
            weight = 50
        )
        IngredientsBanner(
            source = R.drawable.meat_ico,
            description = "Diam magna purus enim ipsum. Scelerisque blandit.",
            weight = 50
        )
        IngredientsBanner(
            source = R.drawable.salad_ico,
            description = "Diam magna purus enim ipsum. Scelerisque blandit.",
            weight = 50
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodIdeasTheme {
        DetailsScreen()
    }
}