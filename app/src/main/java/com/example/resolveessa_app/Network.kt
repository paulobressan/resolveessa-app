package com.example.resolveessa_app

import com.example.resolveessa_app.user.UserAPI
import com.example.resolveessa_app.user.signin.dto.SigninReturnDTO
import com.example.resolveessa_app.user.signin.dto.SigninSendDTO
import com.example.resolveessa_app.user.signup.dto.SignupReturnDTO
import com.example.resolveessa_app.user.signup.dto.SignupSendDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    private const val URL = "http://192.168.0.110:4000/"

    fun sign(signinSendDTO: SigninSendDTO): Call<SigninReturnDTO> {
        return getRetrofit().create(UserAPI::class.java).sign(signinSendDTO)
    }

    fun signup(signupSendDTO: SignupSendDTO): Call<SignupReturnDTO>{
        return getRetrofit().create(UserAPI::class.java).signup(signupSendDTO)
    }

    private fun getRetrofit() = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}