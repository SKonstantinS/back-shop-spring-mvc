package com.example.demo.repos

import com.example.demo.domain.Buy
import org.springframework.data.repository.CrudRepository
import java.util.*

interface BuyRepository: CrudRepository<Buy, Long> {
    fun findByCustomerId(customerId: Long):List<Buy>
    fun findByCreateDateBetween(dateDayBegin: Date, dateFinish:Date):List<Buy>
}