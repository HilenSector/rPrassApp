package com.professorsagi.rprassapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Define Deep Blue Color Palette
private val DeepBluePrimary = Color(0xFF0D47A1) // Darker Blue
private val DeepBlueSecondary = Color(0xFF1976D2) // Medium Blue
private val DeepBlueTertiary = Color(0xFF42A5F5) // Lighter Blue
private val DeepBlueBackground = Color(0xFFF5F5F5) // Light Gray Background
private val DeepBlueSurface = Color(0xFFFFFFFF) // White Surface
private val DeepBlueOnError = Color(0xFFFFFFFF) // White Text on Error
private val DeepBlueError = Color(0xFFB00020) // Standard Error Red

private val DarkColorScheme = darkColorScheme(
    primary = DeepBlueSecondary, // Use Medium Blue for primary in dark theme
    secondary = DeepBlueTertiary,
    tertiary = DeepBluePrimary,
    background = Color(0xFF121212), // Standard dark background
    surface = Color(0xFF1E1E1E), // Slightly lighter dark surface
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color.White,
    onSurface = Color.White,
    error = DeepBlueError,
    onError = DeepBlueOnError
)

private val LightColorScheme = lightColorScheme(
    primary = DeepBluePrimary,
    secondary = DeepBlueSecondary,
    tertiary = DeepBlueTertiary,
    background = DeepBlueBackground,
    surface = DeepBlueSurface,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    error = DeepBlueError,
    onError = DeepBlueOnError

    /* Other default colors to override if needed
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun RPrassAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, // Disable dynamic color for consistent branding
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // Assuming Typography.kt exists
        content = content
    )
}

