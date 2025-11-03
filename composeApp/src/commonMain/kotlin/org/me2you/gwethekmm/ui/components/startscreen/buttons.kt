package org.me2you.gwethekmm.ui.components.startscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.me2you.gwethekmm.ui.theme.AccentG
import org.me2you.gwethekmm.ui.theme.AccentT


@Composable
fun GradientPillButton(label: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier.clip(RoundedCornerShape(30.dp)),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
//        elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp)
                .clip(RoundedCornerShape(30.dp))
                .background(Brush.horizontalGradient(colors = listOf(AccentG, AccentT))),
            contentAlignment = Alignment.Center
        ) {
            Text(text = label, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

//@Composable
//fun OutlinedSignInButton(label: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
//    OutlinedButton(
//        onClick = onClick,
//        modifier = modifier
//            .clip(RoundedCornerShape(28.dp))
//            .height(52.dp)
//            .clip(RoundedCornerShape(30.dp)),
//
//        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White),
//        border = ButtonDefaults.outlinedButtonBorder(enabled = true).copy(width = 1.dp)
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth(0.8f)
//                .height(44.dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Text(
//                text = label,
//                fontSize = 16.sp,
//                fontWeight = FontWeight.SemiBold,
//            )
//        }
//    }
//}