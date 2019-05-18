package com.example.resolveessa_app.user.signup

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.resolveessa_app.Network
import com.example.resolveessa_app.R
import com.example.resolveessa_app.home.HomeActivity
import com.example.resolveessa_app.user.signup.dto.SignupReturnDTO
import com.example.resolveessa_app.user.signup.dto.SignupSendDTO
import kotlinx.android.synthetic.main.activity_signup.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btnRegister.setOnClickListener {
            Network.signup(
                SignupSendDTO(
                    txtName.text.toString(),
                    txtFone.text.toString(),
                    txtEmail.text.toString(),
                    txtPassword.text.toString()
                )
            )
                .enqueue(object : Callback<SignupReturnDTO> {
                    override fun onResponse(call: Call<SignupReturnDTO>, response: Response<SignupReturnDTO>) {
                        if (response.isSuccessful) {
                            Toast.makeText(
                                applicationContext,
                                getText(R.string.msg_register_success),
                                Toast.LENGTH_SHORT
                            )
                                .show()
                            startActivity(Intent(applicationContext, HomeActivity::class.java))
                        } else {
                            Toast.makeText(
                                applicationContext,
                                "Dados Invalidos",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<SignupReturnDTO>, t: Throwable) {
                        Toast.makeText(
                            applicationContext,
                            getString(R.string.api_fail),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }
    }
}
