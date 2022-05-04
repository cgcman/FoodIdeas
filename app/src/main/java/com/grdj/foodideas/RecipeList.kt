package com.grdj.foodideas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.grdj.foodideas.data.MenuItem
import com.grdj.foodideas.data.SampleCategory
import com.grdj.foodideas.ui.theme.FoodIdeasTheme
import com.grdj.foodideas.ui.theme.newMagenta

class CategoryList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //RecipeListScreen()
        }
    }
}

@Composable
fun RecipeListScreen(navController: NavHostController?) {
    FoodIdeasTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column {
                RecipeHeader("Pizzas")
                RecipeListLazy(itemList = SampleCategory) { recipeId ->
                    navController?.navigate("detail/$recipeId")
                }
            }
        }
    }
}

@Composable
fun RecipeHeader(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h4,
        color = newMagenta(), modifier = Modifier.padding(4.dp)
    )
}

@Composable
fun RecipeList(itemList: List<MenuItem>, clickAction: (Int) -> Unit) {
    Column {
        itemList.forEach {
            Recipe(menuItem = it, clickAction = clickAction)
        }
    }
}

@Composable
fun RecipeListLazy(itemList: List<MenuItem>, clickAction: (Int) -> Unit) {
    LazyColumn {
        items(itemList) { item ->
            Recipe(menuItem = item, clickAction = clickAction)
        }
    }
}

@Composable
fun Recipe(menuItem: MenuItem, clickAction: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable { clickAction.invoke(menuItem.id) },
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            RecipeImage(menuItem.image)
            RecipeDetail(menuItem)
        }
    }
}

@Composable
fun RecipeImage(image: String) {
    Image(
        modifier = Modifier
            .size(48.dp),
        painter = painterResource(id = R.drawable.banner),
        contentDescription = "Recipe image",
    )
}

@Composable
fun RecipeDetail(menuItem: MenuItem) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(
            text = menuItem.name,
            style = MaterialTheme.typography.h5
        )
        Text(
            text = menuItem.calories,
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Light
        )
        Text(
            text = menuItem.categories,
            style = MaterialTheme.typography.subtitle2,
            fontWeight = FontWeight.Light
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    FoodIdeasTheme {
        //RecipeListScreen()
    }
}
