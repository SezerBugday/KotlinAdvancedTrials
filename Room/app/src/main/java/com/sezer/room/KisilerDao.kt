package com.sezer.room
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface KisilerDao {
    @Query("Select * From Kisiler")
    suspend fun tumKisiler(): List<KisilerSinifi>

    @Insert()
    suspend fun AddKisi(kisi:KisilerSinifi)

    @Update()
    suspend fun KisiGuncelle(kisi:KisilerSinifi)

    @Delete()
    suspend fun KisiSil(kisi:KisilerSinifi)

    @Query("Select * From Kisiler order by Random() limit 1")
    // veritabanından rastgele birini getir
    suspend fun RasgeleGetir(): List<KisilerSinifi>

    @Query("Select * From Kisiler where isim like '%' ||:aranacakKelime || '%'")
    // Liste icinde ara
    suspend fun AramaYap(aranacakKelime:String): List<KisilerSinifi>


    @Query("Select * From Kisiler where id = :id")
    // Tek bir kisi getir
    suspend fun KisiGetir(id:Int): KisilerSinifi

    @Query("Select Count(*) From Kisiler where isim = :kisiad")
    //Kosulu saglayan kac kisi var bakıyoruz
    // buyuk- kucuk harf hassasiyeti var
    suspend fun KayitKontrol(kisiad:String): Int
}