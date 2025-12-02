package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SimpleVisibilityExample() {
    var visible by remember { mutableStateOf(true) }

    Column {
        Button(onClick = { visible = !visible }) {
            Text(if (visible) "Hide" else "Show")
        }

        AnimatedVisibility(visible = visible) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Blue)
            )
        }
    }
}

@Composable
fun FadeAnimationExample() {
    var visible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { visible = !visible }) {
            Text("Toggle")
        }

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(Color.Green)
            )
        }
    }
}

@Composable
fun SlideAnimationExample() {
    var visible by remember { mutableStateOf(true) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            visible = visible,
            enter = slideInHorizontally(initialOffsetX = { -100 }),
            exit = slideOutHorizontally(targetOffsetX = { 100 })
        ) {
            Text(
                text = "Sliding Text",
                fontSize = 24.sp,
                modifier = Modifier.background(Color.Green)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { visible = !visible }) {
            Text("Toggle Slide")
        }
    }
}

@Composable
fun ExpandShrinkExample() {
    var expanded by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically(),
            exit = shrinkVertically()
        ) {
            Text(
                text = "Expandable Text",
                fontSize = 24.sp,
                modifier = Modifier.background(Color.Red)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { expanded = !expanded }) {
            Text("Toggle Expand")
        }
    }
}

@Composable
fun TweenDurationsExample() {
    var animate by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Fast animation (200ms)
        AnimatedVisibility(
            visible = animate,
            enter = slideInVertically(
                initialOffsetY = { -100 },
                animationSpec = tween(durationMillis = 200)
            ),
            exit = slideOutVertically(
                targetOffsetY = { -100 },
                animationSpec = tween(durationMillis = 200)
            )
        ) {
            Text("Fast Tween (200ms)", color = Color.White,
                modifier = Modifier.background(Color.Cyan))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Slow animation (1000ms)
        AnimatedVisibility(
            visible = animate,
            enter = slideInVertically(
                initialOffsetY = { 100 },
                animationSpec = tween(durationMillis = 1000)
            ),
            exit = slideOutVertically(
                targetOffsetY = { 100 },
                animationSpec = tween(durationMillis = 1000)
            )
        ) {
            Text("Slow Tween (1000ms)", color = Color.White,
                modifier = Modifier.background(Color.Magenta))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { animate = !animate }) {
            Text("Toggle Tween Animations")
        }
    }
}


@Composable
fun SpringAnimationsExample() {
    var targetValue by remember { mutableStateOf(0f) }
    val animatedValue by animateFloatAsState(
        targetValue = targetValue,
        animationSpec = spring(dampingRatio = 0.4f, stiffness = 100f), label = "spring animation"
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .size(80.dp)
                .offset(x = animatedValue.dp)
                .background(Color.Magenta)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { targetValue = if (targetValue == 0f) 150f else 0f }) {
            Text("Animate with Spring")
        }
    }
}

@Composable
fun AnimateEnterExitBasicExample() {
    var visible by remember { mutableStateOf(true) }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                Modifier
                    .fillMaxSize(1/2f)
                    .background(Color.DarkGray)
            ) {
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .animateEnterExit(
                            // Slide in/out the inner box.
                            enter = slideInVertically(),
                            exit = slideOutVertically()
                        )
                        .sizeIn(minWidth = 256.dp, minHeight = 64.dp)
                        .background(Color.Red)
                ) {
                    // Content of the notification…
                }
            }

            Button(
                onClick = { visible = !visible }
            ) {
                Text("Click me")
            }
        }

    }
}

@Preview(
    showBackground = true,
    widthDp = 200,
    heightDp = 200
)
@Composable
fun SimpleVisibilityExamplePreview() {
    //SimpleVisibilityExample()
    //FadeAnimationExample()
    //SlideAnimationExample()
    //ExpandShrinkExample()
    //TweenDurationsExample()
    //SpringAnimationsExample()
    AnimateEnterExitBasicExample()
}