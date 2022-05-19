package com.athzaq.menitcom.activity.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.menitcom.databinding.ActivityDetailNewsUkactivityBinding

class DetailNewsUKActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailNewsUkactivityBinding

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
        binding = ActivityDetailNewsUkactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.txtPublisheddetailuk.text = intent.getStringExtra(PublishedAt)
        binding.txtAuthorDetailNewsUk.text = intent.getStringExtra(Author)
        binding.imgDetailNewsUk.load(intent.getStringExtra(UrlImage))
        binding.txtDeskdetailuk.text = intent.getStringExtra(Description)
        binding.txtJudulDetailNewsUk.text = intent.getStringExtra(Title)
        binding.txtContextdetailuk.text = intent.getStringExtra(Content)

    }
}