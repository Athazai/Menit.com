package com.athzaq.menitcom.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.athzaq.menitcom.databinding.ActivityPositveCovidBinding
import com.athzaq.menitcom.model.ResponseCovid
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PositveCovidActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPositveCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPositveCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = RetrofitBuild.getServicePositif().headlinesPositif()
        call.enqueue(object : Callback<ResponseCovid>{
            override fun onResponse(
                call: Call<ResponseCovid>,
                response: Response<ResponseCovid>
            ) {
                val listPositif = response.body()
                listPositif.let {
                    binding.txtJumlahPositifCovid.text = listPositif?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
                Toast.makeText(this@PositveCovidActivity, "Gagal! WKWKWKWK", Toast.LENGTH_SHORT).show()
            }

        })
    }
}