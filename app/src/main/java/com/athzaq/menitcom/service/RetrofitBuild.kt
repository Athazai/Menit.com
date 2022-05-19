package com.athzaq.menitcom.service

import com.athzaq.menitcom.model.ResponseNews
import com.athzaq.menitcom.model.ResponseCovid
import com.athzaq.menitcom.model.ResponseNewsCovidProvinsi
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

object RetrofitBuild {

    private val client : OkHttpClient = OkHttpClient.Builder().build()

    //mengkonfigurasi URL dasar atau baseurl
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val retrofitt : Retrofit = Retrofit.Builder()
        .baseUrl("https://indonesia-covid-19.mathdro.id/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()


    fun getServiceIndo() = retrofit.create(TopNewsIndo::class.java)
    fun getServiceUs() = retrofit.create(NewsTopUS::class.java)
    fun getServiceUK() = retrofit.create(NewsTopUK::class.java)
    fun getServiceSA() = retrofit.create(NewsTopArab::class.java)
    fun getServiceKR() = retrofit.create(NewsTopKR::class.java)


    fun getServicePositif() = retrofit.create(Positif::class.java)
    fun getServiceSembuh() = retrofit.create(Sembuh::class.java)
    fun getServiceMeninggal() = retrofit.create(Meninggal::class.java)
    fun getServiceProvinsi() = retrofitt.create(Provinsi::class.java)


        fun getServiceBisnis() = retrofit.create(Bisnis::class.java)
        fun getServiceScience() = retrofit.create(Sains::class.java)
        fun getServiceEntertaiment() = retrofit.create(Entertaiment::class.java)

}


/// About News

    interface TopNewsIndo {

         @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
         @GET("v2/top-headlines?country=id")

         fun headlinesindo() : Call<ResponseNews>
}


    interface NewsTopUS {
        @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
        @GET("v2/top-headlines?country=us")

        fun headlinesUS() : Call<ResponseNews>
    }

    interface NewsTopUK {
        @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
        @GET("v2/top-headlines?country=gb")

        fun headlinesUK() : Call<ResponseNews>
    }
    interface NewsTopArab {
        @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
        @GET("v2/top-headlines?country=eg")

        fun headlinesARB() : Call<ResponseNews>
    }
    interface NewsTopKR {
        @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
        @GET("v2/top-headlines?country=kr")

        fun headlinesKR() : Call<ResponseNews>
    }


/// About Covid

    interface Positif {

        @GET("https://api.kawalcorona.com/positif")

        fun headlinesPositif() : Call<ResponseCovid>
    }
    interface Sembuh {
        @GET("https://api.kawalcorona.com/sembuh")

        fun headlinesSembuh() : Call<ResponseCovid>
    }
    interface Meninggal {
        @GET("https://api.kawalcorona.com/meninggal")

        fun headlinesMeninggal(): Call<ResponseCovid>
    }
    interface Provinsi {
        @GET("api/provinsi")

        fun headlinesProvinsi(): Call<ResponseNewsCovidProvinsi>
    }



/// About Kategori

     interface Bisnis {

         @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
         @GET("v2/top-headlines?country=id&category=business")

         fun headlinesBisnis() : Call<ResponseNews>
     }
     interface Sains {

         @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
         @GET("v2/top-headlines?country=id&category=science")

     fun headlinesSains() : Call<ResponseNews>
     }
     interface Entertaiment {

         @Headers("Authorization: ba77e0e5b1f347d39087968673eb5fb7")
         @GET("v2/top-headlines?country=id&category=sports")

     fun headlinesEntertaiment() : Call<ResponseNews>
     }
