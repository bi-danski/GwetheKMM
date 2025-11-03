package org.me2you.gwethekmm.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.me2you.gwethekmm.ui.components.homescreen.GwetheBottomNav
import org.me2you.gwethekmm.ui.components.homescreen.GwetheProductGrid
import org.me2you.gwethekmm.ui.components.homescreen.GwetheTopBar
import org.me2you.gwethekmm.ui.components.homescreen.ToolProductGrid
import org.me2you.gwethekmm.ui.theme.AccentG

@Composable
fun CHomeScreen(
    onNavigateToCart: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    var product2Search by remember { mutableStateOf("Search Product") }
    val gwetheProducts = remember { mutableStateListOf("Gwethe", "Veve") }
    val toolProducts = remember {
        mutableStateListOf("Njugu", "Gomba", "Wabling", "Tropicals", "Kashata", "Mchokey")
    }

    Scaffold(
        topBar = {
            GwetheTopBar(onSettingsClick = onNavigateToSettings)
        },
        bottomBar = {
            GwetheBottomNav(
                onHomeClick = {},
                onCartClick = onNavigateToCart,
                onProfileClick = onNavigateToProfile
            )
        }
    ) { padding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(10.dp)
            ){
                OutlinedTextField(
                    value = product2Search,
                    {product2Search = it },
                    modifier = Modifier
                        .fillMaxWidth(),
//                        .clip(RoundedCornerShape(15.dp))

                    trailingIcon = {
                        if (product2Search.isNotBlank()){
                            IconButton(onClick = { product2Search = ""}) {
                                Icon(Icons.Default.Search, contentDescription = null, tint = Color.Green)
                            }
                        }

                    }
                )
            }
            Text(
                text = "Main Course",
                fontWeight = FontWeight.Bold,
                color = AccentG,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))

            GwetheProductGrid(products = gwetheProducts)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "T00LS",
                color = AccentG,
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ToolProductGrid(products = toolProducts)
        }
    }
}






