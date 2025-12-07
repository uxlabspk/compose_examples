package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codehuntspk.compose_examples.viewmodel.TemperatureConverterViewModel

@Composable
fun TemperatureConverterDemo(
    viewModel: TemperatureConverterViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Celsius (°C)")
        TextField(
            value = uiState.celsius,
            onValueChange = { viewModel.onCelsiusChange(it) }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Text("Fahrenheit (°F)")
        TextField(
            value = uiState.fahrenheit,
            onValueChange = { viewModel.onFahrenheitChange(it) }
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 58.dp)
                .height(56.dp),
            shape = RoundedCornerShape(6.dp),
            onClick = { viewModel.clearAll() }
        ) {
            Text("Clear")
        }
    }
}

@Preview
@Composable
fun PreviewTemperatureConverterDemo() {
    TemperatureConverterDemo()
}