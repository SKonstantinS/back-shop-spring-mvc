package com.example.demo.repos

import com.example.demo.domain.Product
import org.springframework.data.repository.CrudRepository

interface ProductRepository: CrudRepository<Product, Long> {
}