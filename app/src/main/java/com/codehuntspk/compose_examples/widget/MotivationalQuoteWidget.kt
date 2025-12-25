package com.codehuntspk.compose_examples.widget

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.action.ActionParameters
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.provideContent
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.background
import androidx.glance.currentState
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.fillMaxWidth
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextAlign
import androidx.glance.text.TextStyle
import kotlin.random.Random

// State key for storing current quote index
private val QUOTE_INDEX_KEY = intPreferencesKey("quote_index")

/**
 * Motivational Quote Widget - A simple Glance widget for teaching purposes
 * Demonstrates:
 * - Basic Glance widget structure
 * - UI components (Text, Column, Row)
 * - Action handling (refresh button)
 * - State management for instant updates
 */
class MotivationalQuoteWidget : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                WidgetContent()
            }
        }
    }

    @Composable
    private fun WidgetContent() {
        // Get quote index from state (defaults to random if not set)
        val prefs = currentState<androidx.datastore.preferences.core.Preferences>()
        val quoteIndex = prefs[QUOTE_INDEX_KEY] ?: Random.nextInt(quotes.size)
        val quote = quotes[quoteIndex]

        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(Color(0xFF444444))
                .cornerRadius(16.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Widget Title
            Text(
                text = "✨ Daily Motivation ✨",
                style = TextStyle(
                    color = GlanceTheme.colors.primary,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = GlanceModifier.height(16.dp))

            // Quote Text
            Text(
                text = "\"${quote.text}\"",
                style = TextStyle(
                    color = GlanceTheme.colors.primary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                ),
                modifier = GlanceModifier.fillMaxWidth()
            )

            Spacer(modifier = GlanceModifier.height(8.dp))

            // Quote Author
            Text(
                text = "- ${quote.author}",
                style = TextStyle(
                    color = GlanceTheme.colors.primary,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.End
                ),
                modifier = GlanceModifier.fillMaxWidth()
            )

            Spacer(modifier = GlanceModifier.height(16.dp))

            // Refresh Button
            Row(
                modifier = GlanceModifier
                    .fillMaxWidth()
                    .background(Color(0xFFE2E2E2))
                    .cornerRadius(8.dp)
                    .padding(12.dp)
                    .clickable(actionRunCallback<RefreshQuoteAction>()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🔄",
                    style = TextStyle(fontSize = 16.sp)
                )
                Spacer(modifier = GlanceModifier.width(8.dp))
                Text(
                    text = "New Quote",
                    style = TextStyle(
                        color = GlanceTheme.colors.primary,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}

/**
 * Data class to hold quote information
 */
data class Quote(
    val text: String,
    val author: String
)

/**
 * List of motivational quotes
 */
private val quotes = listOf(
    Quote("The only way to do great work is to love what you do.", "Steve Jobs"),
    Quote("Believe you can and you're halfway there.", "Theodore Roosevelt"),
    Quote("Success is not final, failure is not fatal.", "Winston Churchill"),
    Quote("It always seems impossible until it's done.", "Nelson Mandela"),
    Quote("Don't watch the clock; do what it does. Keep going.", "Sam Levenson"),
    Quote("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"),
    Quote("Quality is not an act, it is a habit.", "Aristotle"),
    Quote("The best time to plant a tree was 20 years ago. The second best time is now.", "Chinese Proverb"),
    Quote("Code is like humor. When you have to explain it, it's bad.", "Cory House"),
    Quote("First, solve the problem. Then, write the code.", "John Johnson")
)

/**
 * Action callback to refresh the quote - OPTIMIZED FOR INSTANT UPDATES
 */
class RefreshQuoteAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        // Update widget state with new random quote index
        updateAppWidgetState(context, glanceId) { prefs ->
            val currentIndex = prefs[QUOTE_INDEX_KEY] ?: 0
            var newIndex = Random.nextInt(quotes.size)

            // Ensure we get a different quote
            while (newIndex == currentIndex && quotes.size > 1) {
                newIndex = Random.nextInt(quotes.size)
            }

            prefs[QUOTE_INDEX_KEY] = newIndex
        }

        // Immediately update the widget UI
        MotivationalQuoteWidget().update(context, glanceId)
    }
}

/**
 * Widget Receiver - Required to register the widget with Android system
 */
class MotivationalQuoteWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget = MotivationalQuoteWidget()
}