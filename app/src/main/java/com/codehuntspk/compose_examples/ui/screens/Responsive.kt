package com.codehuntspk.compose_examples.ui.screens

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Main responsive layout entry point
@SuppressLint("ContextCastToActivity")
@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun ResponsiveLayout() {
    val activity = LocalContext.current as? Activity
    val windowSizeClass = activity?.let { calculateWindowSizeClass(it) }

    windowSizeClass?.let {
        when (it.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                // Phone in portrait mode
                CompactLayout()
            }
            WindowWidthSizeClass.Medium -> {
                // Phone in landscape or tablet in portrait
                MediumLayout()
            }
            WindowWidthSizeClass.Expanded -> {
                // Tablet in landscape or desktop
                ExpandedLayout()
            }
        }
    }
}

// Compact layout for small screens (phones in portrait)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompactLayout() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Profile", "Cart", "Settings")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Person,
        Icons.Default.ShoppingCart,
        Icons.Default.Settings
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Compact Layout") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(getSampleItems()) { item ->
                CompactCard(item)
            }
        }
    }
}

// Medium layout for medium screens (tablets, landscape phones)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MediumLayout() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Profile", "Cart", "Settings")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Person,
        Icons.Default.ShoppingCart,
        Icons.Default.Settings
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Medium Layout") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { paddingValues ->
        Row(modifier = Modifier.padding(paddingValues)) {
            // Side navigation rail
            NavigationRail(
                modifier = Modifier.fillMaxHeight()
            ) {
                Spacer(Modifier.height(16.dp))
                items.forEachIndexed { index, item ->
                    NavigationRailItem(
                        icon = { Icon(icons[index], contentDescription = item) },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }

            // Content area with 2-column grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(getSampleItems()) { item ->
                    MediumCard(item)
                }
            }
        }
    }
}

// Expanded layout for large screens (tablets in landscape, desktops)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandedLayout() {
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Profile", "Cart", "Settings")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Person,
        Icons.Default.ShoppingCart,
        Icons.Default.Settings
    )

    Row(modifier = Modifier.fillMaxSize()) {
        // Permanent navigation drawer
        PermanentNavigationDrawer(
            drawerContent = {
                PermanentDrawerSheet(
                    modifier = Modifier.width(240.dp)
                ) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "Expanded Layout",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                    HorizontalDivider()
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            icon = { Icon(icons[index], contentDescription = item) },
                            label = { Text(item) },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
                        )
                    }
                }
            }
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                // Top app bar
                TopAppBar(
                    title = { Text("Dashboard") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer
                    )
                )

                // Content area with 3-column grid
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(getSampleItems()) { item ->
                        ExpandedCard(item)
                    }
                }
            }
        }
    }
}

// Card for compact layout
@Composable
fun CompactCard(item: SampleItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    item.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

// Card for medium layout
@Composable
fun MediumCard(item: SampleItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    item.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondaryContainer,
                    modifier = Modifier.size(40.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

// Card for expanded layout
@Composable
fun ExpandedCard(item: SampleItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .background(
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    item.icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onTertiaryContainer,
                    modifier = Modifier.size(48.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}

// Data class for sample items
data class SampleItem(
    val id: Int,
    val title: String,
    val description: String,
    val icon: ImageVector
)

// Generate sample data
fun getSampleItems(): List<SampleItem> {
    return listOf(
        SampleItem(1, "Dashboard", "View your overview", Icons.Default.Home),
        SampleItem(2, "Profile", "Manage your account", Icons.Default.Person),
        SampleItem(3, "Shopping", "Browse products", Icons.Default.ShoppingCart),
        SampleItem(4, "Settings", "App preferences", Icons.Default.Settings),
        SampleItem(5, "Analytics", "View statistics", Icons.Default.Menu),
        SampleItem(6, "Messages", "Check messages", Icons.Default.Home),
        SampleItem(7, "Calendar", "Your schedule", Icons.Default.Person),
        SampleItem(8, "Tasks", "To-do list", Icons.Default.ShoppingCart),
        SampleItem(9, "Reports", "Generate reports", Icons.Default.Settings),
        SampleItem(10, "Help", "Get support", Icons.Default.Menu)
    )
}

// Preview functions
@Preview(name = "Compact Layout - Phone Portrait", showBackground = true, device = "spec:width=360dp,height=640dp,dpi=480")
@Composable
fun PreviewCompactLayout() {
    MaterialTheme {
        CompactLayout()
    }
}

@Preview(name = "Medium Layout - Phone Landscape", showBackground = true, device = "spec:width=640dp,height=360dp,dpi=480")
@Composable
fun PreviewMediumLayout() {
    MaterialTheme {
        MediumLayout()
    }
}

@Preview(name = "Expanded Layout - Tablet", showBackground = true, device = "spec:width=1280dp,height=800dp,dpi=480")
@Composable
fun PreviewExpandedLayout() {
    MaterialTheme {
        ExpandedLayout()
    }
}

@Preview(name = "Compact Card", showBackground = true, widthDp = 360)
@Composable
fun PreviewCompactCard() {
    MaterialTheme {
        CompactCard(
            SampleItem(
                1,
                "Dashboard",
                "View your overview",
                Icons.Default.Home
            )
        )
    }
}

@Preview(name = "Medium Card", showBackground = true, widthDp = 200)
@Composable
fun PreviewMediumCard() {
    MaterialTheme {
        MediumCard(
            SampleItem(
                2,
                "Profile",
                "Manage your account",
                Icons.Default.Person
            )
        )
    }
}

@Preview(name = "Expanded Card", showBackground = true, widthDp = 250)
@Composable
fun PreviewExpandedCard() {
    MaterialTheme {
        ExpandedCard(
            SampleItem(
                3,
                "Shopping",
                "Browse products",
                Icons.Default.ShoppingCart
            )
        )
    }
}

