package org.me2you.gwethekmm.ui.components.profilescreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.me2you.gwethekmm.ui.theme.AccentA
import org.me2you.gwethekmm.ui.theme.AccentX
import org.me2you.gwethekmm.ui.theme.SoftLav

@Composable
fun ProfileHeader(profileName: String, profileNumber: String){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Icon(
            Icons.Default.Person,
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(150.dp),
            tint = AccentX
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = profileName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = AccentA
        )
        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = profileNumber,
            color = SoftLav,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}