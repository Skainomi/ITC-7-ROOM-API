package com.example.roomapi.hololive.api.service

import com.example.roomapi.hololive.api.model.HololiveResponse
import retrofit2.http.GET
import retrofit2.Call

interface HololiveApi {

    companion object{
        const val URL_BASE = "https://api.holotools.app/v1/"
    }

    @GET("live")
    fun getHololiveApi() : Call<HololiveResponse>

}