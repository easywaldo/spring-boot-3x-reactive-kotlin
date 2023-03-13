package com.example.demo.application.controller

import com.example.demo.application.port.`in`.RegisterBookCommand
import com.example.demo.service.BookService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/books")
class BookController (private val bookService: BookService) {
    @PostMapping("/registerBook")
    suspend fun registerBook(@RequestBody registerBookCommand: RegisterBookCommand) {
        bookService.registerBook(registerBookCommand)
    }
}