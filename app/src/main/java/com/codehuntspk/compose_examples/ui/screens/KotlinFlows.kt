package com.codehuntspk.compose_examples.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.asFlow
import com.codehuntspk.compose_examples.data.database.ProductRoomDatabase
import com.codehuntspk.compose_examples.data.model.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch

// 1. BASIC FLOW (Cold Stream)
fun basicColdFlow(): Flow<Int> = flow {
    println("Cold Flow Started")
    for (i in 1..5) {
        delay(500)
        emit(i)
    }
}

// 2. STATEFLOW (Hot Stream for UI State)
class CounterViewModel {
    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter.asStateFlow()

    fun increment() {
        _counter.value += 1
    }

    fun decrement() {
        _counter.value -= 1
    }
}

// 3. SHAREDFLOW (Hot Stream for Events)
class EventViewModel {
    private val _events = MutableSharedFlow<String>()
    val events = _events.asSharedFlow()

    suspend fun sendEvent(event: String) {
        _events.emit(event)
    }
}

// 4. COMBINING MULTIPLE FLOWS
class CombinedFlowsViewModel {
    private val _temperature = MutableStateFlow(20)
    private val _humidity = MutableStateFlow(50)

    val weatherStatus = combine(_temperature, _humidity) { temp, humid ->
        "Temperature: ${temp}°C, Humidity: ${humid}%"
    }

    fun updateTemperature(temp: Int) {
        _temperature.value = temp
    }

    fun updateHumidity(humid: Int) {
        _humidity.value = humid
    }
}

// 6. DEBOUNCE (Search Use Case)
class SearchViewModel {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    @OptIn(kotlinx.coroutines.FlowPreview::class)
    val debouncedSearch = _searchQuery
        .debounce(500)
        .filter { it.isNotBlank() }
        .map { query ->
            performSearch(query)
        }

    fun updateQuery(query: String) {
        _searchQuery.value = query
    }

    private suspend fun performSearch(query: String): List<String> {
        delay(300) // Simulate network call
        return listOf(
            "$query - Result 1",
            "$query - Result 2",
            "$query - Result 3"
        )
    }
}

