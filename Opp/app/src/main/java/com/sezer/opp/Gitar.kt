package com.sezer.opp

class Gitar(override var hangi_oda: String, override var EnstrumanTur: String) : Enstruman,Dekor { // Normalde sınıflar sadece bir sınıftan kalıtım alabilr.
// Birden fazla yerden kalıtım yapmak istiyorsak parentları interface olmalı.

    var marka: String? =null

}