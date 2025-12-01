package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IntrinsicSizeDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Simple Column with buttons
        Column(
            modifier = Modifier
                .border(1.dp, Color.Black, RectangleShape)
        ) {
            Button(onClick = { }) { Text("Short") }
            Button(onClick = { }) { Text("Very Long Text") }
        }

        Spacer(modifier = Modifier.height(32.dp))
        

        // Without IntrinsicSize - buttons have different widths
        Column(
            modifier = Modifier
                .border(1.dp, Color.Black, RectangleShape)
        ) {
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Short") }
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Very Long Text") }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // With IntrinsicSize - both match the widest
        Column(
            modifier = Modifier
                .width(IntrinsicSize.Max)
                .border(1.dp, Color.Black, RectangleShape)
        ) {
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Short") }

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Very Long Text") }
        }
    }
}



@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 700
)
@Composable
fun PreivewIntrinsiveMeasureDemo() {
    IntrinsicSizeDemo()
}