@Composable
fun KotlinFlowsScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    // ViewModels
    val counterViewModel = remember { CounterViewModel() }
    val eventViewModel = remember { EventViewModel() }
    val combinedViewModel = remember { CombinedFlowsViewModel() }
    val searchViewModel = remember { SearchViewModel() }

    // States
    val counter by counterViewModel.counter.collectAsState()
    val weatherStatus by combinedViewModel.weatherStatus.collectAsState(initial = "Loading...")
    val searchQuery by searchViewModel.searchQuery.collectAsState()

    var coldFlowValue by remember { mutableStateOf("Not Started") }
    var mapResult by remember { mutableStateOf<List<Int>>(emptyList()) }
    var filterResult by remember { mutableStateOf<List<Int>>(emptyList()) }
    var zipResult by remember { mutableStateOf<List<String>>(emptyList()) }
    var searchResults by remember { mutableStateOf<List<String>>(emptyList()) }
    var dbProducts by remember { mutableStateOf<List<Product>>(emptyList()) }

    // Collect events
    LaunchedEffect(Unit) {
        eventViewModel.events.collect { event ->
            snackbarHostState.showSnackbar(event)
        }
    }

    // Collect debounced search
    LaunchedEffect(Unit) {
        searchViewModel.debouncedSearch.collect { results ->
            searchResults = results
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Text(
                    "Kotlin Flows Examples",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            // 1. Cold Flow Example
            item {
                ExampleCard(title = "1. Basic Flow (Cold Stream)") {
                    Text("Value: $coldFlowValue")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        scope.launch {
                            basicColdFlow().collect { value ->
                                coldFlowValue = value.toString()
                            }
                        }
                    }) {
                        Text("Start Cold Flow")
                    }
                }
            }

            // 2. StateFlow Example
            item {
                ExampleCard(title = "2. StateFlow (Hot Stream for UI State)") {
                    Text("Counter: $counter", style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = { counterViewModel.increment() }) {
                            Text("+")
                        }
                        Button(onClick = { counterViewModel.decrement() }) {
                            Text("-")
                        }
                    }
                }
            }

            // 3. SharedFlow Example
            item {
                ExampleCard(title = "3. SharedFlow (Hot Stream for Events)") {
                    Text("Events shown in Snackbar")
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        scope.launch {
                            eventViewModel.sendEvent("Button clicked at ${System.currentTimeMillis()}")
                        }
                    }) {
                        Text("Send Event")
                    }
                }
            }

            // 4. Flow Operators
            item {
                ExampleCard(title = "4. Flow Operators (Map, Filter, Zip)") {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        // Map
                        Button(onClick = {
                            scope.launch {
                                flowOf(1, 2, 3, 4, 5)
                                    .map { it * it }
                                    .collect { mapResult = mapResult + it }
                            }
                        }) {
                            Text("Map: Square Numbers")
                        }
                        Text("Map Result: $mapResult")

                        HorizontalDivider()

                        // Filter
                        Button(onClick = {
                            scope.launch {
                                flowOf(1, 2, 3, 4, 5, 6, 7, 8)
                                    .filter { it % 2 == 0 }
                                    .collect { filterResult = filterResult + it }
                            }
                        }) {
                            Text("Filter: Even Numbers")
                        }
                        Text("Filter Result: $filterResult")

                        HorizontalDivider()

                        // Zip
                        Button(onClick = {
                            scope.launch {
                                flowOf("A", "B", "C")
                                    .zip(flowOf(1, 2, 3)) { letter, number ->
                                        "$letter$number"
                                    }
                                    .collect { zipResult = zipResult + it }
                            }
                        }) {
                            Text("Zip: Combine Flows")
                        }
                        Text("Zip Result: $zipResult")
                    }
                }
            }

            // 5. Room Database Flow
            item {
                ExampleCard(title = "5. Flow from Room Database") {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(onClick = {
                                scope.launch {
                                    val db = ProductRoomDatabase.getInstance(context)
                                    db.productDao().insertProduct(
                                        Product("Product ${System.currentTimeMillis() % 1000}", (1..10).random())
                                    )
                                }
                            }) {
                                Text("Add Product")
                            }

                            Button(onClick = {
                                scope.launch {
                                    val db = ProductRoomDatabase.getInstance(context)
                                    db.productDao().getAllProducts().asFlow().collect { products ->
                                        dbProducts = products
                                    }
                                }
                            }) {
                                Text("Load Products")
                            }
                        }

                        Text("Products from DB: ${dbProducts.size}")
                        dbProducts.take(3).forEach { product ->
                            Text("- ${product.productName} (Qty: ${product.quantity})",
                                modifier = Modifier.padding(start = 8.dp))
                        }
                    }
                }
            }

            // 6. Combining Multiple Flows
            item {
                ExampleCard(title = "6. Combining Multiple Flows") {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Weather Status: $weatherStatus")
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(onClick = {
                                combinedViewModel.updateTemperature((15..30).random())
                            }) {
                                Text("Update Temp")
                            }
                            Button(onClick = {
                                combinedViewModel.updateHumidity((30..80).random())
                            }) {
                                Text("Update Humidity")
                            }
                        }
                    }
                }
            }

            // 7. Debounce (Search)
            item {
                ExampleCard(title = "7. Debounce (Search Use Case)") {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        TextField(
                            value = searchQuery,
                            onValueChange = { searchViewModel.updateQuery(it) },
                            label = { Text("Search (debounced 500ms)") },
                            modifier = Modifier.fillMaxWidth()
                        )

                        if (searchResults.isNotEmpty()) {
                            Text("Results:", style = MaterialTheme.typography.labelLarge)
                            searchResults.forEach { result ->
                                Text("- $result", modifier = Modifier.padding(start = 8.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ExampleCard(
    title: String,
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            HorizontalDivider()
            content()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun KotlinFlowsScreenPreview() {
    MaterialTheme {
        KotlinFlowsScreen()
    }
}

