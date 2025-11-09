package org.me2you.gwethekmm.ui.components.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SpaceDashboard
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.me2you.gwethekmm.isPlatformDesktop
import org.me2you.gwethekmm.ui.theme.AccentG

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GwetheTopBar(
    onSettingsClick: () -> Unit,
    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    val desktopPlatform: MutableState<Boolean> = remember { mutableStateOf( isPlatformDesktop()) }

    TopAppBar(
        title = {
            Text(
                text = "Gwethe Nation",
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = if (desktopPlatform.value) 40.sp else 22.sp,
                    letterSpacing = 1.2.sp
                ),
            )
        },
        actions = {
            IconButton(onClick = onSettingsClick) {
                Icon(
                    imageVector = Icons.Default.SpaceDashboard,
                    contentDescription = "Settings",
                    modifier = Modifier.size(40.dp)
//                    tint = Color.White
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip( RoundedCornerShape(bottomStart = 30.dp, bottomEnd = 30.dp) )
            .height(if (isPlatformDesktop()) 80.dp else 62.dp)
            .shadow(6.dp, RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 0.dp))
            .background(AccentG)
            .padding(8.dp),

        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = AccentG.copy(0.7f),
            titleContentColor = Color.White,  // AccentF
            actionIconContentColor = Color.White
        )
    )
}
