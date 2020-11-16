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
    @GetMapping("/getCustomers")
    fun getNumCustomers(): String {
        return reportService.getNumCustomers()
    }

    @GetMapping("/getBuys")
    fun getNumBuys(): String {
        return reportService.getNumBuys()
    }

    @GetMapping("/getProducts")
    fun getNumProducts(): String {
        return reportService.getNumProducts()
    }
}