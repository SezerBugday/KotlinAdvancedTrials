package com.sezer.bludeneme

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.sezer.bludeneme.viewmodels.Profil
import com.sezer.bludeneme.bluetooth.ChatServer
import com.sezer.bludeneme.viewmodels.DeviceScanViewModel
import com.sezer.bludeneme.viewmodels.Setting

private const val TAG = "MainActivityTAG"

class MainActivity : ComponentActivity() {

   lateinit var result: MutableState<Int?>
    lateinit var launcher: ManagedActivityResultLauncher<Intent, ActivityResult>

    var BluetoothIsOpen = false
    private val viewModel: DeviceScanViewModel by viewModels()

    override fun onStop() {
        super.onStop()
        ChatServer.stopServer()
    }


    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
             result = remember { mutableStateOf<Int?>(100) }
             launcher = rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                result.value = it.resultCode
            }
              NavigateScreens()



            }

        }




    @Composable
    fun MainScreen(navController: NavController) {

        Column(
            modifier = Modifier.fillMaxWidth(),

            verticalArrangement = Arrangement.spacedBy(20.dp, Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(text = "TELEPATHY")
            Text(text = "")
            Button(onClick = { navController.navigate("go_profil") }) {
                Text(text = "Profile")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Looking For")
            }
            Button(onClick = { navController.navigate("go_setting") }) {
                Text(text = "Setting")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "About")
            }
            Button(onClick = { println("exite basildi") }) {
                Text(text = "Exit")
            }
        }
    }


    @Composable
    fun NavigateScreens() {
        val navControl = rememberNavController()

        NavHost(navController = navControl, startDestination = "main_screen")
        {
            composable("main_screen")
            {
                MainScreen(navControl)
            }
            composable("go_profil")
            {
                Profil().ProfilGoster()
            }
            composable("go_setting")
            {
                Setting().SettingPage(navControl)

            }
            composable("start_bluetooh")
            {

                StartBluetooth()
            }
        }

    }


    fun StartBluetooth() {
            Dexter.withContext(this@MainActivity)
                .withPermissions(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.BLUETOOTH_ADVERTISE,
                    Manifest.permission.BLUETOOTH_CONNECT,
                    Manifest.permission.BLUETOOTH_SCAN,
                    Manifest.permission.BLUETOOTH,
                    Manifest.permission.BLUETOOTH_ADMIN,
                )
                .withListener(object : MultiplePermissionsListener {
                    override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                        val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                        launcher.launch(intent)
                    }

                    override fun onPermissionRationaleShouldBeShown(
                        permissions: List<com.karumi.dexter.listener.PermissionRequest?>?,
                        token: PermissionToken?
                    ) {

                    }
                })
                .check()

        }


}










