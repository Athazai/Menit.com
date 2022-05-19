package com.athzaq.menitcom.model

import com.athzaq.menitcom.service.Positif
import com.google.gson.annotations.SerializedName

data class ResponseNewsCovidProvinsi(

    @field:SerializedName("data")
    val data : List<DataItem>? = null
)

data class DataItem(

    @field:SerializedName("fid")
    val fid:Int? = null,

    @field:SerializedName("provinsi")
    val provinsi:String? = null,

    @field:SerializedName("kasusMeni")
    val kasusMeni:String? = null,

    @field:SerializedName("kodeProv")
    val kodeProv:Int? = null,

    @field:SerializedName("kasusSemb")
    val kasusSemb:String? = null,

    @field:SerializedName("kasusPosi")
    val kasusPosi:String? = null,
)