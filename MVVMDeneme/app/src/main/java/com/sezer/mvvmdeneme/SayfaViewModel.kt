package com.sezer.mvvmdeneme

import androidx.lifecycle.ViewModel

import androidx.lifecycle.MutableLiveData

class SayfaViewModel:ViewModel() {
    var sonuc = MutableLiveData<Int>()
    var mRepo = RepoDeneme()
    init {
        sonuc =mRepo.SonucGetir()
    }
    fun Topla(a :String, b:String)
    {
        mRepo.ToplaIslemi(a,b)

    }
    fun Carp(a :String, b:String)
    {
        mRepo.CarpIslemi(a,b)
    }
}