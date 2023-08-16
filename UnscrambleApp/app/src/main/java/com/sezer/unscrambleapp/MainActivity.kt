package com.sezer.unscrambleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            CardOlustur()
        }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardOlustur()
{
    var yazi by remember {
        mutableStateOf("")
    }
    Column (){
        Text(text ="Unscramble App Practice")
        Card( )
        {
            Text(text = "Your Score is: ")
            Text(text = "sezer")
            TextField(value = yazi, onValueChange ={yazi = it} ,
                label ={ Text(text = "Enter your word")} )

        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Submit")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Skip")
        }
    }


}



