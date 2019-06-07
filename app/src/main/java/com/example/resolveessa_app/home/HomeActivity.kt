package com.example.resolveessa_app.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.resolveessa_app.R
import com.example.resolveessa_app.problem.ProblemsActivity
import com.example.resolveessa_app.problem.create_problem.CreateProblemActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnTeste.setOnClickListener {
            startActivity(Intent(applicationContext, ProblemsActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.add_problem -> {
                startActivity(Intent(applicationContext, CreateProblemActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
