package org.me2you.gwethekmm.ui.components.homescreen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.me2you.gwethekmm.ui.theme.AccentC

@Composable
fun GwetheBottomNav(
    selectedIndex: Int, // <-- Added
    onHomeClick: () -> Unit,
    onCartClick: () -> Unit,
    onProfileClick: () -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)),

        containerColor = if (isSystemInDarkTheme()) colorScheme.background else AccentC.copy(0.8f),
        contentColor = Color.White// Purple900.copy(0.6f)
    ) {
        NavigationBarItem(
            selected = selectedIndex == 0,
            onClick = onHomeClick,
            icon = {
                Icon(Icons.Default.Home,
                contentDescription = "Home",
                )
            },
            label = {
                Text("Home",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        )
        NavigationBarItem(
            selected = selectedIndex == 1,
            onClick = onCartClick,
            icon = { Icon(
                Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                )
           },
            label = {
                Text("Cart",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        )
        NavigationBarItem(
            selected = selectedIndex == 2,
            onClick = onProfileClick,
            icon = { Icon(Icons.Default.Person,
                contentDescription = "Profile",
                )
            },
            label = {
                Text(
                    "Profile",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }
        )
    }
}
