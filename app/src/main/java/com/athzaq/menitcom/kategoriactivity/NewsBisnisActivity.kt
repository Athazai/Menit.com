package com.athzaq.menitcom.kategoriactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.adapter.AdapterNewsBisnis
import com.athzaq.menitcom.databinding.ActivityNewsBisnisBinding
import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsBisnisActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNewsBisnisBinding
    private val newsBisnisAdapter = AdapterNewsBisnis()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBisnisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            recyclerbisnis.adapter = newsBisnisAdapter
            recyclerbisnis.layoutManager = LinearLayoutManager(baseContext)
            recyclerbisnis.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceBisnis().headlinesBisnis()
        call.enqueue(object : Callback<ResponseNews>{
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsBisnisAdapter.addDataBerita(it1) }
                }
            }

            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}