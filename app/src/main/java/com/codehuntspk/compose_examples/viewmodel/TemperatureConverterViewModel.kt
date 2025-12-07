package com.codehuntspk.compose_examples.viewmodel

import androidx.lifecycle.ViewModel
import com.codehuntspk.compose_examples.data.model.EditField
import com.codehuntspk.compose_examples.data.model.TemperatureUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TemperatureConverterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TemperatureUiState())

    val uiState: StateFlow<TemperatureUiState> = _uiState.asStateFlow()

    fun onCelsiusChange(value: String) {
        val fahrenheit = if (value.isNotEmpty() && value.toDoubleOrNull() != null) {
            String.format("%.2f", (value.toDouble() * 9 / 5) + 32)
        } else {
            ""
        }

        _uiState.value = TemperatureUiState(
            celsius = value,
            fahrenheit = fahrenheit,
            lastEdited = EditField.CELSIUS
        )
    }

    fun onFahrenheitChange(value: String) {
        val celsius = if (value.isNotEmpty() && value.toDoubleOrNull() != null) {
            String.format("%.2f", (value.toDouble() - 32) * 5 / 9)
        } else {
            ""
        }

        _uiState.value = TemperatureUiState(
            celsius = celsius,
            fahrenheit = value,
            lastEdited = EditField.FAHRENHEIT
        )
    }

    fun clearAll() {
        _uiState.value = TemperatureUiState()
    }

}