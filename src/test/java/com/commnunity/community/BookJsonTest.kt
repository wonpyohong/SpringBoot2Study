package com.commnunity.community

import com.commnunity.community.controller.Book
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.json.JsonTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.test.context.junit4.SpringRunner
import com.fasterxml.jackson.databind.ObjectMapper



@RunWith(SpringRunner::class)
@JsonTest
class BookJsonTest {
    lateinit var json: JacksonTester<Book>

    @Autowired
    var objectMapper: ObjectMapper? = null

    @Before
    fun setup() {
        JacksonTester.initFields(this, objectMapper)
    }

    @Test
    fun json_테스트() {
        val book = Book(title = "테스트")
        val content = "{\"title\":\"테스트\"}"

        assertThat(this.json.parseObject(content).title).isEqualTo(book.title)
        assertThat(this.json.parseObject(content).publishedAt).isNull()
        assertThat(this.json.write(book)).isEqualToJson("/test.json")
        assertThat(this.json.write(book)).hasJsonPathStringValue("title")
        assertThat(this.json.write(book)).extractingJsonPathStringValue("title").isEqualTo("테스트")
    }
}