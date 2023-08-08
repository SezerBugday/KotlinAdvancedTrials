package com.sezer.opp

class SuperSanatci(isim: String, yas: Int, meslek: String) :
    Sanatci(isim, yas, meslek) // Sanatcı sınıfından kalıtım alıyoruz
// katılım alacağımız sınıf open class ibaresi ile başlamalı. Bu katılıma uygun demek

{
    fun Ucabilme()
    {
        println("super sanatci  ucuyor")
    }
}