package com.commnunity.community.controller

import com.commnunity.community.service.BookRestService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping

class BookRestController {
    @Autowired
    lateinit var bookRestService: BookRestService

    @GetMapping(path = ["/rest/test"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getRestBooks(): Book? {
        return bookRestService.getRestBook()
    }
}