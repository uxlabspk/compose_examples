package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


// Example 1: Basic Horizontal Pager
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Example1_BasicHorizontalPager() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("1. Basic Horizontal Pager", style = MaterialTheme.typography.titleMedium)
            Text("Swipe left or right to navigate", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            val pagerState = rememberPagerState(pageCount = { 5 })

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) { page ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = when (page) {
                            0 -> Color(0xFFE3F2FD)
                            1 -> Color(0xFFFCE4EC)
                            2 -> Color(0xFFF3E5F5)
                            3 -> Color(0xFFE8F5E9)
                            else -> Color(0xFFFFF3E0)
                        }
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "Page ${page + 1}",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Swipe to navigate",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}

// Example 2: Horizontal Pager with Page Indicator
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Example2_HorizontalPagerWithIndicator() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("2. Pager with Indicator Dots", style = MaterialTheme.typography.titleMedium)
            Text("Shows current page position", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            val pagerState = rememberPagerState(pageCount = { 4 })

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) { page ->
                    val colors = listOf(
                        Color(0xFF6200EE),
                        Color(0xFF03DAC5),
                        Color(0xFFFF6F00),
                        Color(0xFFD32F2F)
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(colors[page]),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Slide ${page + 1}",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Page Indicator
                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(pagerState.pageCount) { iteration ->
                        val color = if (pagerState.currentPage == iteration) {
                            Color(0xFF6200EE)
                        } else {
                            Color.LightGray
                        }
                        Box(
                            modifier = Modifier
                                .padding(4.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(10.dp)
                        )
                    }
                }
            }
        }
    }
}

// Example 3: Vertical Pager
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Example3_VerticalPager() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("3. Vertical Pager", style = MaterialTheme.typography.titleMedium)
            Text("Swipe up or down to navigate", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            val pagerState = rememberPagerState(pageCount = { 3 })

            VerticalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            ) { page ->
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = when (page) {
                            0 -> Color(0xFFB39DDB)
                            1 -> Color(0xFF81C784)
                            else -> Color(0xFFFFB74D)
                        }
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Vertical Page ${page + 1}",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Swipe vertically",
                                fontSize = 14.sp,
                                color = Color.White.copy(alpha = 0.8f),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}

// Example 4: Pager with Navigation Buttons
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Example4_PagerWithButtons() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("4. Pager with Buttons", style = MaterialTheme.typography.titleMedium)
            Text("Navigate using buttons or swipe", style = MaterialTheme.typography.bodySmall)

            Spacer(modifier = Modifier.height(8.dp))

            val pagerState = rememberPagerState(pageCount = { 6 })
            val coroutineScope = rememberCoroutineScope()

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(
                            Color(
                                red = (page * 40) % 255,
                                green = (page * 80) % 255,
                                blue = (page * 120) % 255
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Page ${page + 1} of ${pagerState.pageCount}",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Navigation Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        coroutineScope.launch {
                            if (pagerState.currentPage > 0) {
                                pagerState.animateScrollToPage(pagerState.currentPage - 1)
                            }
                        }
                    },
                    enabled = pagerState.currentPage > 0
                ) {
                    Text("Previous")
                }

                Text(
                    text = "${pagerState.currentPage + 1} / ${pagerState.pageCount}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )

                Button(
                    onClick = {
                        coroutineScope.launch {
                            if (pagerState.currentPage < pagerState.pageCount - 1) {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        }
                    },
                    enabled = pagerState.currentPage < pagerState.pageCount - 1
                ) {
                    Text("Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSwipeablePagerDemo() {
    // Example1_BasicHorizontalPager()
    // Example2_HorizontalPagerWithIndicator()
    // Example3_VerticalPager()
    Example4_PagerWithButtons()
}

