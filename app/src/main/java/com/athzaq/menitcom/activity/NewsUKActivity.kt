package com.athzaq.menitcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.R
import com.athzaq.menitcom.adapter.AdapterNewsUK
import com.athzaq.menitcom.databinding.ActivityNewsUkactivityBinding
import com.athzaq.menitcom.databinding.ActivityNewsUsactivityBinding
import com.athzaq.menitcom.databinding.ItemRecyclerUkBinding
import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsUKActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsUkactivityBinding
    private val newsUKAdapter = AdapterNewsUK()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsUkactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclernewsUK.adapter = newsUKAdapter
            recyclernewsUK.layoutManager = LinearLayoutManager(this@NewsUKActivity)
            recyclernewsUK.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceUK().headlinesUK()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(
                call: Call<ResponseNews>,
                response: Response<ResponseNews>
            ) { val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsUKAdapter.addDataNews(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Toast.makeText(this@NewsUKActivity, "GAGAL!", Toast.LENGTH_SHORT).show()
            }

        })
    }
}