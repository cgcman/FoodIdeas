package com.grdj.foodideas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
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
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.grdj.foodideas.data.FoodMenuItems.FoodCategories.types
import com.grdj.foodideas.ui.screens.details.DetailsScreen
import com.grdj.foodideas.ui.screens.discover.DiscoverScreen
import com.grdj.foodideas.ui.screens.home.HomeScreen
import com.grdj.foodideas.ui.theme.CustomLightGray
import com.grdj.foodideas.ui.theme.FoodIdeasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationMainView()
        }
    }
}

@Composable
fun ApplicationMainView(){
    FoodIdeasTheme {
        Row(modifier = Modifier
            .padding(all = 20.dp)
            .verticalScroll(rememberScrollState())) {
            DetailsScreen()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ApplicationMainView()
}

@Composable
fun FoodIdeaApplication() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = "home") {
            Home(navController)
        }
        composable(route = "list") {
            RecipeListScreen(navController)
        }
        composable(route = "detail/{recipeId}", arguments = listOf(navArgument("recipeId") {
            type = NavType.IntType
        })) { navBackStackEntry ->
            RecipeDetailScreen(navBackStackEntry.arguments!!.getInt("recipeId"))
        }
    }
}

@Composable
fun Home(navController: NavHostController?) {
    Row(
        modifier = Modifier.padding(all = 30.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Header()
            Body {
                navController?.navigate("list")
            }
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
fun Body(clickAction: () -> Unit) {
    Text(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 30.dp),
        text = "¿Or something of?",
        color = Color.Black,
        style = MaterialTheme.typography.h6
    )
    Row(modifier = Modifier.clickable {
        clickAction.invoke()
    }) {
        for (item in 0..2) {
            FoodMenuItem(
                types[item].image,
                types[item].name
            )
        }
    }
    Row(modifier = Modifier.clickable {
        clickAction.invoke()
    }) {
        for (item in 3..5) {
            FoodMenuItem(
                types[item].image,
                types[item].name
            )
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
                    contentDescription = name
                )
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
