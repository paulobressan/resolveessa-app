package com.example.resolveessa_app.user

import com.example.resolveessa_app.user.signin.dto.SigninReturnDTO
import com.example.resolveessa_app.user.signin.dto.SigninSendDTO
import com.example.resolveessa_app.user.signup.dto.SignupReturnDTO
import com.example.resolveessa_app.user.signup.dto.SignupSendDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/users/authenticate")
    fun sign(@Body signinSendDTO: SigninSendDTO): Call<SigninReturnDTO>

    @POST("/users")
    fun signup(@Body signupSendDTO: SignupSendDTO): Call<SignupReturnDTO>
}