package org.me2you.gwethekmm.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Purple900 = Color(0xFF0B0620)
val AccentA = Color(0xFF7C4DFF)
val AccentB = Color(0xFF6DE2FF)
val AccentG = Color(0xFF4CAF50)
val SoftLav = Color(0xFFB59CFF)
val AccentC = Color(0xFF388E3C)
val AccentF = Color(0xFFC8E6C9)
val AccentH = Color(0xFF81C784)
val AccentI = Color(0xFF2E7D32)
val AccentK = Color(0xFF69F0AE)
val AccentX = Color(0xFF94C9AA)
val AccentT = Color(0xFF43A047)


val DarkColors = darkColorScheme(
    primary = AccentG,
    onPrimary = Color.White,
    background = Purple900,
    surface = Color(0xFF160628),
    onBackground = Color.White
)

val LightColors = lightColorScheme(
    primary = Color(0xFF4CAF50), // Green
    onPrimary = Color.White,
    secondary = Color(0xFF0288D1), // Blue
    background = Color(0xFFF5F5F5), // Light gray
    surface = Color(0xFFE0E0E0)
)