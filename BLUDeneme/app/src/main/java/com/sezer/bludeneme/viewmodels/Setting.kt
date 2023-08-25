package com.sezer.bludeneme.viewmodels


import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController

import com.sezer.bludeneme.MainActivity


class Setting {

    @Composable
    fun SettingPage(navController:NavController)
    {



        Column {
            Button(onClick = {
                navController.navigate("start_bluetooh")


            }) {
                Text(text = "Start Bluetooth")
            }
            Button(onClick = {

            })

            {
                Text(text = "Start Push Notification")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Start Vibration")
            }
        }


    }

}