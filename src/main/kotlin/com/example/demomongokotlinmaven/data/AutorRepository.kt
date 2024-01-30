package com.example.demomongokotlinmaven.data

import com.example.demomongokotlinmaven.data.Autor
import org.springframework.data.mongodb.repository.MongoRepository

interface AutorRepository : MongoRepository<Autor, String>
