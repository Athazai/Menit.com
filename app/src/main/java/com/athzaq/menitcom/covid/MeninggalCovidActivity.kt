package com.athzaq.menitcom.covid

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.athzaq.menitcom.R
import com.athzaq.menitcom.databinding.ActivityMeninggalCovidBinding
import com.athzaq.menitcom.model.ResponseCovid
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MeninggalCovidActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMeninggalCovidBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeninggalCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val call = RetrofitBuild.getServiceMeninggal().headlinesMeninggal()
        call.enqueue(object : Callback<ResponseCovid>{
            override fun onResponse(
                call: Call<ResponseCovid>,
                response: Response<ResponseCovid>
            ) {
                val listMeninggal = response.body()
                listMeninggal.let {
                    binding.txtJumlahMeninggalCovid.text = listMeninggal?.value
                }
            }

            override fun onFailure(call: Call<ResponseCovid>, t: Throwable) {
                Toast.makeText(this@MeninggalCovidActivity, "Gagal!", Toast.LENGTH_SHORT).show()
            }

        })
    }
}