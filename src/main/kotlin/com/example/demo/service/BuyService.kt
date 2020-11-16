package com.example.demo.service

import com.example.demo.domain.Buy
import com.example.demo.repos.BuyRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class BuyService (
        private val buyRepository: BuyRepository
) {
    private var counter = 1
    fun getAll(): List<Buy> {
        val buys = buyRepository.findAll()
        return buys.toList()
    }

    fun create(customerId: Long, productId: Long):String{
        val buyExemplar = Buy(
                customerId = customerId,
                productId = productId,
                count = counter++,
                createDate = Date()
        )
        val result = buyRepository.save(buyExemplar)
        return "Created OK with id: ${result.id}"
    }

    fun getAllBuysByCustomer(customerId: Long):List<Buy>{
        return buyRepository.findByCustomerId(customerId)
    }

    fun getAllBuysToday():List<Buy> {
//        TODO исправить, тк запрос не работает, дата 1 янв 1970
        var timeBegin = SimpleDateFormat("HH:mm").parse("07:00")
        var timeFinish = SimpleDateFormat("HH:mm").parse("18:00")
        return buyRepository.findByCreateDateBetween(timeBegin, timeFinish)
    }
}