package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CrossfadeExample() {
    var showContent by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Crossfade between loading and content
        Crossfade(
            targetState = showContent,
            animationSpec = tween(durationMillis = 500)
        ) { isContentLoaded ->
            if (isContentLoaded) {
                // Content state
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Content Loaded!",
                        fontSize = 24.sp,
                        color = Color.Green
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("This is your main content")
                }
            } else {
                // Loading state
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(color = Color.Blue)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Loading...")
                }
            }
        }

        Spacer(modifier = Modifier.height(160.dp))

        Button(onClick = { showContent = !showContent }) {
            Text("Toggle Content")
        }
    }
}

@Composable
fun AutoStartExample() {
    // Auto-start animation using rememberInfiniteTransition
    val infiniteTransition = rememberInfiniteTransition(label = "infinite transition")

    // This animation starts automatically when the composable is composed
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .background(Color.Blue)
        ) {
            Text(
                text = "Auto Start!",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Composable
fun SidebarCrossfadeExample() {
    var sidebarOpen by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Main content area
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        ) {
            Text(
                text = "Main Content\nClick button to open sidebar",
                modifier = Modifier.align(Alignment.Center),
                textAlign = TextAlign.Center
            )

            // Toggle button
            IconButton(
                onClick = { sidebarOpen = !sidebarOpen },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)
            ) {
                Icon(
                    painter = rememberVectorPainter(Icons.Default.Menu),
                    contentDescription = "Toggle Sidebar"
                )
            }
        }

        // Sidebar using Crossfade
        Crossfade(
            targetState = sidebarOpen,
            animationSpec = tween(durationMillis = 300),
            modifier = Modifier.fillMaxSize()
        ) { open ->
            if (open) {
                // Sidebar content
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(250.dp)
                        .background(Color.White)
                        .padding(16.dp)
                        .align(Alignment.CenterStart)
                ) {
                    Column {
                        Text(
                            text = "Sidebar Menu",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        repeat(5) { index ->
                            Text(
                                text = "Menu Item ${index + 1}",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp)
                                    .clickable {
                                        // Handle menu item click
                                    }
                            )
                        }
                    }

                    // Close button
                    IconButton(
                        onClick = { sidebarOpen = false },
                        modifier = Modifier.align(Alignment.TopEnd)
                    ) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Default.Close),
                            contentDescription = "Close Sidebar"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun FloatAsStateExample() {
    var enabled by remember { mutableStateOf(false) }

    // Animate float value based on state
    val animatedValue by animateFloatAsState(
        targetValue = if (enabled) 1.5f else 1f,
        animationSpec = tween(durationMillis = 500),
        label = "scaleAnimation"
    )

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .graphicsLayer {
                    scaleX = animatedValue
                    scaleY = animatedValue
                }
                .background(Color.Blue)
        ) {
            Text(
                text = "Scale",
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(150.dp))

        Button(onClick = { enabled = !enabled }) {
            Text("Toggle Scale")
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewTransitionsDemo() {
    //CrossfadeExample()
    //AutoStartExample()
    //SidebarCrossfadeExample()
    //FloatAsStateExample()
}