package com.sezer.opp

class Kullanici : Insan { //insan soyut sınıfından kalıtım alıyoruz
    var isim: String? = null
    var yas: Int? = null
    constructor(name:String,age:Int)
    {
        println("Constructor Cagirildi")
        isim = name
        yas= age
    }
    init {
        println("init cagirildi") // init yapısı he robje olustugunda cagirilir ve consractor dan önce çağırılır
    }

}