package com.athzaq.menitcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.R
import com.athzaq.menitcom.adapter.AdapterNewsArab
import com.athzaq.menitcom.databinding.ActivityNewsSaudiArabiaBinding
import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsSaudiArabiaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsSaudiArabiaBinding
    private val newsSaudiAdapter = AdapterNewsArab()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsSaudiArabiaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclerarab.adapter = newsSaudiAdapter
            recyclerarab.layoutManager = LinearLayoutManager(baseContext)
            recyclerarab.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceSA().headlinesARB()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsSaudiAdapter.addDataNewsArab(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}