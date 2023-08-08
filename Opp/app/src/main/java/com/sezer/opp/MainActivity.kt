package com.sezer.opp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sezer.opp.ui.theme.OppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

              println("----------Sınıflar-------------")
           val user1 = Kullanici("sezer",25)

            println("----------Encapsulation-------------")
            val sezer  = Sanatci("sezer",25,"mühendis")
            println(sezer.name)

            println("----------Inheritance-------------")
           val super_olan = SuperSanatci("sezer",25,"sarkıcı")
            println(super_olan.name)
            super_olan.Ucabilme()
            println("----------Polimorphism-------------")

            // Static Polimorphism
          var  islem = Islemler()
                println(islem.Carpma())
            println(islem.Carpma(3,5))
            println(islem.Carpma(3,5,8))

            // Dynamic Polimorphism
           var kopek1 = KopekSinifi()
            var kedi1 = HayvanSinifi()

            kopek1.SesCikart()
            kedi1.SesCikart()
            kopek1.KopekFun()

            println("----------Abstract and interface-------------")

            // val human = Insan() Insan sinifi abstract olduğu için direkt erişemiyoruz.
        // Fakat bu sınıftan kalıtım alan bir sınıf aracılığıla soyut sınıf özelliklerine erişebiliriz

            var user2 = Kullanici("sezaer",25)
            user2.InsanFun()

           var gitar1 = Gitar("salon","Elekrogitar")
            gitar1.marka ="Toshiba"
            println(gitar1.marka)
            gitar1.EnstrumanCal()
           // Yukarıdaki örnekte entruman tur ve hangi_oda değişkenleri gitarın kalitim aldığı
            //Entruman ve Dekor interface'lerine ait

            println("----------Lamda Gosterimi Expression-------------")

            println(Yazdir("bu bir yazidir"))
            val YazdirLamda = { yaz:String -> println(yaz) }
            YazdirLamda("Lamda Test")

            val lamdaV1 = { a:Int, b:Int -> a*b}
            println(lamdaV1(3,5))

            val lamdaV2 : (Int,Int) -> Int = {a,b -> a*b}
            println(lamdaV2(3,5))
        }



    }

    fun Yazdir(yazi:String) : String
    {
        return yazi
    }
}

