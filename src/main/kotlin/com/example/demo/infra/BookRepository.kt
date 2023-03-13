package com.example.demo.infra

import com.example.demo.domain.Book
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface BookRepository: CoroutineCrudRepository<Book, Long> {
    suspend fun findByNameAndWriter(name: String, writer: String): Book?
}