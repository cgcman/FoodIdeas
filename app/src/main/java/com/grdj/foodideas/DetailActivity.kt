package com.grdj.foodideas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grdj.foodideas.ui.theme.FoodIdeasTheme

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodIdeasTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "Food image",
            )
            Column(Modifier.padding(10.dp)) {
                Text(
                    text = "Pasta",
                    style = MaterialTheme.typography.h3
                )
                Text(
                    text = "145 calorias",
                    color = Color.Red,
                    style = MaterialTheme.typography.h6,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "Women, Dress, Summer",
                    style = MaterialTheme.typography.subtitle1
                )
                Rating()
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Description",
                    style = MaterialTheme.typography.h5
                )
                Text(
                    textAlign = TextAlign.Justify,
                    text = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",
                )
            }
        }
    }
}

@Composable
fun Rating() {
    val range = (0..4)
    val state = remember { mutableStateListOf(false, false, false, false, false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 0.dp, vertical = 5.dp)
    ) {
        range.forEach { index ->
            RatingItem(index, state[index]) { selectedIndex ->
                range.forEach { currentIndex ->
                    state[currentIndex] = (currentIndex <= selectedIndex)
                }
            }
        }
    }
}

@Composable
fun RatingItem(index: Int, selected: Boolean, onClick: (Int) -> Unit) {
    Image(
        painter = painterResource(id = R.drawable.star),
        contentDescription = null,
        colorFilter = ColorFilter.tint(if (selected) MaterialTheme.colors.onSurface else MaterialTheme.colors.surface),
        modifier = Modifier.clickable {
            onClick.invoke(index)
        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FoodIdeasTheme {
        MainContent()
    }
}