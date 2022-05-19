package com.athzaq.menitcom.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.R
import com.athzaq.menitcom.adapter.AdapterNewsSains
import com.athzaq.menitcom.databinding.ActivityNewsSainsBinding
import com.athzaq.menitcom.model.ArticlesItem
import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsSainsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsSainsBinding
    private val newsSainsAdapter = AdapterNewsSains()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsSainsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclersains.adapter = newsSainsAdapter
            recyclersains.layoutManager = LinearLayoutManager(baseContext)
            recyclersains.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceScience().headlinesSains()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(
                call: Call<ResponseNews>,
                response: Response<ResponseNews>) {
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsSainsAdapter.addDataSainsNews(it1) }
                }
            }
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}