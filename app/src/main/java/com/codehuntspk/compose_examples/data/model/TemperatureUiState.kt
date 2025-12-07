package com.codehuntspk.compose_examples.data.model

data class TemperatureUiState(
    val celsius: String = "",
    val fahrenheit: String = "",
    val lastEdited: EditField? = null
)
