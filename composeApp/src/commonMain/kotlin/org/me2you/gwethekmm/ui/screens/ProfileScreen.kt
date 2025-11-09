package org.me2you.gwethekmm.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.ui.components.profilescreen.ProfileMenuItem
import org.me2you.gwethekmm.ui.components.profilescreen.ProfileMenuItemNoArrows

//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter

@Composable
fun ProfileScreen() {
    val colorScheme = MaterialTheme.colorScheme

    Scaffold(
        containerColor = colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
//            Spacer(modifier = Modifier.height(40.dp))
//
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
//            Image(
//                painter = ColorPainter(color = Color.Green),
//                contentDescription = "Profile Image",
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .size(100.dp)
//                    .clip(CircleShape)
//            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Admin Kamaa",
//                color = colorScheme.onPrimary,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "+254712346789",
//                color = colorScheme.onPrimary.copy(alpha = 0.7f),
                fontSize = 14.sp
            )
            }

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
                        color = colorScheme.onBackground
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    ProfileMenuItem(icon = Icons.Default.Person, title = "Personal Information", onClick = {})
                    ProfileMenuItem(icon = Icons.AutoMirrored.Filled.List, title = "My Medical History", onClick = {})
//                    ProfileMenuItem(icon = Icons.Default.Refresh, title = "Refund")
                    ProfileMenuItem(icon = Icons.Default.Lock, title = "Change Password", onClick = {})
                    ProfileMenuItem(icon = Icons.Default.Language, title = "Change Language", onClick = {})
                    ProfileMenuItemNoArrows(icon = Icons.Default.Delete, title = "Delete My Account", onClick = {})
//                    ProfileMenuItemNoArrows(icon = Icons.AutoMirrored.Filled.Logout, title = "Logout", onClick = {navController.navigate("login")})
                }
            }
        }
    }
}

@Preview
@Composable
fun ProfilePreview(){
    MaterialTheme {
        ProfileScreen()
    }
}
