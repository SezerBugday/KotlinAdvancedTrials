package com.sezer.currencyapp.View

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sezer.currencyapp.R
import com.sezer.currencyapp.ViewModel.GetCurrencyViewModel
import com.sezer.currencyapp.ViewModel.MainScreenViewModel

class MainScreen {
    @SuppressLint("SuspiciousIndentation")
    @Preview
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShowCurrency() {
        var viewModelim : MainScreenViewModel = viewModel()
        var viewModelCurrency: GetCurrencyViewModel = viewModel()


        var sonuc =viewModelim.result.observeAsState()

        /*
        if(viewModelCurrency.IsSuccess)
        {
            Toast.makeText(LocalContext.current,"Data Updated",Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(LocalContext.current,"Data Not Updated",Toast.LENGTH_SHORT).show()
        }
*/
        var input_one by remember { mutableStateOf(sonuc.value.toString()) }
        var mDisplayMenu1 by remember { mutableStateOf(false) }
        var mDisplayMenu2 by remember { mutableStateOf(false) }
        var image_selected1 by remember { mutableStateOf(R.drawable.tr_flag) }
        var image_selected2 by remember { mutableStateOf(R.drawable.gb_flag) }
        Column (modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp), // Düğmeler arasındaki boşluğu ayarlar
            horizontalAlignment = Alignment.CenterHorizontally ){

            TopAppBar(
                title = {   Text(text = "Currency App"
                    ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center))
                }
                ,

                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.red),
                    titleContentColor = colorResource(id = R.color.white),
                ),
                )

            Row {
                TextField(
                    value = input_one,
                    onValueChange = {
                            input_one =it
                           val deger = it.toIntOrNull()

                             if(deger!= null)
                             {
                                 viewModelim.CalculateCurreny(input_one,image_selected1,image_selected2)
                             }
                                else
                             {
                                 println("int değilll")
                             }
                            },
                    label = { Text(text = "Enter first number") })

                IconButton(onClick = { mDisplayMenu1 = !mDisplayMenu1 }) {
                    Image(painter = painterResource(id =  image_selected1!!), contentDescription ="" ,
                        modifier = Modifier
                            .fillMaxSize()
                            .size(width = 150.dp, height = 150.dp) )
                }
                DropdownMenu(
                    expanded = mDisplayMenu1,
                    onDismissRequest = { mDisplayMenu1 = false }
                ) {
                    DropdownMenuItem(
                        text = {},
                        onClick = { image_selected1 = R.drawable.tr_flag
                            viewModelim.CalculateCurreny(input_one,image_selected1,image_selected2)
                                  },
                        trailingIcon = {
                            Image(painter = painterResource(id =  R.drawable.tr_flag), contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 20.dp, height = 20.dp))
                        }
                    )
                    DropdownMenuItem(
                        text = {},
                        onClick = { image_selected1 = R.drawable.gb_flag},
                        trailingIcon = {
                            Image(painter = painterResource(id =  R.drawable.gb_flag), contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 20.dp, height = 20.dp))
                        }
                    )
                    DropdownMenuItem(
                        text = {},
                        onClick = { image_selected1 = R.drawable.us_flag
                            viewModelim.CalculateCurreny(input_one,image_selected1,image_selected2)
                                  },
                        trailingIcon = {
                            Image(painter = painterResource(id =  R.drawable.us_flag), contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 20.dp, height = 20.dp))
                        }
                    )
                    DropdownMenuItem(
                        text = {},
                        onClick = { image_selected1 = R.drawable.pl_flag},
                        trailingIcon = {
                            Image(painter = painterResource(id =  R.drawable.pl_flag), contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 20.dp, height = 20.dp))
                        }
                    )
                }

            }
            Row {


                TextField(
                    readOnly = true,
                            value = sonuc.value.toString(),
                    onValueChange = {  },
                    label = { Text(text = "Enter first number") }

                )

                IconButton(onClick = { mDisplayMenu2 = !mDisplayMenu2 }) {
                    Image(painter = painterResource(id =  image_selected2!!), contentDescription ="" ,
                        modifier = Modifier
                            .fillMaxSize()
                            .size(width = 150.dp, height = 150.dp) )
                }
                DropdownMenu(
                    expanded = mDisplayMenu2,
                    onDismissRequest = { mDisplayMenu2 = false }
                ) {
                    DropdownMenuItem(
                        text = {},
                        onClick = { image_selected2 = R.drawable.tr_flag},
                        trailingIcon = {
                            Image(painter = painterResource(id =  R.drawable.tr_flag), contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 20.dp, height = 20.dp))
                        }
                    )
                    DropdownMenuItem(
                        text = {},
                        onClick = { image_selected2 = R.drawable.gb_flag},
                        trailingIcon = {
                            Image(painter = painterResource(id =  R.drawable.gb_flag), contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 20.dp, height = 20.dp))
                        }
                    )
                    DropdownMenuItem(
                        text = {},
                        onClick = { image_selected2 = R.drawable.us_flag},
                        trailingIcon = {
                            Image(painter = painterResource(id =  R.drawable.us_flag), contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 20.dp, height = 20.dp))
                        }
                    )
                    DropdownMenuItem(
                        text = {},
                        onClick = { image_selected2 = R.drawable.pl_flag},
                        trailingIcon = {
                            Image(painter = painterResource(id =  R.drawable.pl_flag), contentDescription ="" ,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .size(width = 20.dp, height = 20.dp))
                        }
                    )
                }

            }

            LazyColumn(

            ) {

                this.items(5) { it ->
                    Row {
                        Image(modifier = Modifier

                            .size(50.dp),
                            painter = painterResource(id = R.drawable.gb_flag),
                            contentDescription ="" )
                        Text("/" , modifier = Modifier.size(20.dp))

                        Image(modifier = Modifier

                            .size(50.dp),
                            painter = painterResource(id = R.drawable.tr_flag),
                            contentDescription ="" )
                        Text("28.43345" , modifier = Modifier.size(20.dp))
                    }


                }
            }
        }
    }
}