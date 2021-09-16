package com.example.roomapi.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomapi.database.model.LiveEntity

@Database(entities = [LiveEntity::class], exportSchema = false, version = 1)
abstract class HololiveDB : RoomDatabase() {
    companion object{
        private var instance : HololiveDB? = null

        public fun getInstance(context: Context) : HololiveDB{
            if (instance == null){
                instance = Room.databaseBuilder(context, HololiveDB::class.java, "hololive_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return instance as HololiveDB
        }
    }

    abstract fun holoDao() : HololiveDao

}