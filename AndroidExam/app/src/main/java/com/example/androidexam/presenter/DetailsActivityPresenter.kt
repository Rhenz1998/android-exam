package com.example.androidexam.presenter

import android.os.Build
import com.example.androidexam.Interface.DetailsActivityContract
import com.example.androidexam.utils.Singleton
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.util.*

class DetailsActivityPresenter(view: DetailsActivityContract.View): DetailsActivityContract.Presenter {

    private var mView : DetailsActivityContract.View = view

    override fun setPosition(pos: Int) {
        val fName = Singleton.peopleResponse[pos].first_name
        val lName = Singleton.peopleResponse[pos].last_name
        val email = Singleton.peopleResponse[pos].email
        val address = Singleton.peopleResponse[pos].address
        val mobile = Singleton.peopleResponse[pos].mobile
        val bDay = Singleton.peopleResponse[pos].birthday
        val contactP = Singleton.peopleResponse[pos].contact_person
        val contactPNum = Singleton.peopleResponse[pos].contact_person_num
        val age = getAge(bDay).toString()

        mView.showPersonInfo(fName,lName,age,email,address,mobile,bDay,contactP,contactPNum)
    }

    fun getAge(bDay: String): Int
    {
        val format: Date = SimpleDateFormat("dd-MM-yyyy").parse(bDay)
        val today: Calendar = Calendar.getInstance()
        val dob : Calendar = Calendar.getInstance()
        dob.time = format

        val year: Int = dob.get(Calendar.YEAR)
        val month: Int = dob.get(Calendar.MONTH)
        val day: Int = dob.get(Calendar.DAY_OF_MONTH)
        var age:Int

        age = today.get(Calendar.YEAR) - year
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR))
        {
            age--
        }

        return age
    }



}