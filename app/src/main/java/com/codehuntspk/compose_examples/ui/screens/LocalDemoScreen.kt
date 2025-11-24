package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


val LocalColor = compositionLocalOf { Color.Cyan }

@Composable
fun LocalDemoScreen() {
    Demo()
}

@Composable
fun Demo() {
    val themeColor = if (isSystemInDarkTheme()) Color.Blue else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(80.dp)
    ) {
        ComponentOutside()
        Spacer(modifier = Modifier.height(16.dp))
        CompositionLocalProvider(LocalColor provides themeColor) {
            ComponentInside()
        }
    }
}

@Composable
fun ComponentOutside() {
    val color = LocalColor.current
    Text(text = "Color with cyan", color = color)
}

@Composable
fun ComponentInside() {
    val color = LocalColor.current
    Text(text = "Color with theme color", color = color)
}

@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 700
)
@Composable
fun PreviewDemoScreen() {
    Demo()
}