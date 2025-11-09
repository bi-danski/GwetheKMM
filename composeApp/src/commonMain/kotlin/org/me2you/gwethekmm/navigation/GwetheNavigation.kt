package org.me2you.gwethekmm.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import org.me2you.gwethekmm.ui.theme.GwetheKMMTheme

@Composable
fun GwetheNavigation(screen : Screen){
    GwetheKMMTheme {
        Navigator(screen){  navigator ->
            FadeTransition(navigator)
        }
    }
}