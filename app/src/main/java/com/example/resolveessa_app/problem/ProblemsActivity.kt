package com.example.resolveessa_app.problem

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.resolveessa_app.Network
import com.example.resolveessa_app.R
import com.example.resolveessa_app.home.HomeActivity
import com.example.resolveessa_app.problem.dto.ProblemReturnDTO
import kotlinx.android.synthetic.main.activity_problems.*
import net.idik.lib.slimadapter.SlimAdapter
import net.idik.lib.slimadapter.SlimInjector
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProblemsActivity : AppCompatActivity() {
    private val slimAdapter: SlimAdapter by lazy {
        SlimAdapter.create()
            .register(R.layout.item_problem,
                SlimInjector<ProblemReturnDTO> { data, injector ->
                    injector.text(R.id.txtSubCategory, data.subCategory.name)
                    injector.text(R.id.txtObservation, data.observation)
                    injector.clicked(R.id.btnInfo) {
                        startActivity(Intent(applicationContext, HomeActivity::class.java))
                    }
                }).attachTo(recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problems)
        Network.getProblems()
            .enqueue(object : Callback<List<ProblemReturnDTO>> {
                override fun onResponse(
                    call: Call<List<ProblemReturnDTO>>, response: Response<List<ProblemReturnDTO>>
                ) {
                    System.out.print("Teste")
                }

                override fun onFailure(call: Call<List<ProblemReturnDTO>>, t: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        //slimAdapter.updateData()
    }
}
