package com.commnunity.community

import com.commnunity.community.pojo.FruitProperty
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@SpringBootTest
@RunWith(SpringRunner::class)
class PropertyTest {
    @Autowired
    lateinit var fruitProperty: FruitProperty

    @Test
    fun test() {
        val fruitData = fruitProperty.list
        assertThat(fruitData[0].name, `is`("banana"))
    }
}