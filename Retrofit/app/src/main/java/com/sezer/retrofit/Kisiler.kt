package com.sezer.retrofit
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

data class Ulke(
    @SerializedName("name")
    @Expose
    var name:String,

    @SerializedName("capital")
    @Expose
    var capital:String,

    @SerializedName("region")
    @Expose
    var region:String,

    @SerializedName("currency")
    @Expose
    var currency:String,

    @SerializedName("flag")
    @Expose
    var flag:String,

    @SerializedName("language")
    @Expose
    var language:String,




)
