/*
* ---------------------------------------------------------------------------------------------
* Author: Andy Fuentes Crack
* Date: 26/07/2023
* Carne: 22944
* Descripción: Programa que permite crear perfiles de usuario con sus respectivos hobbies.
* ---------------------------------------------------------------------------------------------
 */
class PerfilUsuario(
    id: Int,
    nombres: String,
    apellidos: String,
    urlPhoto: String?,
    edad: Int,
    correo: String,
    biografia: String?,
    estado: Estado,
    hobbies: MutableList<Hobby>?
) {
    enum class Estado {
        ACTIVO, PENDIENTE, INACTIVO
    }

    var ID: Int = id
    var Nombres: String = nombres
    var Apellidos: String = apellidos
    var UrlPhoto: String? = urlPhoto
    var Edad: Int = edad
    var Correo: String = correo
    var Biografia: String? = biografia
    var estado: Estado = estado
    var hobby: MutableList<Hobby>? = hobbies

    fun AgregarHobby(hobby: Hobby) {
        this.hobby = when (this.hobby) {
            null -> mutableListOf(hobby)
            else -> this.hobby!!.toMutableList().apply { add(hobby) }
        }
    }


}
