package com.example.resolveessa_app.problem.dto

import com.google.gson.annotations.SerializedName

data class ProblemReturnDTO(
    @SerializedName("_id")
    val id: String,
    val user: String,
    val subCategory: String,
    val observation: String,
    val latitude: String,
    val longitude: String
)