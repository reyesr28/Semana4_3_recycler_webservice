package Interface

import Beans.Usuarios
import retrofit2.Call
import retrofit2.http.GET

interface PlaceHolder {

    @GET("listado.php")
    fun getListado():Call<List<Usuarios>>

}