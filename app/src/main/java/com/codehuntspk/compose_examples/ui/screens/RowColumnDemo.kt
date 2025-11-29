package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RowColumnDemo() {
    // Column: Main Axis = Vertical, Cross Axis = Horizontal
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        // Arrange items vertically with space between them
        verticalArrangement = Arrangement.SpaceEvenly,
        // Align items to the center horizontally (Cross Axis)
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Item 1: Top")

        // A Row nested inside the Column
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
            // Arrange items horizontally (Main Axis)
            horizontalArrangement = Arrangement.SpaceBetween,
            // Align items vertically (Cross Axis)
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Left")
            Text("Center")
            Text("Right")
        }

        Text("Item 3: Bottom")
    }
}

@Composable
@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 500
)
fun RowColumnDemoPreview() {
    RowColumnDemo()
}