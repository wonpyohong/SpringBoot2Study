package com.commnunity.community.pojo

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@ConfigurationProperties("fruit")
class FruitProperty {
    lateinit var list: MutableList<Fruit>
}