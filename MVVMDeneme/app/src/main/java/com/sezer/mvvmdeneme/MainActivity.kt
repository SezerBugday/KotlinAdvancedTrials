package com.sezer.mvvmdeneme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sezer.mvvmdeneme.ui.theme.MVVMDenemeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMDenemeTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen()
{
    var viewModelim : SayfaViewModel = viewModel()

    var sayi1 by remember {
        mutableStateOf("")
    }
    var sayi2 by remember {
        mutableStateOf("")
    }
    var sonuc = viewModelim.sonuc.observeAsState(0)

    Column {
            Text(text = sonuc.value.toString())
            TextField(value = sayi1, onValueChange ={sayi1 = it } )
            TextField(value = sayi2, onValueChange ={sayi2=it} )


            Button(onClick = {viewModelim.Topla(sayi1,sayi2)



            }) {

                Text(text = "Topla")
            }
            Button(onClick = { viewModelim.Carp(sayi1,sayi2)


            }) {

                Text(text = "Carp")
            }
        }



}