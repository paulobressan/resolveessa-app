package com.example.resolveessa_app.problem

import com.example.resolveessa_app.problem.dto.ProblemReturnDTO
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ProblemAPI {
    @SerializedName("items")
    @Headers(
        "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJyZXNvbHZlZXNzYSIsImlhdCI6MTU1ODM3MDc2M30.syouverIKcqKCMPnWiI-T5uibiT6qljwn5FVososYxk"
    )
    @GET("/problems")
    fun getProblems(): Call<List<ProblemReturnDTO>>
}