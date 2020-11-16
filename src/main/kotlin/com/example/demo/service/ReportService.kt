package com.example.demo.service

import com.example.demo.repos.BuyRepository
import com.example.demo.repos.CustomerRepository
import com.example.demo.repos.ProductRepository
import org.springframework.stereotype.Service

@Service
class ReportService (
        private val buyRepository: BuyRepository,
        private var customerRepository: CustomerRepository,
        private var productRepository: ProductRepository
){
    fun getNumCustomers():String{
        val rezult = customerRepository.count()
        return "Num of Customers: $rezult"
    }

    fun getNumBuys():String{
        val rezult = buyRepository.count()
        return "Num of Buys: $rezult"
    }

    fun getNumProducts():String{
        val rezult = productRepository.count()
        return "Num of Buys: $rezult"
    }
}