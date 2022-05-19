package com.athzaq.menitcom.covid

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.R
import com.athzaq.menitcom.adapter.AdapterDataCovidProvinsi
import com.athzaq.menitcom.databinding.ActivityDataProvinsiCovidBinding
import com.athzaq.menitcom.model.ResponseNewsCovidProvinsi
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataProvinsiCovidActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataProvinsiCovidBinding
    private val provadapter = AdapterDataCovidProvinsi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataProvinsiCovidBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclercovidprovinsi.adapter = provadapter
            recyclercovidprovinsi.layoutManager = LinearLayoutManager(baseContext)
            recyclercovidprovinsi.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceProvinsi().headlinesProvinsi()
        call.enqueue(object : Callback<ResponseNewsCovidProvinsi>{
            override fun onResponse(
                call: Call<ResponseNewsCovidProvinsi>,
                response: Response<ResponseNewsCovidProvinsi>
            ) {
                val listProvinsi = response.body()?.data
                listProvinsi.let {
                    it?.let { it1 -> provadapter.addDataProv(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNewsCovidProvinsi>, t: Throwable) {
                Toast.makeText(this@DataProvinsiCovidActivity, "Gagal!", Toast.LENGTH_SHORT).show()
            }

        })
    }
}