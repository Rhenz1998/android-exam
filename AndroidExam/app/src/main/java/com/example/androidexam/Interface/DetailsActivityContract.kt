package com.example.androidexam.Interface

interface DetailsActivityContract {

    interface View
    {
        fun showPersonInfo(fName: String,lName: String,age: String, email: String, address: String,
                           mobile: String, bday: String, contactP: String, contactPNum : String)
    }

    interface Presenter
    {
        fun setPosition(pos : Int)
    }
}