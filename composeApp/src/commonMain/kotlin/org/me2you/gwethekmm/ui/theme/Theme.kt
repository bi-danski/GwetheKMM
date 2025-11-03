package org.me2you.gwethekmm.ui.theme

//import androidx.annotation.RequiresApi
//import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
//import androidx.compose.material3.dynamicDarkColorScheme
//import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
//import androidx.compose.ui.platform.LocalContext

@Composable
fun GwetheKMMTheme (
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}