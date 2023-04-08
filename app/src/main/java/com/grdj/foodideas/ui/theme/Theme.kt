package com.grdj.foodideas.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = RedesignLightGray,
    primaryVariant = RedesignLightBrown,
    secondary = RedesignDarkBrown,
    surface = Color.Gray,
    background = Color.White,
)

private val LightColorPalette = lightColors(
    primary = RedesignBlack,
    primaryVariant = RedesignLightBrown,
    secondary = RedesignDarkBrown,
    background = RedesignLightGray,
    surface = RedesignLightGreen,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun FoodIdeasTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}