package com.example.resolveessa_app.problem.info_problem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.resolveessa_app.R

class InfoProblemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_problem)
    }

    //Depois que carregar a tela
    override fun onResume() {
        super.onResume()
        val i = intent.extras
        val id = intent.extras.getString("id")
        Toast.makeText(applicationContext, id, Toast.LENGTH_SHORT).show()
    }
}
