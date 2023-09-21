package com.dart.campushelper.ui.theme

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.dart.campushelper.data.AppContainer
import com.dart.campushelper.data.AppDataStore.Companion.DEFAULT_VALUE_ENABLE_SYSTEM_COLOR
import com.dart.campushelper.data.AppDataStore.Companion.DEFAULT_VALUE_SELECTED_DARK_MODE
import com.example.compose.md_theme_dark_background
import com.example.compose.md_theme_dark_error
import com.example.compose.md_theme_dark_errorContainer
import com.example.compose.md_theme_dark_inverseOnSurface
import com.example.compose.md_theme_dark_inversePrimary
import com.example.compose.md_theme_dark_inverseSurface
import com.example.compose.md_theme_dark_onBackground
import com.example.compose.md_theme_dark_onError
import com.example.compose.md_theme_dark_onErrorContainer
import com.example.compose.md_theme_dark_onPrimary
import com.example.compose.md_theme_dark_onPrimaryContainer
import com.example.compose.md_theme_dark_onSecondary
import com.example.compose.md_theme_dark_onSecondaryContainer
import com.example.compose.md_theme_dark_onSurface
import com.example.compose.md_theme_dark_onSurfaceVariant
import com.example.compose.md_theme_dark_onTertiary
import com.example.compose.md_theme_dark_onTertiaryContainer
import com.example.compose.md_theme_dark_outline
import com.example.compose.md_theme_dark_primary
import com.example.compose.md_theme_dark_primaryContainer
import com.example.compose.md_theme_dark_secondary
import com.example.compose.md_theme_dark_secondaryContainer
import com.example.compose.md_theme_dark_surface
import com.example.compose.md_theme_dark_surfaceTint
import com.example.compose.md_theme_dark_surfaceVariant
import com.example.compose.md_theme_dark_tertiary
import com.example.compose.md_theme_dark_tertiaryContainer
import com.example.compose.md_theme_light_background
import com.example.compose.md_theme_light_error
import com.example.compose.md_theme_light_errorContainer
import com.example.compose.md_theme_light_inverseOnSurface
import com.example.compose.md_theme_light_inversePrimary
import com.example.compose.md_theme_light_inverseSurface
import com.example.compose.md_theme_light_onBackground
import com.example.compose.md_theme_light_onError
import com.example.compose.md_theme_light_onErrorContainer
import com.example.compose.md_theme_light_onPrimary
import com.example.compose.md_theme_light_onPrimaryContainer
import com.example.compose.md_theme_light_onSecondary
import com.example.compose.md_theme_light_onSecondaryContainer
import com.example.compose.md_theme_light_onSurface
import com.example.compose.md_theme_light_onSurfaceVariant
import com.example.compose.md_theme_light_onTertiary
import com.example.compose.md_theme_light_onTertiaryContainer
import com.example.compose.md_theme_light_outline
import com.example.compose.md_theme_light_primary
import com.example.compose.md_theme_light_primaryContainer
import com.example.compose.md_theme_light_secondary
import com.example.compose.md_theme_light_secondaryContainer
import com.example.compose.md_theme_light_surface
import com.example.compose.md_theme_light_surfaceTint
import com.example.compose.md_theme_light_surfaceVariant
import com.example.compose.md_theme_light_tertiary
import com.example.compose.md_theme_light_tertiaryContainer


private val LightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint
)

private val DarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint
)

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun CampusHelperTheme(
    appContainer: AppContainer,
    content: @Composable () -> Unit
) {
    // Dynamic color is available on Android 12+
    val selectedDarkMode by appContainer.appRepository.observeSelectedDarkMode().collectAsState(
        initial = DEFAULT_VALUE_SELECTED_DARK_MODE
    )
    val enableSystemColor by appContainer.appRepository.observeEnableSystemColor().collectAsState(
        initial = DEFAULT_VALUE_ENABLE_SYSTEM_COLOR
    )

    val darkTheme = when (selectedDarkMode) {
        "开启" -> true
        "关闭" -> false
        else -> isSystemInDarkTheme()
    }

    val colorScheme: ColorScheme = when {
        enableSystemColor == true && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    val window = (view.context as Activity).window
    if (!view.isInEditMode) {
        SideEffect {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            window.navigationBarColor = Color.Transparent.toArgb()
            WindowInsetsControllerCompat(window, view).let {
                it.isAppearanceLightStatusBars = !darkTheme
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}