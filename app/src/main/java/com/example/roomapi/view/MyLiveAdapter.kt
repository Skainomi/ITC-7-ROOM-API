package com.example.roomapi.view

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.roomapi.database.model.LiveEntity
import com.example.roomapi.databinding.LiveNowItemBinding

class MyLiveAdapter(private var dataLive : List<LiveEntity>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AdapterViewHolder(LiveNowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AdapterViewHolder){
            holder.onBind(dataLive[position])
        }
    }

    override fun getItemCount(): Int {
        return dataLive.size
    }

    class AdapterViewHolder constructor(
        private val binding : LiveNowItemBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun onBind(liveEntity: LiveEntity){
            binding.tvTitle.text = liveEntity.title
            var img = liveEntity.thumbnail
            if (img == null){
                img = liveEntity.channelPhoto
            }
            binding.tvChannel.text = liveEntity.channel
            Glide.with(itemView.context)
                .load(img)
                .into(binding.ivThumbnail)
            binding.root.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + liveEntity.ytVideoKey))
                itemView.context.startActivity(intent)
            };
        }

    }


}