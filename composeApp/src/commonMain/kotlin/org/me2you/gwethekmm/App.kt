package org.me2you.gwethekmm

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.me2you.gwethekmm.navigation.GwetheNavigator
import org.me2you.gwethekmm.navigation.GwetheScreen
import org.me2you.gwethekmm.ui.screens.CStartScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("...^_^...")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
        val navigator = remember { GwetheNavigator(GwetheScreen.SplashScreen) }

        when (navigator.currentScreen) {
            is GwetheScreen.SplashScreen -> CStartScreen(
                {
                    navigator.navigateTo(GwetheScreen.HomeScreen)
                }
            )
        }
    }
}