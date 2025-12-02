package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleDrawing() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        // Draw a diagonal line
        drawLine(
            start = Offset(x = 0f, y = 0f),
            end = Offset(x = size.width, y = size.height),
            color = Color.Red,
            strokeWidth = 5f
        )

        // Draw a blue rectangle in the center
        drawRect(
            color = Color.Blue,
            topLeft = Offset(x = size.width / 4, y = size.height / 4),
            size = size / 2f
        )

        // Draw a green circle at the center of the canvas
        drawCircle(
            color = Color.Green,
            radius = size.minDimension / 4,
            center = center
        )
    }
}

@Composable
fun PathAndCurvesExample() {
    var animate by remember { mutableStateOf(false) }

    val path = Path().apply {
        moveTo(0f, 100f)
        cubicTo(50f, 0f, 150f, 200f, 200f, 100f) // Bezier curve
    }

    val animatedOffset by animateFloatAsState(
        targetValue = if (animate) 200f else 0f,
        animationSpec = tween(durationMillis = 2000, easing = LinearEasing),
        label = "pathOffset"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Draw the path
        Canvas(modifier = Modifier.size(250.dp)) {
            drawPath(
                path = path,
                color = Color.Gray,
                style = Stroke(width = 4f)
            )

            // Animate a circle along the path
            drawCircle(
                color = Color.Red,
                radius = 12f,
                center = Offset(animatedOffset, 100f + (animatedOffset * 0.5f).toFloat())
            )
        }

        Spacer(modifier = Modifier.height(200.dp))

        Button(onClick = { animate = !animate }) {
            Text("Animate Path")
        }
    }
}

@Composable
fun GradientsExample() {
    var gradientType by remember { mutableStateOf(0) }

    val animatedColor by animateFloatAsState(
        targetValue = if (gradientType % 3 == 0) 1f else 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "gradientAnimation"
    )

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(
                    when (gradientType % 3) {
                        0 -> Brush.linearGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Blue,
                                Color.Green
                            )
                        )
                        1 -> Brush.radialGradient(
                            colors = listOf(
                                Color.Yellow,
                                Color.Magenta,
                                Color.Cyan
                            )
                        )
                        else -> Brush.sweepGradient(
                            colors = listOf(
                                Color.Red,
                                Color.Magenta,
                                Color.Blue,
                                Color.Cyan,
                                Color.Green
                            )
                        )
                    }
                )
        ) {
            Text(
                text = "Gradient",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(220.dp))

        Button(onClick = { gradientType++ }) {
            Text("Change Gradient")
        }
    }
}

@Composable
fun TextAnimationExample() {
    var animatedText by remember { mutableStateOf("Hello") }

    val animatedScale by animateFloatAsState(
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "textScale"
    )

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = animatedText,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .graphicsLayer {
                    scaleX = animatedScale
                    scaleY = animatedScale
                }
                .clickable {
                    animatedText = when (animatedText) {
                        "Hello" -> "World"
                        "World" -> "Jetpack"
                        else -> "Hello"
                    }
                }
        )
    }
}


@Composable
fun ImageAnimationExample() {
    var animatedRotation by remember { mutableStateOf(0f) }

    val animatedRotationValue by animateFloatAsState(
        targetValue = animatedRotation,
        animationSpec = tween(durationMillis = 500),
        label = "imageRotation"
    )

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Using a simple colored box instead of image for simplicity
        Box(
            modifier = Modifier
                .size(150.dp)
                .graphicsLayer {
                    rotationZ = animatedRotationValue
                    scaleX = 1f + (animatedRotationValue / 360f) * 0.5f
                    scaleY = 1f + (animatedRotationValue / 360f) * 0.5f
                }
                .background(Color.Magenta)
        ) {
            Text(
                text = "Image",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(200.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(onClick = { animatedRotation += 90f }) {
                Text("Rotate +90°")
            }
            Button(onClick = { animatedRotation = 0f }) {
                Text("Reset")
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewCanvasDemo() {
    //SimpleDrawing()
    //PathAndCurvesExample()
    //GradientsExample()
    //TextAnimationExample()
    ImageAnimationExample()
}