package com.example.demo.repository

import com.example.demo.domain.Customer
import org.springframework.data.repository.CrudRepository

interface CustomerRepository : CrudRepository<Customer, Long>