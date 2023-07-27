/*
* ---------------------------------------------------------------------------------------------
* Author: Andy Fuentes Crack
* Date: 26/07/2023
* Carne: 22944
* Descripción: Programa que permite crear perfiles de usuario con sus respectivos hobbies.
* ---------------------------------------------------------------------------------------------
 */
fun main(args: Array<String>) {
    // Definición de funciones para interactuar con los perfiles y hobbies

    /**
     * Crea un nuevo perfil de usuario y lo agrega a la lista de perfiles.
     * Solicita al usuario ingresar los datos del perfil.
     *
     * @param listaPerfiles La lista mutable que contiene los perfiles de usuario existentes.
     */
    fun crearPerfil(listaPerfiles: MutableList<PerfilUsuario>) {
        print("Ingrese ID: ")
        val id = readLine()?.toIntOrNull() ?: return

        print("Ingrese Nombres: ")
        val nombres = readLine() ?: return

        print("Ingrese Apellidos: ")
        val apellidos = readLine() ?: return

        print("Ingrese UrlPhoto (opcional): ")
        val urlPhoto = readLine()

        print("Ingrese Edad: ")
        val edad = readLine()?.toIntOrNull() ?: return

        print("Ingrese Correo: ")
        val correo = readLine() ?: return

        print("Ingrese Biografía (opcional): ")
        val biografia = readLine()

        print("Ingrese Estado (ACTIVO, PENDIENTE, INACTIVO): ")
        val estadoInput = readLine()?.toUpperCase()
        val estado = when (estadoInput) {
            "ACTIVO" -> PerfilUsuario.Estado.ACTIVO
            "PENDIENTE" -> PerfilUsuario.Estado.PENDIENTE
            "INACTIVO" -> PerfilUsuario.Estado.INACTIVO
            else -> PerfilUsuario.Estado.PENDIENTE
        }

        // Leer datos para el Hobby
        print("Ingrese el título del hobby: ")
        val tituloHobby = readLine() ?: return

        print("Ingrese la descripción del hobby: ")
        val descripcionHobby = readLine() ?: return

        listaPerfiles.add(
            PerfilUsuario(
                id,
                nombres,
                apellidos,
                urlPhoto,
                edad,
                correo,
                biografia,
                estado,
                mutableListOf(Hobby(tituloHobby, descripcionHobby))
            )
        )
        println("Perfil creado exitosamente.")
    }

    /**
     * Imprime la información de un perfil de usuario en la consola.
     *
     * @param perfil El perfil de usuario cuya información se imprimirá.
     */
    fun imprimirPerfil(perfil: PerfilUsuario) {
        println("ID: ${perfil.ID}")
        println("Nombres: ${perfil.Nombres}")
        println("Apellidos: ${perfil.Apellidos}")
        println("UrlPhoto: ${perfil.UrlPhoto ?: "N/A"}")
        println("Edad: ${perfil.Edad}")
        println("Correo: ${perfil.Correo}")
        println("Biografía: ${perfil.Biografia ?: "N/A"}")
        println("Estado: ${perfil.estado}")
        println("Hobbies:")
        perfil.hobby?.forEach { println("- ${it.title}: ${it.description}") }
    }
    /**
     * Agrega un hobby a un perfil de usuario existente en la lista de perfiles.
     * Solicita al usuario ingresar los datos del hobby.
     *
     * @param listaPerfiles La lista mutable que contiene los perfiles de usuario existentes.
     */
    fun agregarHobby(listaPerfiles: MutableList<PerfilUsuario>) {
        print("Ingrese el ID del perfil al que desea agregar un hobby: ")
        val idBuscado = readLine()?.toIntOrNull()
        val perfilEncontrado = listaPerfiles.find { it.ID == idBuscado }
        if (perfilEncontrado != null) {
            val hobby = Hobby()

            print("Ingrese el título del hobby: ")
            hobby.title = readLine() ?: return

            print("Ingrese la descripción del hobby: ")
            hobby.description = readLine() ?: return

            print("Ingrese la UrlPhoto del hobby (opcional): ")
            hobby.urlPhoto = readLine()

            perfilEncontrado.AgregarHobby(hobby)
            println("Hobby agregado exitosamente.")
        } else {
            println("No se encontró ningún perfil con el ID ingresado.")
        }
    }

    /**
     * Busca un perfil de usuario en la lista por ID o por Nombres/Apellidos y lo imprime si se encuentra.
     *
     * @param listaPerfiles La lista mutable que contiene los perfiles de usuario existentes.
     */
    fun buscarPerfil(listaPerfiles: MutableList<PerfilUsuario>) {
        print("Buscar por ID (1) o por Nombres/Apellidos (2): ")
        val opcionBusqueda = readLine()?.toIntOrNull()

        when (opcionBusqueda) {
            1 -> {
                print("Ingrese el ID del perfil a buscar: ")
                val idBuscado = readLine()?.toIntOrNull()
                val perfilEncontrado = listaPerfiles.find { it.ID == idBuscado }
                if (perfilEncontrado != null) {
                    imprimirPerfil(perfilEncontrado)
                } else {
                    println("No se encontró ningún perfil con el ID ingresado.")
                }
            }
            2 -> {
                print("Ingrese Nombres o Apellidos del perfil a buscar: ")
                val input = readLine() ?: return
                val perfilesEncontrados = listaPerfiles.filter {
                    it.Nombres.equals(input, ignoreCase = true) || it.Apellidos.equals(input, ignoreCase = true)
                }
                if (perfilesEncontrados.isNotEmpty()) {
                    perfilesEncontrados.forEach { imprimirPerfil(it) }
                } else {
                    println("No se encontró ningún perfil con los Nombres/Apellidos ingresados.")
                }
            }
            else -> println("Opción inválida.")
        }
    }



    /**
     * Elimina un perfil de usuario de la lista por su ID.
     *
     * @param listaPerfiles La lista mutable que contiene los perfiles de usuario existentes.
     */

    fun eliminarPerfil(listaPerfiles: MutableList<PerfilUsuario>) {
        print("Ingrese el ID del perfil a eliminar: ")
        val idBuscado = readLine()?.toIntOrNull()
        val perfilEncontrado = listaPerfiles.find { it.ID == idBuscado }
        if (perfilEncontrado != null) {
            listaPerfiles.remove(perfilEncontrado)
            println("Perfil eliminado exitosamente.")
        } else {
            println("No se encontró ningún perfil con el ID ingresado.")
        }
    }
    val listaPerfiles = mutableListOf<PerfilUsuario>()

    var salir = false
    listaPerfiles.addAll(listOf(
        PerfilUsuario(2, "Laura", "Rodríguez", "url", 25, "laura@gmail.com", "Biografía de Laura", PerfilUsuario.Estado.PENDIENTE, mutableListOf(Hobby("Pintura", "Arte de pintar", "url_pintura"))),
        PerfilUsuario(1, "John", "Doe", "url", 30, "john.doe@example.com", "Biografía de John", PerfilUsuario.Estado.ACTIVO, mutableListOf(Hobby("Reading", "Reading books", "url_reading"))),
        PerfilUsuario(3, "Alice", "Smith", "url", 28, "alice.smith@example.com", "Biografía de Alice", PerfilUsuario.Estado.INACTIVO, mutableListOf(Hobby("Cooking", "Cooking delicious meals", "url_cooking"))),
        PerfilUsuario(4, "Bob", "Johnson", "url", 22, "bob.johnson@example.com", "Biografía de Bob", PerfilUsuario.Estado.PENDIENTE, mutableListOf(Hobby("Photography", "Capturing beautiful moments", "url_photography"))),
        PerfilUsuario(5, "Emma", "Brown", "url", 35, "emma.brown@example.com", "Biografía de Emma", PerfilUsuario.Estado.ACTIVO, mutableListOf(Hobby("Gardening", "Growing plants and flowers", "url_gardening"))),
        PerfilUsuario(6, "Michael", "Lee", "url", 27, "michael.lee@example.com", "Biografía de Michael", PerfilUsuario.Estado.INACTIVO, mutableListOf(Hobby("Running", "Jogging in the park", "url_running"))),
        PerfilUsuario(7, "Sophia", "Wang", "url", 29, "sophia.wang@example.com", "Biografía de Sophia", PerfilUsuario.Estado.ACTIVO, mutableListOf(Hobby("Traveling", "Exploring new places", "url_traveling")))
    ))



    while (!salir) {
        println("Opciones:")
        println("1. Crear perfil")
        println("2. Buscar perfil de usuario(s)")
        println("3. Eliminar perfil")
        println("4. Agregar Hobby")
        println("5. Salir")
        print("Seleccione una opción: ")

        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> crearPerfil(listaPerfiles)
            2 -> buscarPerfil(listaPerfiles)
            3 -> eliminarPerfil(listaPerfiles)
            4 -> agregarHobby(listaPerfiles)
            5 -> salir = true
            else -> println("Opción inválida. Inténtelo nuevamente.")
        }

        println()
    }
}


