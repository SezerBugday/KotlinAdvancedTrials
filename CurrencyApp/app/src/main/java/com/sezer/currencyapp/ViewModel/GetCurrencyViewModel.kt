package com.sezer.currencyapp.ViewModel


import androidx.lifecycle.ViewModel
import com.sezer.currencyapp.Retrofit.ApiUtils
import com.sezer.currencyapp.Retrofit.MoneyCevap
import com.sezer.currencyapp.Retrofit.MoneyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GetCurrencyViewModel:ViewModel() {
    var paralar = mutableMapOf<String, Double>()
    var IsSuccess = false

    fun GetCurency(): MutableMap<String,Double>
    {

        val MoneyDaoInterface = ApiUtils.GetMoneyDaoInterface()

        MoneyDaoInterface.VeriGetir().enqueue(object : Callback<MoneyCevap> {
            override fun onResponse(call: Call<MoneyCevap>, response: Response<MoneyCevap>) {
                IsSuccess = true
              var liste = response.body()!!.rates

                paralar["euro"] = liste.euro.toDouble()
                paralar["dollar"] = liste.dolar.toDouble()
                paralar["tl"] = liste.turkishLira.toDouble()
                paralar["pln"] = liste.zloty.toDouble()
                println(
                    "${paralar["euro"]}," +
                            "${paralar["dollar"]}," +
                            "${paralar["tl"]}," +
                            "${paralar["pln"]}, "
                )
            }

            override fun onFailure(call: Call<MoneyCevap>?, t: Throwable?) {
                println("Başarısız: ${t?.localizedMessage}")
                IsSuccess= false
            }
        })


        return  paralar

    }
}