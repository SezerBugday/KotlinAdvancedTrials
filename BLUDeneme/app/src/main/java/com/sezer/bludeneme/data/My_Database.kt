package com.sezer.bludeneme.data
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Users::class], version = 1)
abstract class My_Database:RoomDatabase()
{

    abstract fun kisilerDao() : User_Dao

    companion object
    {
        var instance : My_Database? = null

        fun VeriTabaniErisim(context: Context):My_Database?
        {
            if(instance == null)
            {
                synchronized(My_Database::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        My_Database::class.java,
                        "user.db").createFromAsset("user.db").build()

                }
            }
            return  instance
        }

    }
}