package com.sezer.opp

class KopekSinifi: HayvanSinifi() {

    fun KopekFun()
    {
        super.SesCikart()  //super yapısı miras aldığı yeri referans alır
    // bu örnekte Hayvan sınıfının icindeki SesCikart fonlsiyonuna erişiyoruz
    }

   override fun SesCikart()
    {
        println("Kopek sinifi ses cikart calisti")
    }
}