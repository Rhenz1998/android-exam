package com.example.androidexam

import android.content.Intent
import android.content.PeriodicSync
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidexam.adapter.PeopleAdapter
import com.example.androidexam.Interface.MainActivityContract
import com.example.androidexam.model.People
import com.example.androidexam.presenter.MainActivityPresenter
import com.example.androidexam.utils.Singleton
import com.example.androidexam.utils.TinyDB
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainActivityContract.View, PeopleAdapter.OnItemClickListener {

    private var mPresenter : MainActivityContract.Presenter? = null
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: PeopleAdapter
    lateinit var tinyDB: TinyDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = MainActivityPresenter(this)
        tinyDB = TinyDB(applicationContext)

        recyclerView.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        if(Singleton.peopleResponse.isEmpty())
        {
            (mPresenter as MainActivityPresenter).callService()
        } else
        {
            showData()
        }



    }

    override fun showData() {
        adapter = PeopleAdapter(baseContext,this , Singleton.peopleResponse)
        adapter.notifyDataSetChanged()
        recyclerView.adapter = adapter
    }

    override fun showDialog() {
        loading.visibility = View.VISIBLE
    }

    override fun dismissDialog() {
        loading.visibility = View.GONE
    }

    override fun onItemClick(position: Int) {
       Log.d("Clicked", "Item $position")
        val intent = Intent(this,DetailsActivity::class.java)
        intent.putExtra("position",position)
        startActivity(intent)
    }


}