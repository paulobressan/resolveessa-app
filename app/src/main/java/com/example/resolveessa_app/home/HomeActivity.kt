package com.example.resolveessa_app.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.resolveessa_app.R
import com.example.resolveessa_app.problem.ProblemsActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnTeste.setOnClickListener {
            startActivity(Intent(applicationContext, ProblemsActivity::class.java))
        }
    }
}
