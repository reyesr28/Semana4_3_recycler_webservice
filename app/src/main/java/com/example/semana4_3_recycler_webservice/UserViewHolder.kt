package com.example.semana4_3_recycler_webservice

import Beans.Usuarios
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class UserViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val userCod=view.findViewById<TextView>(R.id.txtCod)
    val userNom=view.findViewById<TextView>(R.id.txtNom)
    val userCorreo=view.findViewById<TextView>(R.id.txtCorreo)
    val userFoto=view.findViewById<ImageView>(R.id.imgUser)

    fun render(userModel: Usuarios){
        userCod.text=userModel.codigo
        userNom.text=userModel.nombre
        userCorreo.text=userModel.correo
        Picasso.get()
            .load(userModel.foto)
            .resize(250, 250)
            .centerCrop()
            .into(userFoto)
    }

}