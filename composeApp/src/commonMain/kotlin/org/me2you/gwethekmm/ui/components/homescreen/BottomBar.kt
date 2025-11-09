package org.me2you.gwethekmm.ui.components.homescreen

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.me2you.gwethekmm.ui.theme.AccentB
import org.me2you.gwethekmm.ui.theme.AccentG

@Composable
fun GwetheBottomNav(
    selectedIndex: Int, // <-- Added
    onHomeClick: () -> Unit,
    onCartClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)),
        containerColor = AccentG,
        contentColor = Color.White// Purple900.copy(0.6f)
    ) {
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = onHomeClick,
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = AccentB) },
            label = { Text("Home", color = AccentB) }
        )
        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = onCartClick,
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = AccentB) },
            label = { Text("Cart", color = AccentB) }
        )
        NavigationBarItem(
            selected = selectedIndex == 2,
            onClick = onProfileClick,
            icon = { Icon(Icons.Default.Person, contentDescription = "Profile", tint = AccentB) },
            label = { Text("Profile", color = AccentB) }
        )
    }
}
