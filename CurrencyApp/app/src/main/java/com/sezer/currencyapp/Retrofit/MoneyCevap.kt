package com.sezer.currencyapp.Retrofit
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


data class MoneyCevap(


    @SerializedName("success")
    @Expose
    var success : Boolean,

    @SerializedName("timestamp")
    @Expose
    var timestamp : Long,

    @SerializedName("base")
    @Expose
    var base : String,

    @SerializedName("date")
    @Expose
    var date : String,

    @SerializedName("rates")
    @Expose
    var rates : MoneyData

)