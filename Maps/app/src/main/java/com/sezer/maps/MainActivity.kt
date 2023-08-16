package com.sezer.maps

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
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
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.sezer.maps.ui.theme.MapsTheme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoApp ()
        }
    }


}




@Composable
fun ComposeDemoApp() {
    val ankara = LatLng(39.90902 , 32.9025 )
    val place2 = LatLng(65.90902 , 13.9025 )
    val place3 = LatLng(67.90902 , 65.9025 )


     val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(ankara, 15f)
    }


    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = ankara),
            title = "London",
            snippet = "Marker in Big Ben"
        )
        Marker(
            state = MarkerState(position = place2),
            title = "London",
            snippet = "Marker in Big Ben"
        )
        Marker(
            state = MarkerState(position = place3),
            title = "London",
            snippet = "Marker in Big Ben"
        )
    }



}


