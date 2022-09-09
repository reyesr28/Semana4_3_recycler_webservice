package com.example.semana4_3_recycler_webservice

import android.view.LayoutInflater
import android.view.ViewGroup
import Beans.Usuarios
import androidx.recyclerview.widget.RecyclerView

class Adapter(val usuariosList: List<Usuarios>):RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return UserViewHolder(layoutInflater.inflate(R.layout.item,parent,false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item=usuariosList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = usuariosList.size


}