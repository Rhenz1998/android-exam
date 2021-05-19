package com.example.androidexam.api

object Api {

    private val URL = "https://run.mocky.io/"

    val retrofitService : RetrofitService
        get() = RetrofitClient.getClient(URL).create(RetrofitService::class.java)
}