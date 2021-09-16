package com.example.roomapi.hololive.api.service

interface HololiveListener <T> {
    fun <T> onSucces(items : T)
    fun <T> onFailed(msg : String)
}