package com.example.roomapi.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.roomapi.hololive.api.model.Channel

@Entity(tableName = "live_schedule")
class LiveEntity {
    companion object{
        const val TABLE_NAME = "live_schedule"
    }

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
    @ColumnInfo(name = "title")
    var title: String? = null
    @ColumnInfo(name = "channel")
    var channel: String? = null
    @ColumnInfo(name = "thumbnail")
    var thumbnail: String? = null
    @ColumnInfo(name = "yt_video_key")
    var ytVideoKey: String? = null
    @ColumnInfo(name = "channel_photo")
    var channelPhoto: String? = null


    fun setDataAutoId(title : String?, channel : Channel?, thumbnail : String?, ytKey : String?){
        this.title = title
        this.channel = channel?.name
        this.channelPhoto = channel?.photo
        this.thumbnail = thumbnail
        this.ytVideoKey = ytKey
    }


}