package com.example.androidexam.api

import com.example.androidexam.model.People
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("v3/10f51cb5-10b6-44ea-9487-8fa8259e82c8")
    fun getPeople() : Call<ArrayList<People>>

}