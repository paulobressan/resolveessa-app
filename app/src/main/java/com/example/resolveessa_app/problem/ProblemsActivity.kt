package com.example.resolveessa_app.problem

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.resolveessa_app.BaseResponseDTO
import com.example.resolveessa_app.Network
import com.example.resolveessa_app.R
import com.example.resolveessa_app.home.HomeActivity
import com.example.resolveessa_app.problem.dto.ProblemReturnDTO
import com.example.resolveessa_app.problem.info_problem.InfoProblemActivity
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
                    injector.text(R.id.txtSubCategory, data.subCategory)
                    injector.text(R.id.txtObservation, data.observation)
                    injector.clicked(R.id.btnInfo) {
                        val intent = Intent(applicationContext, InfoProblemActivity::class.java)
                        intent.putExtra("id", data.id)
                        startActivity(intent)
                    }
                }).attachTo(recyclerView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_problems)
        Network.getProblems()
            .enqueue(object : Callback<BaseResponseDTO<ProblemReturnDTO>> {
                override fun onResponse(
                    call: Call<BaseResponseDTO<ProblemReturnDTO>>, response: Response<BaseResponseDTO<ProblemReturnDTO>>
                ) {
                    slimAdapter.updateData(response.body()?.items)
                }

                override fun onFailure(call: Call<BaseResponseDTO<ProblemReturnDTO>>, t: Throwable) {
                    System.out.print("Erro" + t.message)
                }
            })
        //slimAdapter.updateData()
    }
}
