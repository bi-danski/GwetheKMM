package org.me2you.gwethekmm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.me2you.gwethekmm.ui.screens.CHomeScreen
import org.me2you.gwethekmm.ui.screens.CProfileScreen
import org.me2you.gwethekmm.ui.screens.CStartScreen


object SplashScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        CStartScreen(
            onGetStarted = { navigator.push(HomeScreen) }
        )
    }
}

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        CHomeScreen(
            onNavigateToCart = {},
            onNavigateToProfile = {
                navigator.push(ProfileScreen)
            },
            onNavigateToSettings = {},
            modifier = Modifier
        )
    }
}

object ProfileScreen: Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        CProfileScreen(
            onLogOut = {
                navigator.push(SplashScreen)
            }
        )
    }
}
