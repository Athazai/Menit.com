package com.athzaq.menitcom.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.adapter.AdapterNewsOlahraga
import com.athzaq.menitcom.databinding.ActivityNewsEntertaimentBinding
import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsOlahragaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsEntertaimentBinding
    private val newsEntertaimentAdapter = AdapterNewsOlahraga()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsEntertaimentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            recyclerentertaiment.adapter = newsEntertaimentAdapter
            recyclerentertaiment.layoutManager = LinearLayoutManager(baseContext)
            recyclerentertaiment.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceEntertaiment().headlinesEntertaiment()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(
                call: Call<ResponseNews>,
                response: Response<ResponseNews>) {
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsEntertaimentAdapter.addDataEntertaimentNews(it1) }
                }
            }
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Toast.makeText(this@NewsOlahragaActivity, "Gagal!", Toast.LENGTH_SHORT).show()
            }
        })
    }
}