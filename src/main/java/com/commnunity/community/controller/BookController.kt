package com.commnunity.community.controller

import com.commnunity.community.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import java.time.LocalDateTime
import javax.persistence.*

@Controller
class BookController {
    @Autowired
    lateinit var bookService: BookService

    @GetMapping("/books")
    fun getBookList(model: Model): String {
        model.addAttribute("bookList", bookService.getBookList())
        return "book"
    }
}

@Entity
@Table
data class Book(
        @Id
        @GeneratedValue
        val idx: Int = 0,

        @Column
        val title: String,

        @Column
        val publishedAt: LocalDateTime? = null
)