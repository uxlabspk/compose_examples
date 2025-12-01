package com.codehuntspk.compose_examples.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Button
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.Dimension
import androidx.compose.ui.unit.Dp
import androidx.constraintlayout.compose.*

import com.codehuntspk.compose_examples.R

@Composable
fun ConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.background(Color.LightGray)
    ) {
        // Create references for the composables
        val (title, box1, box2) = createRefs()

        Text(
            text = "Hello ConstraintLayout",
            modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        )

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(title.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    top.linkTo(box1.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )
    }
}



@Composable
fun GuidelinesExample() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (title, subtitle, image) = createRefs()

        // Create a vertical guideline at 40% from start
        val guideline = createGuidelineFromStart(0.4f)

        Text(
            text = "Title",
            modifier = Modifier.constrainAs(title) {
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(guideline, margin = 16.dp)
                top.linkTo(parent.top, margin = 16.dp)
                width = Dimension.fillToConstraints
            }
        )

        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .constrainAs(image) {
                    start.linkTo(guideline, margin = 16.dp)
                    top.linkTo(parent.top, margin = 16.dp)
                }
        )
    }
}


@Composable
fun BarrierExample() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
        val (name, email, phone, details) = createRefs()

        // Create barrier after the longest text field
        val barrier = createEndBarrier(name, email, phone)

        Text("Name:", modifier = Modifier.constrainAs(name) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        })

        Text("Email Address:", modifier = Modifier.constrainAs(email) {
            start.linkTo(parent.start)
            top.linkTo(name.bottom, margin = 8.dp)
        })

        Text("Phone:", modifier = Modifier.constrainAs(phone) {
            start.linkTo(parent.start)
            top.linkTo(email.bottom, margin = 8.dp)
        })

        // This will always be to the right of the longest label
        Text(
            "John Doe\njohn@email.com\n+1234567890",
            modifier = Modifier.constrainAs(details) {
                start.linkTo(barrier, margin = 16.dp)
                top.linkTo(parent.top)
            }
        )
    }
}


@Composable
fun ChainExample() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        val (button1, button2, button3) = createRefs()

        // Create horizontal chain
        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.Spread)

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button1) {
                centerVerticallyTo(parent)
            }
        ) { Text("One") }

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button2) {
                centerVerticallyTo(parent)
            }
        ) { Text("Two") }

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button3) {
                centerVerticallyTo(parent)
            }
        ) { Text("Three") }
    }
}


@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 700
)
@Composable
fun PreivewConstraintLayout() {
    // ConstraintLayout()

    //GuidelinesExample()

    // BarrierExample()

    ChainExample()
}

