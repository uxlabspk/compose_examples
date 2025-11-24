package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CascadeLayout(
    spacing: Int = 0,
    content: @Composable () -> Unit
) {
    Layout(content = content) { measurables, constraints ->
        // 1. Measure all children
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        // 2. Calculate total layout size
        // Width = width of first item + spacing offset for subsequent items
        // Height = sum of all heights (simplified for this demo)
        var layoutWidth = 0
        var layoutHeight = 0

        placeables.forEachIndexed { index, placeable ->
            layoutWidth = maxOf(layoutWidth, placeable.width + (index * spacing))
            layoutHeight += placeable.height
        }

        // 3. Layout the children
        layout(layoutWidth, layoutHeight) {
            var yPosition = 0
            var xPosition = 0

            placeables.forEach { placeable ->
                placeable.placeRelative(x = xPosition, y = yPosition)

                // Increase X and Y for the next item to create the staircase step
                xPosition += spacing
                yPosition += placeable.height
            }
        }
    }
}

// Usage
@Composable
fun CascadeDemo() {
    CascadeLayout(spacing = 150) {
        Box(Modifier.size(50.dp).background(Color.Red))
        Box(Modifier.size(50.dp).background(Color.Green))
        Box(Modifier.size(50.dp).background(Color.Blue))
    }
}

@Preview(
    showBackground = true
)
@Composable
fun CascadeDemoPreview() {
    CascadeDemo()
}