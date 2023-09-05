package com.sezer.currencyapp.ViewModel



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewmodel.compose.viewModel


class MainScreenViewModel:ViewModel() {

    var flags = mutableMapOf<Int, String>()

    var result = MutableLiveData<Double>()


    init {
        flags[2130968577] = "euro"
        flags[2130968600] = "dollar"
        flags[2130968599] =  "tl"
        flags[2130968598] =  "pln"
        result.value =0.0
        println(flags.values)
    }

    fun CalculateCurreny(num: String, image_selected1: Int, image_selected2: Int)
    {



        println("Para birimi : "
                +GetCurrencyViewModel.paralar[flags[2130968577]])
        println(flags[image_selected1])

        println("hesapla ${image_selected1} ve ${image_selected2}")

        result.value=  GetCurrencyViewModel.paralar[flags[image_selected2]]!!
            .toDouble()/GetCurrencyViewModel.paralar[flags[image_selected1]]!!
            .toDouble()* num.toDouble()

    }


}



