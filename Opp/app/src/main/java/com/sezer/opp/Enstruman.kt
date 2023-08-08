package com.sezer.opp

interface Enstruman {
    var EnstrumanTur: String // sınıflarda ve abstraclarda bu izin verilen bir kullanım değil.
// interfaceler buna izi veriyor
    fun EnstrumanCal() //fonskiyonu bu sekide bırakabiliyoruz
    {
        println("Enstruman interface'indeyiz")
    }
}