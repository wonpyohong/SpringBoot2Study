package com.commnunity.community

import com.commnunity.community.service.BookRestService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import org.springframework.test.web.client.response.MockRestResponseCreators.withServerError
import org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess
import org.springframework.web.client.HttpServerErrorException

@RunWith(SpringRunner::class)
@RestClientTest(BookRestService::class)
class BookRestTest {
    @get:Rule
    val thrown = ExpectedException.none()!!

    @Autowired
    lateinit var bookRestService: BookRestService

    @Autowired
    lateinit var server: MockRestServiceServer

    @Test
    fun rest_테스트() {
        this.server.expect(requestTo("/rest/test"))
                .andRespond(withSuccess(ClassPathResource("/test.json", javaClass), MediaType.APPLICATION_JSON))

        val book = this.bookRestService.getRestBook()
        assertThat(book?.title).isEqualTo("테스트")
    }

    @Test
    fun rest_error_테스트() {
        this.server.expect(requestTo("/rest/test"))
                .andRespond(withServerError())

        this.thrown.expect(HttpServerErrorException::class.java)
        this.bookRestService.getRestBook()
    }
}