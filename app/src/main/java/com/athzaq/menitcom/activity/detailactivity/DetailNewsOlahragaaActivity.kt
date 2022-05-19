package com.athzaq.menitcom.activity.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.menitcom.databinding.ActivityDetailNewsOlahragaBinding

class DetailNewsOlahragaaActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailNewsOlahragaBinding

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
        binding = ActivityDetailNewsOlahragaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtContextdetailentertaiment.text = intent.getStringExtra(Content)
        binding.txtPublisheddetailentertaiment.text = intent.getStringExtra(PublishedAt)
        binding.txtDeskdetailentertaiment.text = intent.getStringExtra(Description)
        binding.txtJudulDetailNewsEntertaiment.text = intent.getStringExtra(Title)
        binding.txtAuthorDetailNewsEntertaiment.text = intent.getStringExtra(Author)
        binding.imgDetailNewsEntertaiment.load(intent.getStringExtra(UrlImage))

    }
}