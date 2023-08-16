package com.sezer.retrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sezer.retrofit.ui.theme.RetrofitTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchedEffect(key1 = true)
                    {
                        tumKisiler()
                    }

                }
            }
        }
    }
}

fun tumKisiler(){
    val kisilerDaoInterface = ApiUtils.GetUlkeDaoInterface()

    kisilerDaoInterface.VeriGetir().enqueue(object : Callback<UlkeCevap>{
        override fun onResponse(call: Call<UlkeCevap>, response: Response<UlkeCevap>) {
            val liste = response.body()!!.ulkeler

            for(k in liste){
                println(k.name)
            }
        }
        override fun onFailure(call: Call<UlkeCevap>?, t: Throwable?) {
            println("Başarısızzzz")
        }
    })
}




