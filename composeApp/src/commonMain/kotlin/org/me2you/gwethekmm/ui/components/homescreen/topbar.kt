package org.me2you.gwethekmm.ui.components.homescreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SpaceDashboard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.text.font.FontWeight
import org.me2you.gwethekmm.ui.theme.AccentB
import org.me2you.gwethekmm.ui.theme.AccentG

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GwetheTopBar(onSettingsClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = "Gwethe Nation",
                color = AccentG,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
            )
        },
        actions = {
            IconButton(onClick = onSettingsClick) {
                Icon(
                    Icons.Default.SpaceDashboard,
                    contentDescription = "Settings",
                    tint = AccentB
                )
            }
        },
//        colors = TopAppBarColors(
//            containerColor = Accent,
//            scrolledContainerColor = TODO(),
//            navigationIconContentColor = TODO(),
//            titleContentColor = AccentG,
//            actionIconContentColor = TODO(),
//            subtitleContentColor = TODO()
//        )
    )
}