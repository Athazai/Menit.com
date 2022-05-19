package com.athzaq.menitcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.R
import com.athzaq.menitcom.adapter.AdapterNewsKorea
import com.athzaq.menitcom.databinding.ActivityNewsKoreaBinding
import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsKoreaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsKoreaBinding
    private val newsKoreaAdapter = AdapterNewsKorea()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsKoreaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerkorea.adapter = newsKoreaAdapter
            recyclerkorea.layoutManager = LinearLayoutManager(baseContext)
            recyclerkorea.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceKR().headlinesKR()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsKoreaAdapter.addDataNewsKorea(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}