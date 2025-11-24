package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview

fun Modifier.customOffset(xOffset: Int, yOffset: Int) = layout { measurable, constraints ->
    // 1. Measure the child
    val placeable = measurable.measure(constraints)

    // 2. Define the size of this layout (usually the size of the child)
    layout(placeable.width, placeable.height) {
        // 3. Place the child at new custom coordinates
        placeable.placeRelative(x = xOffset, y = yOffset)
    }
}

// Usage
@Composable
fun CustomLayoutDemo() {
    Text(
        text = "I am moved!",
        modifier = Modifier
            .background(Color.Yellow)
            .customOffset(xOffset = 500, yOffset = 200) // Shifts the text
    )
}

@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 700
)
@Composable
fun CustomLayoutDemoPreview() {
    CustomLayoutDemo()
}