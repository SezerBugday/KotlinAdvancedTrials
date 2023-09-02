package com.sezer.currencyapp.Retrofit
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
data class MoneyData (


    @SerializedName("EUR")
                          @Expose
                          var euro:String,

                          @SerializedName("TRY")
                          @Expose
                          var turkishLira :String,

                          @SerializedName("PLN")
                          @Expose
                          var zloty:String,

                          @SerializedName("USD")
                          @Expose
                          var dolar:String

)