package com.sezer.currencyapp

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.sezer.currencyapp.ui.theme.CurrencyAppTheme
import com.sezer.currencyapp.View.MainScreen
import com.sezer.currencyapp.ViewModel.GetCurrencyViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CurrencyAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LaunchedEffect(key1 = true )
                    {
                       GetCurrencyViewModel.GetCurency()
                    }

                    //GetCurrencyViewModel().GetCurency()
                    MainScreen().ShowCurrency()

                }
            }
        }
    }
}










