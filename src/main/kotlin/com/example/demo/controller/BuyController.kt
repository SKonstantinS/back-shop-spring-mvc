package com.example.demo.controller

import com.example.demo.domain.Buy
import com.example.demo.service.BuyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/buy")
class BuyController(
//        private val buyService: BuyService
) {
//    Вместо объявления в конструкторе, объявил тут
    @Autowired
    private lateinit var buyService: BuyService

    @GetMapping("/getAll")
    fun getAllBuys(): List<Buy> {
        return buyService.getAll()
    }

    @PostMapping("/create")
    fun create(@RequestParam customerId: Long, @RequestParam productId: Long): String {
        return buyService.create(
                customerId,
                productId
        )
    }

    @GetMapping("/allBuysByCustomer")
    fun allBuysByCustomer(@RequestParam customerId: Long): List<Buy> {
        return buyService.getAllBuysByCustomer(
                customerId
        )
    }

    @GetMapping("/allBuysToday")
    fun allBuysToday(): List<Buy> {
        return buyService.getAllBuysToday()
    }
}