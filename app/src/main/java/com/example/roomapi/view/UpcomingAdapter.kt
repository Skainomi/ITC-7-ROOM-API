package com.example.roomapi.view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roomapi.database.model.LiveEntity
import com.example.roomapi.databinding.UpcomingItemBinding
import com.example.roomapi.hololive.api.model.UpcomingItem

class UpcomingAdapter(private val dataLive : ArrayList<UpcomingItem>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AdapterViewHolder(UpcomingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AdapterViewHolder){
            holder.onBind(dataLive[position])
        }
    }

    override fun getItemCount(): Int {
        return dataLive.size
    }

    inner class AdapterViewHolder constructor(
        private val binding : UpcomingItemBinding
    ) : RecyclerView.ViewHolder(binding.root){


        fun onBind(upcomingItem: UpcomingItem){
            binding.tvTitle.text = upcomingItem.title
            var img = upcomingItem.thumbnail
            if (img == null){
                img = upcomingItem.channel?.photo
            }
            binding.tvChannel.text = upcomingItem.channel?.name
            Glide.with(itemView.context)
                .load(img)
                .into(binding.ivThumbnail)

            binding.root.setOnClickListener{
                val liveEntity = LiveEntity()
                liveEntity.setDataAutoId(upcomingItem.title, upcomingItem.channel, upcomingItem.thumbnail, upcomingItem.ytVideoKey)
                MainActivity.hololiveDB.holoDao().insertLiveData(liveEntity)
                Toast.makeText(it.context, "Item Ditambahkan", Toast.LENGTH_SHORT).show()
            }

        }

    }


}