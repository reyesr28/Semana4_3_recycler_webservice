package Beans

class Usuarios {

    var codigo:String
    var nombre:String
    var edad:Int
    var correo:String
    var pass:String
    var foto:String

    constructor(
        codigo: String,
        nombre: String,
        edad: Int,
        correo: String,
        pass: String,
        foto: String
    ) {
        this.codigo = codigo
        this.nombre = nombre
        this.edad = edad
        this.correo = correo
        this.pass = pass
        this.foto = foto
    }
}