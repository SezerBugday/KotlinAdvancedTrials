package com.sezer.currencyapp.Retrofit
import com.sezer.currencyapp.Retrofit.MoneyCevap
import retrofit2.Call
import retrofit2.http.GET

interface MoneyDaoInterface {
    @GET("SezerBugday/KotlinAdvancedTrials/master/CurrencyApp/currencyData.json")
    fun VeriGetir():Call<List<MoneyData>>

}
