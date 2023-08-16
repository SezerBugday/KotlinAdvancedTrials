package com.sezer.mvvmdeneme

import androidx.lifecycle.MutableLiveData

class RepoDeneme {
    var sonucum_repo = MutableLiveData<Int>()

    fun SonucGetir() : MutableLiveData<Int> {
        return sonucum_repo
    }

    fun ToplaIslemi(a :String, b:String)
    {

        var sayi1 = a.toInt()
        var sayi2 = b.toInt()
        sonucum_repo.value = sayi2+sayi1

    }
    fun CarpIslemi(a :String, b:String)
    {
        var sayi1 = a.toInt()
        var sayi2 = b.toInt()
        sonucum_repo.value = sayi2*sayi1
    }
}