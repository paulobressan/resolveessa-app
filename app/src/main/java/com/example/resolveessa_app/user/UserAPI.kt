package com.example.resolveessa_app.user

import com.example.resolveessa_app.user.signin.dto.SigninReturnDTO
import com.example.resolveessa_app.user.signin.dto.SigninSendDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {
    @POST("/users/authenticate")
    fun sign(@Body loginAuthenticateSendDTO: SigninSendDTO): Call<SigninReturnDTO>

}