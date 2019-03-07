package com.commnunity.community.service

import com.commnunity.community.controller.Book
import org.springframework.stereotype.Service

@Service
interface BookService {
    fun getBookList(): List<Book>
}