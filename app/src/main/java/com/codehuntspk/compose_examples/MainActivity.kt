package com.codehuntspk.compose_examples

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.codehuntspk.compose_examples.ui.screens.ProfileScreen
import com.codehuntspk.compose_examples.ui.theme.Compose_examplesTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_examplesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier.padding(80.dp)
                    ) {
                        ProfileScreen()
                    }
                }
            }
        }
    }
}