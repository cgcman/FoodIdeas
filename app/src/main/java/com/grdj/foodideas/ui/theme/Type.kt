package com.grdj.foodideas.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.grdj.foodideas.R

// Set of Material typography styles to start with
val PromptTypeFamily = FontFamily(
    Font(R.font.prompt_thin, FontWeight.Thin),
    Font(R.font.prompt_bold, FontWeight.Bold),
    Font(R.font.prompt_regular, FontWeight.Normal),
    Font(R.font.prompt_medium, FontWeight.Medium),
    Font(R.font.prompt_light, FontWeight.Light)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = PromptTypeFamily,
        fontWeight = FontWeight.Light,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontFamily = PromptTypeFamily,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = PromptTypeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),
    h4 = TextStyle(
        fontFamily = PromptTypeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        letterSpacing = 0.sp
    ),
    h5 = TextStyle(
        fontFamily = PromptTypeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        letterSpacing = 0.15.sp
    ),
    h6 = TextStyle(
        fontFamily = PromptTypeFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = PromptTypeFamily,
        fontWeight = FontWeight.Light,
        fontSize = 15.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = PromptTypeFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        letterSpacing = 0.25.sp
    ),
)
