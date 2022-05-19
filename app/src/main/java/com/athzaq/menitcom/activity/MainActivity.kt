package com.athzaq.menitcom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import com.athzaq.menitcom.WebViewActivity
import com.athzaq.menitcom.covid.DataProvinsiCovidActivity
import com.athzaq.menitcom.covid.MeninggalCovidActivity
import com.athzaq.menitcom.covid.PositveCovidActivity
import com.athzaq.menitcom.covid.SembuhCovidActivity
import com.athzaq.menitcom.databinding.ActivityMainBinding
import com.athzaq.menitcom.kategoriactivity.NewsBisnisActivity
import com.athzaq.menitcom.kategoriactivity.NewsOlahragaActivity
import com.athzaq.menitcom.kategoriactivity.NewsSainsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding.cvIndo.setOnClickListener {
            startActivity(Intent(this, NewsIndoActivity::class.java))
        }

        binding.cvUs.setOnClickListener {
            startActivity(Intent(this, NewsUSActivity::class.java))
        }

        binding.cvUKi.setOnClickListener {
            startActivity(Intent(this, NewsUKActivity::class.java))
        }
        binding.imgLonceng.setOnClickListener {
            Toast.makeText(this, "Anda akan menerima Notifikasi Terbaru!", Toast.LENGTH_SHORT).show()
        }
        binding.imgPositifcovid.setOnClickListener {
            startActivity(Intent(this, PositveCovidActivity::class.java))
        }
        binding.imgSembuhcovid.setOnClickListener {
            startActivity(Intent(this, SembuhCovidActivity::class.java))
        }
        binding.imgMeninggalcovid.setOnClickListener {
            startActivity(Intent(this, MeninggalCovidActivity::class.java))
        }
        binding.imgProvinsicovid.setOnClickListener {
            startActivity(Intent(this, DataProvinsiCovidActivity::class.java))
        }
        binding.imgLogoolahraga.setOnClickListener {
            startActivity(Intent(this, NewsBisnisActivity::class.java))
        }
        binding.txtWebcorona.setOnClickListener {
            startActivity(Intent(this, WebViewActivity::class.java))
        }
        binding.imgOlaharaga.setOnClickListener {
            startActivity(Intent(this, NewsOlahragaActivity::class.java))
        }
        binding.imgLogosains.setOnClickListener {
            startActivity(Intent(this, NewsSainsActivity::class.java))
        }
        binding.imgArabia.setOnClickListener {
            startActivity(Intent(this, NewsSaudiArabiaActivity::class.java))
        }
        binding.imgKoreann.setOnClickListener {
            startActivity(Intent(this, NewsKoreaActivity::class.java))
        }
    }
}