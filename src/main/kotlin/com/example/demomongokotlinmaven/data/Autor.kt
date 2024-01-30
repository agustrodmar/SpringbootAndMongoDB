package com.example.demomongokotlinmaven.data

import com.example.demomongokotlinmaven.data.Address
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "autores")
data class Autor(
    @Id val id: String,
    val nombre: String,
    val direccion: Address,
    val equipoFavorito: String? = null
)
