package com.grdj.foodideas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grdj.foodideas.data.FoodMenuItems.SampleData
import com.grdj.foodideas.ui.theme.CustomLightGray
import com.grdj.foodideas.ui.theme.FoodIdeasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodIdeasTheme {
                Home()
            }
        }
    }
}

@Composable
fun Home() {
    Row(
        modifier = Modifier.padding(all = 30.dp),
        horizontalArrangement = Arrangement.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header()
            Body()
        }
    }
}

@Composable
fun Header() {
    Text(
        text = "¿What do we eat today?",
        color = Color.Black,
        style = MaterialTheme.typography.h5
    )
    Image(
        modifier = Modifier
            .padding(all = 20.dp)
            .size(200.dp),
        painter = painterResource(id = R.drawable.roulette),
        contentDescription = "Roulette")
    Text(
        text = "Random food",
        color = Color.Black,
        style = MaterialTheme.typography.h5
    )
    Surface(
        modifier = Modifier.padding(all = 30.dp)
    ) {
        Divider(
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}

@Composable
fun Body() {
    Text(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 30.dp),
        text = "¿Or something of?",
        color = Color.Black,
        style = MaterialTheme.typography.h6
    )
    Row() {
        for (item in 0..2) {
            FoodMenuItem(
                SampleData.foodCategories[item].image,
                SampleData.foodCategories[item].name)
        }
    }
    Row() {
        for (item in 3..5) {
            FoodMenuItem(
                SampleData.foodCategories[item].image,
                SampleData.foodCategories[item].name)
        }
    }
}

@Composable
fun FoodMenuItem(image: Int, name: String) {
    Surface(modifier = Modifier.padding(all = 10.dp)) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(RoundedCornerShape(10.dp))
                .border(1.dp, Color.LightGray, RoundedCornerShape(10.dp))
                .background(color = CustomLightGray),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    modifier = Modifier
                        .padding(all = 2.dp)
                        .size(55.dp),
                    painter = painterResource(id = image),
                    contentDescription = name)
                Text(
                    textAlign = TextAlign.Center,
                    text = name,
                    color = Color.Black,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodIdeasTheme {
        Home()
    }
}
