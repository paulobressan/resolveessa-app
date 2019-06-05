package com.example.resolveessa_app

data class BaseResponseDTO<T> (
    val items: List<T>
)