package org.me2you.gwethekmm.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.ui.theme.GwetheAppTheme

@Composable
fun DroidSplashScreen(onGetStarted: () -> Unit){
    CStartScreen(onGetStarted = onGetStarted)
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview(showBackground = true)
@Composable
fun PreviewStartScreen(){
    GwetheAppTheme {
        DroidSplashScreen {}
    }
}