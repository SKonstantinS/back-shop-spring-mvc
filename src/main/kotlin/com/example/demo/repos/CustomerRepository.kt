package com.example.demo.repos

import com.example.demo.domain.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository: CrudRepository<Customer, Long> {
}