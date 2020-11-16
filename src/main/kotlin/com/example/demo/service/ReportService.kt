package com.example.demo.service

import com.example.demo.repository.BuyRepository
import com.example.demo.repository.CustomerRepository
import com.example.demo.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ReportService(
        private val buyRepository: BuyRepository,
        private var customerRepository: CustomerRepository,
        private var productRepository: ProductRepository
) {
    fun getNumCustomers(): String {
        val result = customerRepository.count()
        return "Num of Customers: $result"
    }

    fun getNumBuys(): String {
        val result = buyRepository.count()
        return "Num of Buys: $result"
    }

    fun getNumProducts(): String {
        val result = productRepository.count()
        return "Num of Buys: $result"
    }
}