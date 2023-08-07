package com.youshail.calorietracker.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.youshail.core_ui.BrightBlue
import com.youshail.core_ui.DarkBlue
import com.youshail.core_ui.DarkGray
import com.youshail.core_ui.Dimensions
import com.youshail.core_ui.LightGray
import com.youshail.core_ui.LocalSpacing
import com.youshail.core_ui.MediumGray
import com.youshail.core_ui.TerraCotta
import com.youshail.core_ui.TextWhite

private val DarkColorPalette = darkColors(
    primary = BrightBlue,
    primaryVariant = DarkBlue,
    secondary = TerraCotta,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LightGray,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = BrightBlue,
    primaryVariant = DarkBlue,
    secondary = TerraCotta,
    background = Color.White,
    onBackground = DarkGray,
    surface = Color.White,
    onSurface = DarkGray,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

@Composable
fun CaloryTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}