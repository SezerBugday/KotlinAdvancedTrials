package com.sezer.currencyapp.Retrofit
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
data class MoneyData(


    @SerializedName("Name")
                          @Expose
                          var Name:String,

                          @SerializedName("Base")
                          @Expose
                          var Base :String,

                          @SerializedName("Value")
                          @Expose
                          var Value:Double



)