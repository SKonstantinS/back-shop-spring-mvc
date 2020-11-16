package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.text.SimpleDateFormat

@SpringBootTest
class ApplicationTests {

    @Test
    fun contextLoads() {
    }

    @Test
    fun dateFormat(){
        var timeBegin = SimpleDateFormat("HH:mm").parse("07:00")
        println("Test Date format: $timeBegin")
    }
}
