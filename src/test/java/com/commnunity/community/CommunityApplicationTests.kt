package com.commnunity.community

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner


@ActiveProfiles("local")
@SpringBootTest(
//        value = ["value=test"],
        properties = ["property.value=propertyTest"],
        classes = [CommunityApplication::class],
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner::class)
class CommunityApplicationTests {

//    @Value("\${value}")
//    lateinit var value: String

    @Value("\${property.value}")
    lateinit var propertyValue: String

    @Test
    fun contextLoads() {
//        assertThat(value, `is`("test"))
        assertThat(propertyValue, `is`("propertyTest"))
    }
}
