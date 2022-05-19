package com.athzaq.menitcom.activity.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.menitcom.R
import com.athzaq.menitcom.databinding.ActivityDetailNewsKoreaSelatanBinding

class DetailNewsKoreaSelatanActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailNewsKoreaSelatanBinding

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
        binding = ActivityDetailNewsKoreaSelatanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtContextdetailkorsel.text = intent.getStringExtra(Content)
        binding.txtAuthorDetailNewsKorsel.text = intent.getStringExtra(Author)
        binding.txtPublisheddetailkorsel.text = intent.getStringExtra(PublishedAt)
        binding.txtDeskdetailbkorsel.text = intent.getStringExtra(Description)
        binding.txtJudulDetailNewsKorsel.text = intent.getStringExtra(Title)
        binding.imgDetailNewsKorsel.load(intent.getStringExtra(UrlImage))

    }
}