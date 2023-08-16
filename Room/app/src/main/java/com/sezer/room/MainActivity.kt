package com.sezer.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.sezer.room.ui.theme.RoomTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Sayfa()
                }
            }
        }
    }
}



@Composable
fun Sayfa()
{
    val context = LocalContext.current
    var vt = Veritabanim.VeriTabaniErisim(context)

    Button(onClick = { KisiEkle(vt!!) }) {
        SideEffect {
            println("SideEfect calisti")
        }
    }
    LaunchedEffect(key1 = true   )
    {
        println("Lauch Efect calisti")
        if (vt != null) {
           //TumKisiler(vt)
            //RasgeleGelsin(vt)
           // Ara(vt)
            //TekkisiGetir(vt)
            KacKisiVar(vt)
        }
    }
}
fun TumKisiler(vt:Veritabanim)
{
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().tumKisiler()
        for (a in liste)
        {
            println(a.id)
            println(a.isim)
            println(a.tel)
        }
    }

}
fun KisiEkle(vt:Veritabanim)
{
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val yeniKisi = KisilerSinifi(0,"Deneme",55555)
        vt.kisilerDao().AddKisi(yeniKisi)

    }

}
fun KisiUpdate(vt:Veritabanim)
{
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val yeniKisi = KisilerSinifi(2,"YeniDeneme",55555)
        vt.kisilerDao().KisiGuncelle(yeniKisi)
    }
}
fun KisiDelete(vt:Veritabanim)
{
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val yeniKisi = KisilerSinifi(2,"",0)
        vt.kisilerDao().KisiSil(yeniKisi)
    }
}
fun RasgeleGelsin(vt:Veritabanim)
{
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().RasgeleGetir()
        for (a in liste)
        {
            println(a.id)
            println(a.isim)
            println(a.tel)
        }
    }

}
fun Ara(vt:Veritabanim)
{
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val liste = vt.kisilerDao().AramaYap("se")
        for (a in liste)
        {
            println(a.id)
            println(a.isim)
            println(a.tel)
        }
    }

}
fun TekkisiGetir(vt:Veritabanim)
{
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val kisi = vt.kisilerDao().KisiGetir(15)

        println(kisi.id)
        println(kisi.isim)
        println(kisi.tel)
    }

}
fun KacKisiVar(vt:Veritabanim)
{
    val job : Job = CoroutineScope(Dispatchers.Main).launch {
        val sonuc = vt.kisilerDao().KayitKontrol("Deneme")

        println("sonuc : ${sonuc}")
    }

}