package com.example.efrainjuarez.api

class NetworkReponces {
    sealed class NetworkResponse<out T>{
        data class Success<out T>(val data:T): NetworkResponse<T>()
        data class Error(val Message: String): NetworkResponse<Nothing>()
        object loaging: NetworkResponse<Nothing>()
    }
}