package com.example.androidexam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidexam.Interface.DetailsActivityContract
import com.example.androidexam.presenter.DetailsActivityPresenter
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity(), DetailsActivityContract.View {

    private var mPresenter: DetailsActivityContract.Presenter?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        mPresenter = DetailsActivityPresenter(this)

        (mPresenter as DetailsActivityPresenter).setPosition(intent.extras?.getInt("position")!!)

    }

    override fun showPersonInfo(fName: String, lName: String, age: String, email: String,
        address: String, mobile: String, bday: String, contactP: String, contactPNum: String
    ) {
        tvFName.text = fName
        tvLName.text = lName
        tvAge.text = age
        tvEmail.text = email
        tvAddress.text = address
        tvMobile.text = mobile
        tvBday.text = bday
        tvContactP.text = contactP
        tvContactPNum.text = contactPNum
    }
}