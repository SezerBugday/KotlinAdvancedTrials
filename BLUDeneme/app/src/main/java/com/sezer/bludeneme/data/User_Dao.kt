package com.sezer.bludeneme.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface User_Dao {
    @Query("Select * From user_table")
    suspend fun tumKisiler(): List<Users>

    @Insert()
    suspend fun AddKisi(lisi:Users)


    @Update()
    suspend fun KisiGuncelle(kisi:Users)


    @Query("Select Count(*) From user_table")
    //Kosulu saglayan kac kisi var bakıyoruz
    // buyuk- kucuk harf hassasiyeti var
    suspend fun KayitKontrol():Int




}