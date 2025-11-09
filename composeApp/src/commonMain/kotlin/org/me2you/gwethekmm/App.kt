package org.me2you.gwethekmm

//import org.me2you.gwethekmm.navigation.SplashScreen
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.CrossfadeTransition
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.navigation.HomeScreen
import org.me2you.gwethekmm.ui.theme.GwetheKMMTheme

@Composable
@Preview
fun App() {
    GwetheKMMTheme {
        Navigator(HomeScreen){ navigator ->
//            SlideTransition(navigator)
            CrossfadeTransition(navigator)
        }
    }
}

fun isPlatformDesktop(): Boolean{
    val platform = getPlatform()
    return !(platform.name.lowercase().contains("android") || platform.name.lowercase().contains("ios"))
}