package com.example.demomongokotlinmaven.domain

import com.example.demomongokotlinmaven.data.TestRepository
import com.example.demomongokotlinmaven.data.Test
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tests")
class TestController(private val repository: TestRepository) {

    @PostMapping
    fun addTest(@RequestBody test: Test): Test {
        return repository.save(test)
    }

    @GetMapping("/{id}")
    fun getTest(@PathVariable id: String): Test? {
        return repository.findById(id).orElse(null)
    }
}