package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codehuntspk.compose_examples.R

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Profile Header Section
        ProfileHeader()

        // for spacing
        Spacer(modifier = Modifier.height(24.dp))

        // Account Section
        SectionTitle("Account")
        SettingItem(title = "Manage Profile", icon = Icons.Default.KeyboardArrowRight)
        SettingItem(title = "Password & Security", icon = Icons.Default.KeyboardArrowRight)
        SettingItem(title = "Notifications", icon = Icons.Default.KeyboardArrowRight)
        SettingItem(title = "Language", icon = Icons.Default.KeyboardArrowRight, value = "English")

        // for spacing
        Spacer(modifier = Modifier.height(24.dp))

        // Preferences Section
        SectionTitle("Preferences")
        SettingItem(title = "About Us", icon = Icons.Default.KeyboardArrowRight)
        SettingItem(title = "Theme", icon = Icons.Default.KeyboardArrowRight, value = "System Default")
        SettingItem(title = "Appointments", icon = Icons.Default.KeyboardArrowRight)

        // for spacing
        Spacer(modifier = Modifier.height(24.dp))

        // Support Section
        SectionTitle("Support")
        SettingItem(title = "Help Center", icon = Icons.Default.KeyboardArrowRight)
    }
}

@Composable
fun ProfileHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = com.codehuntspk.compose_examples.R.drawable.img_profile),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Muhammad Naveed",
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = "naveed@codehuntspk.com",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        textAlign = TextAlign.Start
    )
}

@Composable
fun SettingItem(
    title: String,
    icon: ImageVector,
    value: String? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        if (value != null) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}