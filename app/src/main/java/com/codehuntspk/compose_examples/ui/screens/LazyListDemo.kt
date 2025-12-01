package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

// Main Demo Screen
@Composable
fun SimpleLazyListsDemo() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Text("Lazy Lists Examples", style = MaterialTheme.typography.headlineMedium) }
        item { Example1_BasicLazyColumn() }
        item { Example2_BasicLazyRow() }
        item { Example3_ScrollControl() }
        item { Example4_LazyVerticalGrid_Fixed() }
        item { Example5_LazyVerticalGrid_Adaptive() }
    }
}

// Example 1: Basic LazyColumn - Vertical Scrolling List
@Composable
fun Example1_BasicLazyColumn() {
    val items = remember { (1..50).map { "Item $it" } }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("1. LazyColumn - Vertical List", style = MaterialTheme.typography.titleMedium)
            Text("Only renders visible items", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            // LazyColumn with 50 items
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE3F2FD))
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }

            Text(
                "Total: ${items.size} items (scroll to see all)",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

// Example 4: LazyVerticalGrid - Fixed Columns
@Composable
fun Example4_LazyVerticalGrid_Fixed() {
    val items = remember { (1..50).map { "Item $it" } }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("4. LazyVerticalGrid - Fixed Columns", style = MaterialTheme.typography.titleMedium)
            Text("GridCells.Fixed(3) - Always 3 columns", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            // Grid with exactly 3 columns
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f), // Makes it square
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFE1BEE7))
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(item)
                        }
                    }
                }
            }

            Text(
                "Total: ${items.size} items in 3 columns",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

// Example 5: LazyVerticalGrid - Adaptive Columns
@Composable
fun Example5_LazyVerticalGrid_Adaptive() {
    val items = remember { (1..50).map { it } }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("5. LazyVerticalGrid - Adaptive Columns", style = MaterialTheme.typography.titleMedium)
            Text("GridCells.Adaptive(100.dp) - Auto-fits columns", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            // Grid that auto-fits as many columns as possible (min 100.dp each)
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 100.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items) { number ->
                    val color = when (number % 5) {
                        0 -> Color(0xFFFFCDD2)
                        1 -> Color(0xFFF8BBD0)
                        2 -> Color(0xFFE1BEE7)
                        3 -> Color(0xFFD1C4E9)
                        else -> Color(0xFFC5CAE9)
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        colors = CardDefaults.cardColors(containerColor = color)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "$number",
                                style = MaterialTheme.typography.headlineMedium
                            )
                        }
                    }
                }
            }

            Text(
                "Resize screen to see columns adapt!",
                style = MaterialTheme.typography.bodySmall,
                color = Color(0xFF7B1FA2),
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

// Example 2: Basic LazyRow - Horizontal Scrolling List
@Composable
fun Example2_BasicLazyRow() {
    val items = remember { (1..20).map { "Card $it" } }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("2. LazyRow - Horizontal List", style = MaterialTheme.typography.titleMedium)
            Text("Perfect for categories or image galleries", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            // LazyRow with 20 items
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items) { item ->
                    Card(
                        modifier = Modifier
                            .width(120.dp)
                            .height(150.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF3E0))
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(item)
                        }
                    }
                }
            }

            Text(
                "Swipe left to see more →",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

// Example 3: Scroll Control - Programmatic Scrolling
@Composable
fun Example3_ScrollControl() {
    val items = remember { (1..100).map { "Item $it" } }
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("3. Scroll Control", style = MaterialTheme.typography.titleMedium)
            Text("Control scrolling with buttons", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            // Control Buttons
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = {
                        scope.launch {
                            listState.animateScrollToItem(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Top")
                }

                Button(
                    onClick = {
                        scope.launch {
                            listState.animateScrollToItem(items.size / 2)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Middle")
                }

                Button(
                    onClick = {
                        scope.launch {
                            listState.animateScrollToItem(items.size - 1)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Bottom")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Current position
            Text(
                "Current position: Item ${listState.firstVisibleItemIndex + 1}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            // LazyColumn with scroll control
            LazyColumn(
                state = listState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(items) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = if (item == "Item 50") Color(0xFFFFEB3B) else Color(0xFFE8F5E9)
                        )
                    ) {
                        Text(
                            text = item,
                            modifier = Modifier.padding(12.dp)
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewSimpleLazyListsDemo() {
    SimpleLazyListsDemo()
}