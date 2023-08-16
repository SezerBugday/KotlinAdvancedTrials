package com.sezer.room
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity (tableName = "Kisiler")
class KisilerSinifi (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") @NotNull var id: Int,
               @ColumnInfo(name = "isim") @NotNull var isim: String,
               @ColumnInfo(name = "no") @NotNull var tel : Int
    )
{

}

// Veritabanımızda yer alan her bir tablo için bir entity ve bu şekilde bir
// sinif olusturmamız gerekiyor