package com.athzaq.menitcom.activity.detailactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.athzaq.menitcom.databinding.ActivityDetailNewsBisnisBinding

class DetailNewsBisnisActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailNewsBisnisBinding

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
        binding = ActivityDetailNewsBisnisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtContextdetailbisnis.text = intent.getStringExtra(Content)
        binding.txtAuthorDetailNewsBisnis.text = intent.getStringExtra(Author)
        binding.txtContextdetailbisnis.text = intent.getStringExtra(PublishedAt)
        binding.txtContextdetailbisnis.text = intent.getStringExtra(Description)
        binding.txtContextdetailbisnis.text = intent.getStringExtra(Title)
        binding.imgDetailNewsBisnis.load(intent.getStringExtra(UrlImage))

    }
}