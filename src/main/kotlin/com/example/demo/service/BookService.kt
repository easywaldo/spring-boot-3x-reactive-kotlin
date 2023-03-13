package com.example.demo.service

import com.example.demo.application.port.`in`.RegisterBookCommand
import com.example.demo.domain.Book
import com.example.demo.infra.BookRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime


@Service
class BookService (private val bookRepository: BookRepository) {
    suspend fun registerBook(registerBookCommand: RegisterBookCommand) {
        with(registerBookCommand) {
            bookRepository.findByNameAndWriter(name, writer)?.let {
                throw java.lang.RuntimeException("이미 존재하는 책 입니다.")
            }
            val newBook = Book(name=name, writer = writer)
            newBook.createdAt = LocalDateTime.now()
            bookRepository.save(newBook)
        }
    }
}