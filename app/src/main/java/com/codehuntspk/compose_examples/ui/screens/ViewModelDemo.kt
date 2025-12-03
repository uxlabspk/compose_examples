package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codehuntspk.compose_examples.viewmodel.MyViewModel

@Composable
fun ViewModelDemo(
    modifier: Modifier = Modifier,
    viewModel: MyViewModel = viewModel()
) {
    val count by viewModel.count.collectAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Count: $count")
        Button(onClick = { viewModel.increment() }) {
            Text(text = "Increment")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewModelDemoPreview() {
    ViewModelDemo()
}