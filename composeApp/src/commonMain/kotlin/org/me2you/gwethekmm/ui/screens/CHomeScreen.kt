package org.me2you.gwethekmm.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import org.me2you.gwethekmm.ui.theme.AccentG

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CHomeScreen(
    onNavigateToCart: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateToSettings: () -> Unit,
    modifier: Modifier = Modifier
) {
    var product2Search by remember { mutableStateOf("") }
    val gwetheProducts = remember { mutableMapOf("Gwethe" to 50, "Veve" to 300) }
    val toolProducts = remember {
        mutableMapOf("Njugu" to 20, "Gomba" to 5, "Wabling" to 35, "Tropicals" to 10, "Kashata" to 20, "Mchokey" to 120)
    }

    Scaffold(
        topBar = { GwetheTopBar(onSettingsClick = onNavigateToSettings) },
        bottomBar = {
            GwetheBottomNav(
                selectedIndex = 0,
                onHomeClick = {},
                onCartClick = onNavigateToCart,
                onProfileClick = onNavigateToProfile
            )
        }
    ) { padding ->
        Column(
//            horizontalAlignment = if (isPlatformDesktop()) Alignment.CenterHorizontally else Alignment.Start,
            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState()) // ✅ unified scroll on desktop + Android
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = product2Search,
                onValueChange = { product2Search = it },
                placeholder = { Text("Search Product") },
                trailingIcon = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.Search, contentDescription = null, tint = Color.Green)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = OutlinedTextFieldDefaults.shape
            )

            Spacer(modifier = Modifier.height(25.dp))

            GwetheProductGrid(products = gwetheProducts)

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tools",
                color = AccentG,
                fontSize = 32.sp,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            GwetheProductGrid(products = toolProducts)
        }
    }
}
