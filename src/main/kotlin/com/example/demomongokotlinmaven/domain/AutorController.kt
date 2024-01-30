package com.example.demomongokotlinmaven.domain
import com.example.demomongokotlinmaven.data.Autor
import com.example.demomongokotlinmaven.data.AutorRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

/**
 * FUNCIONA 30/01:
 *  En el proyecto deberá existir las opciones de:
 * Búsqueda , Inserción, Eliminación y actualización de datos.
 *
 * @param repository referencia a la interfaz de la BD Autor.
 */
@RestController
@RequestMapping("/autores")
class AutorController(private val repository: AutorRepository) {

    @PostMapping
    fun addAutor(@RequestBody autor: Autor): Autor {
        return repository.save(autor)
    }

    @GetMapping("/{id}")
    fun getAutor(@PathVariable id: String): Autor? {
        return repository.findById(id).orElse(null)
    }

    @PutMapping("/{id}")
    fun updateAutor(@PathVariable id: String, @RequestBody autor: Autor): Autor {
        return if (repository.existsById(id)) {
            repository.save(autor)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado")
        }
    }

    @DeleteMapping("/{id}")
    fun deleteAutor(@PathVariable id: String): ResponseEntity<Void> {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            ResponseEntity<Void>(HttpStatus.NO_CONTENT)
        } else {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Autor no encontrado")
        }
    }
}

