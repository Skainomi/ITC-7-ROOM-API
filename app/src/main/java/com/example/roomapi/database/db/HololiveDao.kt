package com.example.roomapi.database.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.roomapi.database.model.LiveEntity

@Dao
interface HololiveDao {
    @Query("SELECT * FROM ${LiveEntity.TABLE_NAME}")
    fun getAllLiveData() : List<LiveEntity>
    @Insert
    fun insertLiveData(item : LiveEntity)
    @Query("DELETE FROM ${LiveEntity.TABLE_NAME} WHERE title = :sTitle")
    fun deleteLiveData(sTitle : String)
}