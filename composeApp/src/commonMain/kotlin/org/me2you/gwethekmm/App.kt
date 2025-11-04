package org.me2you.gwethekmm

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.CrossfadeTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.navigation.SplashScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        Navigator(SplashScreen){ navigator ->
//            SlideTransition(navigator)
            CrossfadeTransition(navigator)
        }
    }
}