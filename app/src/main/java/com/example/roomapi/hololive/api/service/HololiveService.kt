package com.example.roomapi.hololive.api.service

import android.util.Log
import com.example.roomapi.hololive.api.model.HololiveResponse
import com.example.roomapi.hololive.api.model.LiveItem
import com.example.roomapi.hololive.api.model.UpcomingItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HololiveService {
    var retrofit : Retrofit? = null

    fun getApi() : HololiveApi{
        if (retrofit == null){
            retrofit = Retrofit
                .Builder()
                .baseUrl(HololiveApi.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!.create(HololiveApi::class.java)
    }

    fun getLive(listener: HololiveListener<List<LiveItem>>){
        getApi().getHololiveApi().enqueue(object : Callback<HololiveResponse>{
            override fun onResponse(call: Call<HololiveResponse>, response: Response<HololiveResponse>){
                val data = response.body()
                if (data?.live != null){
                    listener.onSucces(data.live)
                }
            }
            override fun onFailure(call: Call<HololiveResponse>, e: Throwable) {
                Log.d("Failure API", "API Error : ${e.message}")
            }
        })
    }

    fun getSchedule(listener: HololiveListener<List<UpcomingItem>>){
        getApi().getHololiveApi().enqueue(object : Callback<HololiveResponse>{
            override fun onResponse(call: Call<HololiveResponse>, response: Response<HololiveResponse>){
                val data = response.body()
                if (data?.live != null){
                    listener.onSucces(data.upcoming)
                }
            }
            override fun onFailure(call: Call<HololiveResponse>, e: Throwable) {
                Log.d("Failure API", "API Error : ${e.message}")
            }
        })
    }





}