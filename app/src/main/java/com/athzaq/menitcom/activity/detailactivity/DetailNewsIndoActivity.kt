package com.athzaq.menitcom.activity.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.menitcom.databinding.ActivityDetailNewsIndoBinding

class DetailNewsIndoActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailNewsIndoBinding

    companion object{
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
        binding = ActivityDetailNewsIndoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtContextdetailuk.text = intent.getStringExtra(Content)
        binding.txtPublisheddetailuk.text = intent.getStringExtra(PublishedAt)
        binding.txtDeskdetailuk.text = intent.getStringExtra(Description)
        binding.txtJudulDetailNewsUk.text = intent.getStringExtra(Title)
        binding.txtAuthorDetailNewsUk.text = intent.getStringExtra(Author)
        binding.imgDetailNewsUk.load(intent.getStringExtra(UrlImage))
    }
}