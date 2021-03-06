package com.example.resolveessa_app.user.signin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.resolveessa_app.Network
import com.example.resolveessa_app.R
import com.example.resolveessa_app.home.HomeActivity
import com.example.resolveessa_app.user.signin.dto.SigninReturnDTO
import com.example.resolveessa_app.user.signin.dto.SigninSendDTO
import com.example.resolveessa_app.user.signup.SignupActivity
import com.example.resolveessa_app.utils.Preferences
import kotlinx.android.synthetic.main.activity_signin.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SigninActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        btnSigin.setOnClickListener {
            Network.sign(SigninSendDTO(txtName.text.toString(), txtPassword.text.toString()))
                .enqueue(object : Callback<SigninReturnDTO> {
                    override fun onResponse(
                        call: Call<SigninReturnDTO>,
                        response: Response<SigninReturnDTO>
                    ) {
                        val error = response.errorBody()
                        if (response.isSuccessful) {
                            Toast.makeText(applicationContext, getText(R.string.login_authorized), Toast.LENGTH_SHORT)
                                .show()
                            Preferences.getInstance(applicationContext).token = response.body()!!.accessToken
                            startActivity(Intent(applicationContext, HomeActivity::class.java))
                        } else {
                            Toast.makeText(
                                applicationContext,
                                error?.string() ?: getString(R.string.login_unauthorized),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<SigninReturnDTO>, t: Throwable) {
                        Toast.makeText(
                            applicationContext,
                            getString(R.string.api_fail),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }

        btnSigup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }

        if (Preferences.getInstance(this).isExistToken){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}
