package com.example.androidexam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidexam.model.People
import com.example.androidexam.R

class PeopleAdapter (private val context: Context, private val listener: OnItemClickListener, private val peopleList: ArrayList<People>)
    : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.layout_people_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.lName.text = peopleList[position].last_name
        holder.fName.text = peopleList[position].first_name
        holder.address.text = peopleList[position].address
        holder.email.text = peopleList[position].email
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val fName: TextView = itemView.findViewById(R.id.tvFName)
        val lName: TextView = itemView.findViewById(R.id.tvLName)
        val address: TextView = itemView.findViewById(R.id.tvAddress)
        val email: TextView = itemView.findViewById(R.id.tvEmail)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if(position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}