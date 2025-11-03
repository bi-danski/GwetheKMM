package org.me2you.gwethekmm.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.ui.theme.GwetheAppTheme

@Composable
fun DroidHomeScreen(
    onNavigateToSettings: () -> Unit,
    onNavigateToCart: () -> Unit,
    onNavigateToProfile: () -> Unit
){
    CHomeScreen(onNavigateToSettings = onNavigateToSettings, onNavigateToCart = onNavigateToCart, onNavigateToProfile = onNavigateToProfile)

}
@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen(){
    GwetheAppTheme {
        DroidHomeScreen (
            {},
            {},
            {}
        )
    }
}