package com.sezer.opp

class Islemler {
    // aynı isimde farklı parametreler alan fonksiyonlar oluşturabiliyoruz
    fun Carpma() : Int
    {
        return 0
    }
    fun Carpma(a:Int,b:Int) : Int
    {
        return a*b
    }
    fun Carpma(a:Int,b:Int,c:Int) : Int
    {
        return a*b*c
    }
}