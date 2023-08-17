package com.sezer.workmanager

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.NotificationCompat
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.sezer.workmanager.ui.theme.WorkManagerTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WorkManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnaSayfa()
                }
            }
        }
    }


    @Composable
    fun AnaSayfa() {
        val context = LocalContext.current
        Column {
            Button(onClick = { BlidirimOlustur(context) }) {
                Text(text = "Bildirim Gonder")
            }

            Button(onClick = { AnlikBirKere(context) }) {
                Text(text = "Anlık bir kere")
            }
            Button(onClick = { BirKereGecikmeli(context) }) {
                Text(text = "Gecikmeli bir kere")
            }
            Button(onClick = { KosulluBirKereGecikmeli(context) }) {
                Text(text = "Kosullu Gecikmeli bir kere")
            }
            Button(onClick = { PeriyodikIstek(context) }) {
                Text(text = "Periyodik istek")
            }
        }
    }

    fun BlidirimOlustur(context: Context) {

        val builder: NotificationCompat.Builder
        val bidirimYoneticisi =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) //app in çalıstıgı sistem oreo sürümünden yeni mi diye kontrol ediyoruz
        {
            val kanalId = "kanalId"
            val kanalAd = "kanalAd"
            val kanalTanitim = "kanalTanitim"
            val kanalOncelik = NotificationManager.IMPORTANCE_HIGH

            var kanal: NotificationChannel? = bidirimYoneticisi.getNotificationChannel(kanalId)
            if (kanal == null) {
                kanal = NotificationChannel(kanalId, kanalAd, kanalOncelik)
                kanal.description = kanalTanitim
                bidirimYoneticisi.createNotificationChannel(kanal)

            }

            builder = NotificationCompat.Builder(context, kanalId)
            builder.setContentTitle("Yeni Bildirim")
                .setContentText("Bu bir bidirimdir. Bildirime tikla")
                .setSmallIcon(R.drawable.resim)
                .setAutoCancel(true) // bildirime tıklanınca bildirim yok olsun
            println("Bildirim olusutur icindeyiz")
        } else {
            builder = NotificationCompat.Builder(context)
            builder.setContentTitle("Yeni Bildirim")
                .setContentText("Bu bir bidirimdir. Bildirime tikla")
                .setSmallIcon(R.drawable.resim)
                .setAutoCancel(true) // bildirime tıklanınca bildirim yok olsun
                .priority = Notification.PRIORITY_HIGH
        }
        bidirimYoneticisi.notify(1, builder.build())
    }

    fun AnlikBirKere(context: Context) {
        // burdaki işteği anlık ve bir kerelik yap
        val istek = OneTimeWorkRequestBuilder<MyWorker>().build()

        WorkManager.getInstance(context).enqueue(istek)

    }

    fun BirKereGecikmeli(context: Context) {
        // burdaki işteği 3 sn sonra ve bir kerelik yap
        val istek = OneTimeWorkRequestBuilder<MyWorker>()
            .setInitialDelay(3, TimeUnit.SECONDS)
            .build()
        WorkManager.getInstance(context).enqueue(istek)
    }

    fun KosulluBirKereGecikmeli(context: Context) {
        val CalismaKosulu = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        // burdaki işteği 3 sn sonra olusturur fakat internete baglanma kosulu ,
        // eklediğimiz için internete bağlanana kadar uygulama işemi yapmaz.
        //Yani 3sn geçer
        val istek = OneTimeWorkRequestBuilder<MyWorker>()
            .setInitialDelay(3, TimeUnit.SECONDS)
            .setConstraints(CalismaKosulu)
            .build()
        WorkManager.getInstance(context).enqueue(istek)
    }

    fun PeriyodikIstek(context: Context) {
        //istediği periyodik olarak çağırma süresi min 15 dk olmalıdır.

        val istek = PeriodicWorkRequestBuilder<MyWorkerBildirimGonder>(15, TimeUnit.MINUTES)
            .setInitialDelay(3, TimeUnit.SECONDS) // isteği ilk oluşturma süresi kendmize kalmış
            .build()
        WorkManager.getInstance(context).enqueue(istek)
    }

    fun yazdir()
    {
        println("yazdirrrrrrrr")
    }
}