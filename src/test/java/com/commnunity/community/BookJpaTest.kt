package com.commnunity.community

import com.commnunity.community.controller.Book
import com.commnunity.community.repository.BookRepository
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
import org.hamcrest.Matchers.hasSize
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDateTime

@RunWith(SpringRunner::class)
@DataJpaTest
open class BookJpaTest {
    val BOOT_TEST_TITLE = "Spring Book Test Book"

    @Autowired
    lateinit var testEntityManager: TestEntityManager

    @Autowired
    lateinit var bookRepository: BookRepository

    @Test
    fun Book_저장하기_테스트() {
        val book = Book(0, BOOT_TEST_TITLE, LocalDateTime.now())
        testEntityManager.persist(book)
        assertThat(bookRepository.getOne(book.idx), `is`(book))
    }

    @Test
    fun BookList_저장하고_검색_테스트() {
        val book1 = Book(title = "${BOOT_TEST_TITLE}1", publishedAt = LocalDateTime.now())
        testEntityManager.persist(book1)

        val book2 = Book(title = "${BOOT_TEST_TITLE}2", publishedAt = LocalDateTime.now())
        testEntityManager.persist(book2)

        val book3 = Book(title = "${BOOT_TEST_TITLE}3", publishedAt = LocalDateTime.now())
        testEntityManager.persist(book3)

        val bookList = bookRepository.findAll()
        assertThat(bookList, hasSize(3))
        assertThat(bookList, contains(book1, book2, book3))
    }

    @Test
    fun BookList_저장하고_삭제_테스트() {
        val book1 = Book(0, "${BOOT_TEST_TITLE}1", LocalDateTime.now())
        testEntityManager.persist(book1)

        val book2 = Book(0, "${BOOT_TEST_TITLE}2", LocalDateTime.now())
        testEntityManager.persist(book1)

        bookRepository.deleteAll()
        assertThat(bookRepository.findAll(), `is`(mutableListOf<Book>()))
    }
}