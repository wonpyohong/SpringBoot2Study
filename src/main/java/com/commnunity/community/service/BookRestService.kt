package com.commnunity.community.service

import com.commnunity.community.controller.Book
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Service
class BookRestService(restTemplateBuilder: RestTemplateBuilder) {
    var restTemplate: RestTemplate = restTemplateBuilder.rootUri("/rest/test").build()

    fun getRestBook(): Book? {
        return this.restTemplate.getForObject("/rest/test")
    }
}