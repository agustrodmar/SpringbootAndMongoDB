package com.example.demomongokotlinmaven.data

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "test")
data class Test(@Id val id: String)