package org.me2you.gwethekmm.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.ui.components.profilescreen.CustomProfileMenuItem
import org.me2you.gwethekmm.ui.components.profilescreen.ProfileHeader
import org.me2you.gwethekmm.ui.components.profilescreen.ProfileMenuItem
import org.me2you.gwethekmm.ui.theme.SoftLav

//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter

@Composable
fun CProfileScreen(
    onLogOut: () -> Unit
) {
    val colorScheme = MaterialTheme.colorScheme
    Scaffold(
        containerColor = colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ProfileHeader(profileNumber = "+254795179397", profileName = "Admin Kamaa")

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                modifier = Modifier
                    .fillMaxSize(),
                colors = CardDefaults.cardColors(containerColor = colorScheme.background),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = "Account Overview",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = SoftLav
//                        color = colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    ProfileMenuItem(icon = Icons.Default.Person, title = "Personal Information", onClick = {})
                    ProfileMenuItem(icon = Icons.AutoMirrored.Filled.List, title = "My Medical History", onClick = {})
                    ProfileMenuItem(icon = Icons.Default.Lock, title = "Change Password", onClick = {})
                    ProfileMenuItem(icon = Icons.Default.Language, title = "Change Language", onClick = {})
                    ProfileMenuItem(icon = Icons.Default.Delete, title = "Delete My Account", onClick = {})
                    ProfileMenuItem(icon = Icons.Default.AccountBalanceWallet, title = "Gwethe Wallet", onClick = {})
                    CustomProfileMenuItem(icon = Icons.AutoMirrored.Filled.Logout,
                        title = "Log Out",
                        onClick = onLogOut,
                        iconColor = Color.Red
                        )
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfilePreview(){
    MaterialTheme {
        CProfileScreen( onLogOut = {})
    }
}
