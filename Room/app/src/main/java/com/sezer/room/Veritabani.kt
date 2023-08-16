package com.sezer.room
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [KisilerSinifi::class], version = 1) // birden fazla tablo varsa,
//entities = [KisilerSinifi::class,DigerTablo::class] seklinde kullanılabilir

abstract class Veritabanim:RoomDatabase()
{

    abstract fun kisilerDao() : KisilerDao

    companion object
    {
        var instance : Veritabanim? = null

        fun VeriTabaniErisim(context: Context):Veritabanim?
        {
            if(instance == null)
            {
                synchronized(Veritabanim::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Veritabanim::class.java,
                        "rehber.db").createFromAsset("rehber.db").build()

                }
            }
            return  instance
        }

    }
}