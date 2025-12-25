package com.codehuntspk.compose_examples.widget

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

/**
 * Demo screen to explain the Glance widget to students
 */
@Composable
fun GlanceWidgetDemoScreen() {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "✨ Glance Widget Demo ✨",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(24.dp))

        // What is Glance?
        InfoCard(
            title = "📚 What is Glance?",
            content = "Glance is Jetpack's modern toolkit for building app widgets. It uses a Compose-like API, making it easier to create beautiful widgets with less code than traditional XML-based widgets."
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Widget Components
        InfoCard(
            title = "🧩 Key Components",
            content = """
                1. GlanceAppWidget - Main widget class
                2. GlanceAppWidgetReceiver - Widget receiver
                3. provideContent {} - Define widget UI
                4. ActionCallback - Handle user actions
                5. Widget Info XML - Widget configuration
            """.trimIndent()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // How it works
        InfoCard(
            title = "⚙️ How It Works",
            content = """
                • Create a GlanceAppWidget subclass
                • Override provideGlance() method
                • Use Composable-like UI components
                • Handle actions with ActionCallback
                • Register in AndroidManifest.xml
                • Add widget configuration XML
            """.trimIndent()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Features of this widget
        InfoCard(
            title = "✅ This Widget Demonstrates",
            content = """
                • Basic Glance widget structure
                • Text, Column, Row layouts
                • Background colors & styling
                • Click actions (refresh button)
                • Random content generation
                • Widget theming with GlanceTheme
            """.trimIndent()
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Add widget button
        Button(
            onClick = { requestPinWidget(context) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "📌 Add Widget to Home Screen",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Tip: Long-press on home screen → Widgets → Find 'Motivational Quote Widget'",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun InfoCard(title: String, content: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = content,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

/**
 * Request to pin widget to home screen (Android 8.0+)
 */
private fun requestPinWidget(context: Context) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val appWidgetManager = AppWidgetManager.getInstance(context)
        val myProvider = ComponentName(context, MotivationalQuoteWidgetReceiver::class.java)

        if (appWidgetManager.isRequestPinAppWidgetSupported) {
            appWidgetManager.requestPinAppWidget(myProvider, null, null)
        }
    }
}

