package com.athzaq.menitcom.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.athzaq.menitcom.R
import com.athzaq.menitcom.databinding.ActivitySembuhCovidBinding
import com.athzaq.menitcom.model.ResponseCovid
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SembuhCovidActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySembuhCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySembuhCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = RetrofitBuild.getServiceSembuh().headlinesSembuh()
        call.enqueue(object : Callback<ResponseCovid>{
            override fun onResponse(
                call: Call<ResponseCovid>,
                response: Response<ResponseCovid>
            ) {
                val listSembuh = response.body()
                listSembuh.let {
                    binding.txtJumlahSembuhCovid.text = listSembuh?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
                Toast.makeText(this@SembuhCovidActivity, "Gagal!", Toast.LENGTH_SHORT).show()
            }

        })
    }
}