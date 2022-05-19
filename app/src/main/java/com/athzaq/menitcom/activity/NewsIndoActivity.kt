package com.athzaq.menitcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.athzaq.menitcom.R
import com.athzaq.menitcom.adapter.AdapterNewsIndo
import com.athzaq.menitcom.databinding.ActivityNewsIndoBinding
import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.service.RetrofitBuild
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class NewsIndoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsIndoBinding
    private val newsAdapter = AdapterNewsIndo()
    private var isLoading = false
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsIndoBinding.inflate(layoutInflater)

        Timber.plant(Timber.DebugTree())

        with(binding){
            setContentView(root)
            setSupportActionBar(toolbar)
            supportActionBar?.apply {
                setDisplayShowHomeEnabled(true)
                setDisplayUseLogoEnabled(true)
            }
            recyclernewsindo.adapter = newsAdapter
            recyclernewsindo.layoutManager = LinearLayoutManager(baseContext)
            recyclernewsindo.setHasFixedSize(true)
        }
        val call = RetrofitBuild.getServiceIndo().headlinesindo()
        //call enqueue untuk mengambil data dari
        call.enqueue(object  : Callback<ResponseNews>{
            override fun onResponse(
                call: Call<ResponseNews>,
                response: Response<ResponseNews>
            ) {
                Timber.d(response.body()?.totalResults.toString())
                val listArticlesItem = response.body()?.articles
                listArticlesItem.let {
                    it?.let { it1 -> newsAdapter.addDataNews(it1)}
                }
            }
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
               // Toast.makeText(this@NewsIndoActivity, "GAGAL! WKWKWKWKWK", Toast.LENGTH_SHORT).show()
                Timber.e(t.localizedMessage)
            }
        })
        binding.icShare.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Hei Ayo Cek Aplikasi Kami!")
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent,"Share To"))
        }
    }
}