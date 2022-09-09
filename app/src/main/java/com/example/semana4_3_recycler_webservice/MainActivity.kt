package com.example.semana4_3_recycler_webservice

import Beans.Usuarios
import Interface.PlaceHolder
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    lateinit var servicio:PlaceHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dev.formandocodigo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        servicio=retrofit.create<PlaceHolder>(PlaceHolder::class.java)
        getAllUser()
    }

    private fun getAllUser(){
        servicio.getListado().enqueue(object: Callback<List<Usuarios>>{
            override fun onResponse(
                call: Call<List<Usuarios>>,
                response: Response<List<Usuarios>>
            ) {
                val usu=response?.body()
                val listaU= mutableListOf<Usuarios>()
                if(usu!=null){
                    for(item in usu){
                        listaU.add(
                            Usuarios(item.codigo,item.nombre,item.edad,
                                item.correo,item.pass,item.foto)
                        )
                    }
                }
                val recycler=findViewById<RecyclerView>(R.id.recyclerUsers)
                recycler.layoutManager=LinearLayoutManager(applicationContext)
                recycler.adapter=Adapter(listaU)
            }

            override fun onFailure(call: Call<List<Usuarios>>, t: Throwable) {
                t?.printStackTrace()
            }

        })
    }


}