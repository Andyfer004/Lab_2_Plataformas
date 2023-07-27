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
    /**
     * Enumeración que define los posibles estados de un perfil de usuario.
     */
    enum class Estado {
        ACTIVO, PENDIENTE, INACTIVO
    }
/**
* Se define la clase PerfilUsuario con sus respectivos atributos.
 */
    var ID: Int = id
    var Nombres: String = nombres
    var Apellidos: String = apellidos
    var UrlPhoto: String? = urlPhoto
    var Edad: Int = edad
    var Correo: String = correo
    var Biografia: String? = biografia
    var estado: Estado = estado
    var hobby: MutableList<Hobby>? = hobbies

    /**
     * Agrega un nuevo hobby a la lista de hobbies del perfil.
     */
    fun AgregarHobby(hobby: Hobby) {
        this.hobby = when (this.hobby) {
            null -> mutableListOf(hobby)
            else -> this.hobby!!.toMutableList().apply { add(hobby) }
        }
    }


}
