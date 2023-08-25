package com.sezer.bludeneme.viewmodels



import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.sezer.bludeneme.data.My_Database
import com.sezer.bludeneme.data.Users

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

import kotlinx.coroutines.launch


class Profil {
    @Composable
    fun ProfilGoster() {
        val context = LocalContext.current
        var vt = My_Database.VeriTabaniErisim(context)

        var IsMan by remember {mutableStateOf(0) }
        var IsLookingForMan by remember {mutableStateOf(0) }
        var FriendsToTalk by remember {mutableStateOf(0) }
        var LongRelationsship by remember {mutableStateOf(0) }
        var TouristInTown by remember {mutableStateOf(0) }
        var JustSexualIntentions by remember {mutableStateOf(0) }
        LaunchedEffect(key1 = true   )
        {
            println("Lauch Efect calisti")
          if(  (vt?.kisilerDao()?.KayitKontrol()) == 0)
          {
              val job : Job = CoroutineScope(Dispatchers.Main).launch {
                  val yeniKisi = Users(1, IsMan ,IsLookingForMan,FriendsToTalk,
                      LongRelationsship,TouristInTown,JustSexualIntentions)
                  vt.kisilerDao().AddKisi(yeniKisi)
                 println("kisi olusturuldu")
              }
          }


            if (vt != null) {
                println("db is not null")
                val job: Job = CoroutineScope(Dispatchers.Main).launch {
                    val liste = vt.kisilerDao().tumKisiler()
                    for (a in liste) {
                        IsMan = a.IsMan
                        IsLookingForMan = a.IsLookingForMan
                        FriendsToTalk = a.FriendsToTalk
                        LongRelationsship = a.LongRelationsship
                        TouristInTown = a.TouristInTown
                        JustSexualIntentions = a.JustSexualIntentions
                    }
                }
            }

        }


        Column {

            var kart = Column {
                    Text(text = "I am a :")
                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(8.dp)
                        .background(if (IsMan==1) Color.Blue else Color.Gray)
                        .clickable {
                            if(IsMan == 0)
                            {
                                IsMan =1
                            }
                            else
                            {
                                IsMan =0
                            }

                        }
                ) {
                    Text(
                        text = if (IsMan==1) "Man" else "Woman",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                }
            var kart2 = Column {
                Text(text = "I am looking for : :")
                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(8.dp)
                        .background(if (IsLookingForMan==1) Color.Blue else Color.Gray)
                        .clickable {
                            if(IsLookingForMan == 0)
                            {
                                IsLookingForMan =1
                            }
                            else
                            {
                                IsLookingForMan =0
                            }
                        }
                ) {
                    Text(
                        text = if (IsLookingForMan==1) "Man" else "Woman",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            var kart3 = Column {
                Text(text = "Friends to talk :")
                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(8.dp)
                        .background(if (FriendsToTalk==1) Color.Blue else Color.Gray)
                        .clickable {
                            if(FriendsToTalk == 0)
                            {
                                FriendsToTalk =1
                            }
                            else
                            {
                                FriendsToTalk =0
                            }
                        }
                ) {
                    Text(

                        text = if (FriendsToTalk==1) "On" else "Off",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            var kart4 = Column {
                Text(text = "Long Relations ship :")
                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(8.dp)
                        .background(if (LongRelationsship==1) Color.Blue else Color.Gray)
                        .clickable {
                            if(LongRelationsship == 0)
                            {
                                LongRelationsship =1
                            }
                            else
                            {
                                LongRelationsship =0
                            }
                        }
                ) {
                    Text(

                        text = if (LongRelationsship==1) "On" else "Off",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            var kart5 = Column {
                Text(text = "Tourist In Town :")
                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(8.dp)
                        .background(if (TouristInTown==1) Color.Blue else Color.Gray)
                        .clickable {
                            if(TouristInTown == 0)
                            {
                                TouristInTown =1
                            }
                            else
                            {
                                TouristInTown =0
                            }
                        }
                ) {
                    Text(

                        text = if (TouristInTown==1) "On" else "Off",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            var kart6 = Column {
                Text(text = "Just Sexual Intentions:")
                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(50.dp))
                        .padding(8.dp)
                        .background(if (JustSexualIntentions==1) Color.Blue else Color.Gray)
                        .clickable {
                            if(JustSexualIntentions == 0)
                            {
                                JustSexualIntentions =1
                            }
                            else
                            {
                                JustSexualIntentions =0
                            }
                        }
                ) {
                    Text(

                        text = if (JustSexualIntentions==1) "On" else "Off",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }

            Button(onClick = { KisiUpdate(vt!!,IsMan,IsLookingForMan,
                FriendsToTalk,LongRelationsship,TouristInTown,
                JustSexualIntentions,context)


            }) {
                Text(text = "Save")
            }

            }

    }
    fun KisiUpdate(

        vt: My_Database,
        IsMan: Int,
        IsLookingForMan: Int,
        FriendsToTalk: Int,
        LongRelationsship: Int,
        TouristInTown: Int,
        JustSexualIntentions: Int,
        context: Context
    )
    {

        val job : Job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Users(1, IsMan ,IsLookingForMan,FriendsToTalk,
                LongRelationsship,TouristInTown,JustSexualIntentions)
            vt.kisilerDao().KisiGuncelle(yeniKisi)
            Toast.makeText(context,"database updated",Toast.LENGTH_SHORT).show()
        }
    }


}