package com.example.androidexam.Interface

import com.example.androidexam.model.People

interface MainActivityContract {

    interface View
    {
        fun showData()
        fun showDialog()
        fun dismissDialog()

    }

    interface Presenter
    {
        fun callService()
    }

}