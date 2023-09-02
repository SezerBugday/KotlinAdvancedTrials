package com.sezer.currencyapp.Retrofit
import com.sezer.currencyapp.Retrofit.MoneyCevap
import retrofit2.Call
import retrofit2.http.GET

interface MoneyDaoInterface {
    @GET("latest?access_key=91a9127dddc59928e233f3e3863a1c5f&format=1")
    fun VeriGetir():Call<MoneyCevap>

}
