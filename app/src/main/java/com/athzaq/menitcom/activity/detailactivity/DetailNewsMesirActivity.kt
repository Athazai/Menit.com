package com.athzaq.menitcom.activity.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.menitcom.R
import com.athzaq.menitcom.databinding.ActivityDetailNewsMesirBinding

class DetailNewsMesirActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailNewsMesirBinding

    companion object {
        const val PublishedAt = "P"
        const val Author = "A"
        const val UrlImage = "UrlImage"
        const val Description = "D"
        const val Source = "S"
        const val Title = "T"
        const val Url = "url"
        const val Content = "C"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsMesirBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtContextdetailmesir.text = intent.getStringExtra(Content)
        binding.txtAuthorDetailNewsMesir.text = intent.getStringExtra(Author)
        binding.txtPublisheddetailmesir.text = intent.getStringExtra(PublishedAt)
        binding.txtDeskdetailbmesir.text = intent.getStringExtra(Description)
        binding.txtJudulDetailNewsMesir.text = intent.getStringExtra(Title)
        binding.imgDetailNewsMesir.load(intent.getStringExtra(UrlImage))
    }
}