package com.example.Disney02.roomDb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.Disney02.model.DataUsed

@Database(entities = [DataUsed::class], version = 1)
abstract class RoomApp :RoomDatabase() {
    abstract fun deo():RoomDao
companion object {
    private var INSTANCE : RoomApp? = null
    fun getDataBase(context: Context):RoomApp{
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                context,
                RoomApp::class.java,
                "RoomInfo"
            ).build()
        }
        return INSTANCE!!
    }


}

}