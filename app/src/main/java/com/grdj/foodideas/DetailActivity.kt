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
import com.grdj.foodideas.data.MenuItem
import com.grdj.foodideas.data.SampleItem
import com.grdj.foodideas.ui.theme.FoodIdeasTheme
import com.grdj.foodideas.ui.theme.newMagenta

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
            ProductHeader()
            ProductDetail(SampleItem)
        }
    }
}

@Composable
fun ProductHeader() {
    Image(
        modifier = Modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "",
    )
}

@Composable
fun ProductDetail(menuItem: MenuItem) {
    Column(Modifier.padding(10.dp)) {
        menuItem.apply {
            Name(name)
            Details(categories, calories)
            Rating()
            CustomDivider()
            Description(description)
        }
    }
}

@Composable
fun CustomDivider() {
    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.padding(5.dp)
    )
}

@Composable
fun Name(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h3
    )
}

@Composable
fun Details(categories: String, calories: String) {
    Row {
        Text(
            text = categories,
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.weight(1f)

        )
        Text(
            text = calories,
            color = Color.Red,
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Right,
        )
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
        colorFilter = ColorFilter.tint(if (selected) newMagenta() else MaterialTheme.colors.surface),
        modifier = Modifier.clickable {
            onClick.invoke(index)
        },
    )
}

@Composable
fun Description(description: String) {
    Text(
        text = "Description",
        style = MaterialTheme.typography.h5
    )
    Text(
        textAlign = TextAlign.Justify,
        text = description
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FoodIdeasTheme {
        MainContent()
    }
}