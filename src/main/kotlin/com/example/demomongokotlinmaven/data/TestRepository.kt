package com.example.demomongokotlinmaven.data

import org.springframework.data.mongodb.repository.MongoRepository


interface TestRepository : MongoRepository<Test, String>
