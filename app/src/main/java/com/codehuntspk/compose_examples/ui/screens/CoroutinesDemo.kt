package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.*


// Example 1: Basic Button Click with Coroutine
@Composable
fun Example1_BasicCoroutine() {
    var status by remember { mutableStateOf("Ready") }
    val scope = rememberCoroutineScope()

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("1. Basic Coroutine", style = MaterialTheme.typography.titleMedium)
            Text("Status: $status")

            Button(onClick = {
                scope.launch {
                    status = "Loading..."
                    delay(2000) // Simulates network call
                    status = "Done!"
                }
            }) {
                Text("Start Task")
            }
        }
    }
}

// Example 2: LaunchedEffect - Auto runs when screen opens
@Composable
fun Example2_LaunchedEffect() {
    var data by remember { mutableStateOf("Loading...") }

    // Runs automatically when composable appears
    LaunchedEffect(Unit) {
        delay(1500)
        data = "Data loaded!"
    }

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("2. LaunchedEffect", style = MaterialTheme.typography.titleMedium)
            Text("Auto-loads data: $data")
        }
    }
}

// Example 3: Dispatchers - Different thread types
@Composable
fun Example3_Dispatchers() {
    var result by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("3. Dispatchers", style = MaterialTheme.typography.titleMedium)
            Text(result)

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = {
                    scope.launch(Dispatchers.IO) {
                        result = "IO: For network/files"
                    }
                }) {
                    Text("IO")
                }

                Button(onClick = {
                    scope.launch(Dispatchers.Default) {
                        result = "Default: For calculations"
                    }
                }) {
                    Text("Default")
                }
            }
        }
    }
}


@Composable
fun Example4_SideEffect() {
    var count by remember { mutableStateOf(0) }

    // This state will be updated by the SideEffect, making it visible in the UI.
    var sideEffectLog by remember { mutableStateOf("SideEffect has not run yet.") }

    SideEffect {
        // This block runs after every recomposition.
        // We update our log state, which will trigger another recomposition
        // to display the new message.
        sideEffectLog = "✅ SideEffect executed! Count is now $count"
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {


        Button(onClick = { count++ }) {
            Text("Increment Count")
        }

        // This Text displays the result of our SideEffect.
        Card(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = sideEffectLog,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PreviewSimpleCoroutinesDemo() {
    // Example1_BasicCoroutine()
    //Example2_LaunchedEffect()
    //Example3_Dispatchers()
    Example4_SideEffect()
}