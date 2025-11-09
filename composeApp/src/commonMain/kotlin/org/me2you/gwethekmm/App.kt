package org.me2you.gwethekmm

//import org.me2you.gwethekmm.navigation.SplashScreen
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.navigation.GwetheNavigation
import org.me2you.gwethekmm.navigation.HomeScreen

@Composable
@Preview
fun App() {
    GwetheNavigation(
        screen = HomeScreen
    )
}

