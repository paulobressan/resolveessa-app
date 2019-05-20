package com.example.resolveessa_app.problem.dto

import com.example.resolveessa_app.category.SubCategoryModel
import com.example.resolveessa_app.user.UserModel

data class ProblemReturnDTO(
    val user: UserModel,
    val subCategory: SubCategoryModel,
    val observation: String,
    val latitude: String,
    val longitude: String
)