package com.example.demo.controller

import com.example.demo.service.ReportService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/report")
class ReportController(
        private val reportService: ReportService
) {
    @GetMapping("/getCustomersCount")
    fun getNumCustomers(): String {
        return reportService.getNumCustomers()
    }

    @GetMapping("/getBuysCount")
    fun getNumBuys(): String {
        return reportService.getNumBuys()
    }

    @GetMapping("/getProductsCount")
    fun getNumProducts(): String {
        return reportService.getNumProducts()
    }
}