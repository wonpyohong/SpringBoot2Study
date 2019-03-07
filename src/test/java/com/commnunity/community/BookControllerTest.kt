package com.commnunity.community

import com.commnunity.community.controller.Book
import com.commnunity.community.controller.BookController
import com.commnunity.community.service.BookService
import org.hamcrest.Matchers.contains
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.time.LocalDate
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@WebMvcTest(BookController::class)
class BookControllerTest {

    @Autowired
    lateinit var mvc: MockMvc

    @MockBean
    lateinit var bookService: BookService

    @Test
    fun Book_MVC_테스트() {
        val book = Book(0, "Spring Boot Book", LocalDateTime.now())
        given(bookService.getBookList()).willReturn(listOf(book))

        mvc.perform(get("/books"))
                .andExpect(status().isOk)
                .andExpect(view().name("book"))
                .andExpect(model().attributeExists("bookList"))
                .andExpect(model().attribute("bookList", contains(book)))

    }
}