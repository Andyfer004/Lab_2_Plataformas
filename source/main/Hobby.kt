/*
* ---------------------------------------------------------------------------------------------
* Author: Andy Fuentes Crack
* Date: 26/07/2023
* Carne: 22944
* Descripción: Programa que permite crear perfiles de usuario con sus respectivos hobbies.
* ---------------------------------------------------------------------------------------------
 */
class Hobby(var title: String = "", var description: String ="", var urlPhoto: String? = null)
{
    constructor(title: String, description: String) : this(title, description, null)
}