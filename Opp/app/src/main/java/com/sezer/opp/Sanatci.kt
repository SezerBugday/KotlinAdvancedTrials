package com.sezer.opp

open class Sanatci(isim:String, yas:Int, meslek:String) {

    var name:String? = isim
        get         // get yapısı aynı dısardan erisilebilir
        private set
    var age: Int? = yas
        get  //dısardan hem okunabilir hem degistirileblir
        set

    var job: String? = meslek
}