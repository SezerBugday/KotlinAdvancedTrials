package com.sezer.bludeneme

import android.Manifest
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.bluetooth.BluetoothAdapter
import android.content.Context
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.sezer.bludeneme.WorkManager.MyWorker
import com.sezer.bludeneme.viewmodels.Profil
import com.sezer.bludeneme.bluetooth.ChatServer
import com.sezer.bludeneme.presentation.ChatCompose
import com.sezer.bludeneme.presentation.DeviceScanCompose
import com.sezer.bludeneme.states.DeviceConnectionState
import com.sezer.bludeneme.viewmodels.DeviceScanViewModel
import com.sezer.bludeneme.viewmodels.Setting

private const val TAG = "MainActivityTAG"

class MainActivity : ComponentActivity() {

   lateinit var result: MutableState<Int?>
    lateinit var launcher: ManagedActivityResultLauncher<Intent, ActivityResult>


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

@Composable
    fun StartBluetooth() {

        LaunchedEffect(key1 = true )
        {
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
             StartScanDevices()
        }
    @Composable
    fun StartScanDevices()
    {
        LaunchedEffect(key1 = result.value){
            if(result.value == RESULT_OK){
                ChatServer.startServer(application)
                viewModel.startScan()
            }
        }






            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)

            ) {
                val deviceScanningState by viewModel.viewState.observeAsState()

                val deviceConnectionState by ChatServer.deviceConnection.observeAsState()

                var isChatOpen by remember {
                    mutableStateOf(false)
                }

                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier.fillMaxSize()
                ) {
                    if (deviceScanningState != null && !isChatOpen || deviceConnectionState == DeviceConnectionState.Disconnected) {
                        Column {
                            Text(
                                text = "Choose a device to chat with:",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            DeviceScanCompose.DeviceScan(deviceScanViewState = deviceScanningState!!) {
                                isChatOpen = true
                            }
                        }

                    }
                    else if (deviceScanningState != null && deviceConnectionState is DeviceConnectionState.Connected)
                    {

                        BlidirimOlustur(LocalContext.current)
                        //cihaz listelendikten sonra cihaz adına tıklarsak bildirim geliyor 
                        ChatCompose.Chats((deviceConnectionState as DeviceConnectionState.Connected).device.name)
                    }
                    else
                    {
                        Text(text = "Nothing")
                    }
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
                .setSmallIcon(R.drawable.baseline_add_reaction_24)
                .setAutoCancel(true) // bildirime tıklanınca bildirim yok olsun
            println("Bildirim olusutur icindeyiz")
        } else {
            builder = NotificationCompat.Builder(context)
            builder.setContentTitle("Yeni Bildirim")
                .setContentText("Bu bir bidirimdir. Bildirime tikla")
                .setSmallIcon(R.drawable.baseline_add_reaction_24)
                .setAutoCancel(true) // bildirime tıklanınca bildirim yok olsun
                .priority = Notification.PRIORITY_HIGH
        }
        bidirimYoneticisi.notify(1, builder.build())
    }



    }












