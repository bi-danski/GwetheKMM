package org.me2you.gwethekmm.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.getPlatform
import org.me2you.gwethekmm.ui.components.startscreen.GradientPillButton
import org.me2you.gwethekmm.ui.components.startscreen.NeuralGlow
import org.me2you.gwethekmm.ui.components.startscreen.TopAppBar
import org.me2you.gwethekmm.ui.theme.AccentG

@Composable
fun CStartScreen(onGetStarted: () -> Unit) {
    var lannister by remember { mutableStateOf(getPlatform().name) }
    var plat_form by remember { mutableStateOf(true) }

    if (lannister.contains("ios") || lannister.contains("android")){
        plat_form = false
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
//                Brush.verticalGradient(
//                 colors = listOf(Color(0xFF0B0620), Color(0xFF160628), Color(0xFF240733)),
//                     startY = 0f,
//                      endY = Float.POSITIVE_INFINITY
//                 )
                MaterialTheme.colorScheme.background
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
                .align(Alignment.TopCenter),
//                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NeuralGlow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(bottom = 80.dp)
//                    .background(MaterialTheme.colorScheme.background)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
                .align(Alignment.CenterEnd),
//                .background(MaterialTheme.colorScheme.background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = if (plat_form) "Elevate your thinking" else "Elevate your\n\nthinking",
                fontSize = 44.sp,
                fontWeight = FontWeight.ExtraBold,
                fontStyle = FontStyle.Italic,
                color = AccentG,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Discover endless ways our Gwethe can\nenhance your thinking",
                fontSize = 15.sp,
                color = AccentG,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .padding(horizontal = 28.dp, vertical = 36.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientPillButton(
                label = "Get Started",
                onClick = onGetStarted ,
                modifier = Modifier
                    .height(58.dp)
                    .fillMaxWidth(if (plat_form) 0.65f else 1f ),

            )

//            Spacer(modifier = Modifier.height(10.dp))

            GradientPillButton(
                label = "Sign In",
                onClick = {},
                modifier = Modifier
                    .height(58.dp)
                    .fillMaxWidth(if (plat_form) 0.65f else 1f )
            )
        }

        TopAppBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview
@Composable
fun SPlashPreview(){
    MaterialTheme {
        CStartScreen(onGetStarted = {})
    }
}
