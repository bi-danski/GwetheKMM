package org.me2you.gwethekmm.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

//import cafe.adriel.voyager.core.screen.Screen
//import cafe.adriel.voyager.navigator.LocalNavigator
//import cafe.adriel.voyager.navigator.currentOrThrow
//import org.me2you.gwethekmm.ui.screens.CHomeScreen
//import org.me2you.gwethekmm.ui.screens.CStartScreen
//
//object SplashScreen : Screen {
//    @Composable
//    override fun Content() {
//        val navigator = LocalNavigator.currentOrThrow
//        CStartScreen(
//            onGetStarted = { navigator.push(HomeScreen) }
//        )
//    }
//}
//
//
//object HomeScreen : Screen {
//    @Composable
//    override fun Content() {
//        CHomeScreen(
//            onNavigateToCart = {},
//            onNavigateToProfile = {},
//            onNavigateToSettings = {},
//            modifier = Modifier
//        )
//    }
//
//}
sealed class GwetheScreen {
    data object SplashScreen: GwetheScreen()
    data object HomeScreen: GwetheScreen()

}


class GwetheNavigator <T>(initial: T){
    var currentScreen by mutableStateOf(initial)
        private set

    fun navigateTo(to: GwetheScreen.HomeScreen){
        currentScreen = to as T
    }
}