package com.example.hrresturant.ui.util

sealed class NetworkResponse<out T> {
    data class Success<T>(val data: T?) : NetworkResponse<T>()
    data class Error<T>(val errorMessage: String) : NetworkResponse<T>()
}

sealed interface UiState {
    object Success : UiState
    object Loading : UiState
    data class Error(val errorMessage: String) : UiState
}
