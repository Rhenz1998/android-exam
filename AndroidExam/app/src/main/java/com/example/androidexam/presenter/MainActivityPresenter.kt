package com.example.androidexam.presenter

import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.example.androidexam.adapter.PeopleAdapter
import com.example.androidexam.Interface.MainActivityContract
import com.example.androidexam.model.People
import com.example.androidexam.utils.Singleton
import com.example.androidexam.api.Api
import com.example.androidexam.api.RetrofitService
import com.example.androidexam.utils.TinyDB
import retrofit2.Call
import retrofit2.Response

class MainActivityPresenter(view : MainActivityContract.View): MainActivityContract.Presenter {

    private var mView : MainActivityContract.View = view
    private lateinit var mService: RetrofitService
    lateinit var adapter: PeopleAdapter

    override fun callService() {
        mService = Api.retrofitService
        mView.showDialog()

        mService.getPeople().enqueue(object : retrofit2.Callback<ArrayList<People>>
        {
            override fun onFailure(p0: Call<ArrayList<People>>?, p1: Throwable?) {
                Log.d("Error",p0.toString() +"Throwable"+ p1.toString())
            }

            override fun onResponse(call: Call<ArrayList<People>>?, response: Response<ArrayList<People>>?
            ) {
                Singleton.peopleResponse = response?.body()!!
                mView.showData()
                mView.dismissDialog()
            }
        })

    }



}