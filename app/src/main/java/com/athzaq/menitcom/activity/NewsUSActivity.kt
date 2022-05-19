package com.athzaq.menitcom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.R
import com.athzaq.menitcom.adapter.AdapterNewsUS
import com.athzaq.menitcom.databinding.ActivityNewsUsactivityBinding
import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsUSActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsUsactivityBinding
    private val newsUSAdapter = AdapterNewsUS()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsUsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
//            setContentView(root)
//            setSupportActionBar(toolbarus)
//            supportActionBar?.apply {
//                setDisplayShowHomeEnabled(true)
//                setLogo(R.drawable.detikpas)
//                setDisplayUseLogoEnabled(true)
//            }
            recyclernewsUS.adapter = newsUSAdapter
            recyclernewsUS.layoutManager = LinearLayoutManager(baseContext)
            recyclernewsUS.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceUs().headlinesUS()
        call.enqueue(object : Callback<ResponseNews> {
            override fun onResponse(
                call: Call<ResponseNews>,
                response: Response<ResponseNews>
            ) {
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsUSAdapter.addDataNews(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                Toast.makeText(this@NewsUSActivity, "GAGAL!", Toast.LENGTH_SHORT).show()
            }
        }
        )
    }
}