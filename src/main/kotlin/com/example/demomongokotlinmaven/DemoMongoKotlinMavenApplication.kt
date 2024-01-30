package com.example.demomongokotlinmaven

import com.example.demomongokotlinmaven.data.Test
import com.example.demomongokotlinmaven.data.TestRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.boot.CommandLineRunner

/**
 * FUNCIONA 29/01
 * Inserción de datos en MOngoDB a través del framerork SPringboot y Kotlin.
 * Probando Persistenci.
 */
@SpringBootApplication
class DemoMongoKotlinMavenApplication

fun main(args: Array<String>) {
    runApplication<DemoMongoKotlinMavenApplication>(*args)
}


@Component
class CommandLineAppStartupRunner(private val repository: TestRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val test = Test("1")
        repository.save(test)
        println("Guardado: $test")

        // Leer el objeto de la base de datos
        val retrievedTest = repository.findById("1")
        println("Recuperado: $retrievedTest")
    }
}





