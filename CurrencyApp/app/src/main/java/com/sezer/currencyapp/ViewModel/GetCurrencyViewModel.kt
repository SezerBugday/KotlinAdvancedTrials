package com.sezer.currencyapp.ViewModel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sezer.currencyapp.Retrofit.ApiUtils
import com.sezer.currencyapp.Retrofit.MoneyData
import com.sezer.currencyapp.View.MainScreen
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object GetCurrencyViewModel:ViewModel() {
    var paralar = mutableMapOf<String, Double>()

    var IsSuccess = MutableLiveData<Boolean>()


    init {
    IsSuccess.value = false

    }

    fun GetCurency(): MutableMap<String,Double>
    {

        val MoneyDaoInterface = ApiUtils.GetMoneyDaoInterface()

        MoneyDaoInterface.VeriGetir().enqueue(object : Callback<List<MoneyData>>   {
            override fun onResponse(call: Call<List<MoneyData>>, response: Response<List<MoneyData>>) {
                val dataList = response.body()
                if (dataList != null) {

                    IsSuccess.value= true


                    paralar["euro"] = dataList[0].Value
                    paralar["tl"] = dataList[1].Value
                    paralar["pln"] = dataList[8].Value
                    paralar["dollar"] = 1.toDouble()
                   var turkish = "%.3f".format(dataList[1].Value)

                    println("${paralar["euro"]} ${  turkish}")


                }

                else {
                    // Hata durumunu işleyin
                }
            }

            override fun onFailure(call: Call<List<MoneyData>>?, t: Throwable?) {
                println("Başarısız: ${t?.localizedMessage}")
                IsSuccess.value= false
            }
        })


        return  paralar

    }
}




