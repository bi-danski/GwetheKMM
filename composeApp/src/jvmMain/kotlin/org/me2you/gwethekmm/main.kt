package org.me2you.gwethekmm

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.rememberWindowState
import org.me2you.gwethekmm.ui.theme.DarkColors

fun main() = application {
    val windowState = rememberWindowState(
        width = 1200.dp,
        height = 800.dp,
        placement = WindowPlacement.Floating
    )
    Window(
        state = windowState,
        onCloseRequest = ::exitApplication,
        title = "Gwethe Nation",
        resizable = true,
        focusable = true,
        alwaysOnTop = false

    ) {
        MaterialTheme(colorScheme = DarkColors) {
            App()
        }
    }
}
