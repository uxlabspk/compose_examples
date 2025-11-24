package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowLayoutDemo() {
    val tags = listOf("Kotlin", "Jetpack", "Compose", "UI", "Layouts", "Android", "Mobile")

    // FlowRow automatically moves items to the next line if width is exceeded
    FlowRow(
        modifier = Modifier.padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        maxItemsInEachRow = 2 // Optional: Force wrap after 3 items
    ) {
        tags.forEach { tag ->
            Text(
                text = tag,
                modifier = Modifier
                    .background(Color.Cyan, RoundedCornerShape(4.dp))
                    .padding(8.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 700
)
@Composable
fun FlowLayoutDemoPreview() {
    FlowLayoutDemo()
}
