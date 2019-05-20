package com.example.resolveessa_app.problem

import com.example.resolveessa_app.category.SubCategoryModel
import com.example.resolveessa_app.user.UserModel

class ProblemModel(
    val user: UserModel,
    val subCategory: SubCategoryModel,
    val observation: String,
    val latitude: String,
    val longitude: String
)