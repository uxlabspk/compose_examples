package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp)
    ) {
        // First item: The base layer (e.g., Profile Picture)
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(24.dp)
                .background(Color.Blue, shape = CircleShape)
                .border(2.dp, Color.Green)
        )

        // Second item: Stacked on top (e.g., Notification Badge)
        // We override the default alignment specifically for this item
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd) // Pin to top-right corner
                .size(24.dp)
                .background(Color.Red, shape = CircleShape)
                .border(2.dp, Color.Green, CircleShape)
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(30.dp)
                .background(Color.Green, shape = CutCornerShape(6.dp))

        )
    }
}


@Preview (
    showBackground = true,
    widthDp = 300,
    heightDp = 700
)
@Composable
fun BoxDemoPreview() {
    BoxDemo()
}


