package com.example.demo.service

import com.example.demo.domain.Customer
import com.example.demo.dto.CustomerRequest
import com.example.demo.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
        private var customerRepository: CustomerRepository
) {
    fun getAll(): List<Customer> {
        val customers = customerRepository.findAll()
        return customers.toList()
    }

    fun getById(id: Long): Customer? {
        val customer = customerRepository.findById(id)
        return if (customer.isPresent) customer.get() else null
    }

    fun create(name: String, lastName: String): String {
        val customerExemplar = Customer(name = name, lastName = lastName)
        val result = customerRepository.save(customerExemplar)
        return "Created OK with id: ${result.id}"
    }

    fun createL(name: String, lastName: String): Long? {
        val customerExemplar = Customer(name = name, lastName = lastName)
        val result = customerRepository.save(customerExemplar)
        return result.id
    }

    fun updateById(id: Long, body: CustomerRequest): String {
        val customerOpt = customerRepository.findById(id)
        if (customerOpt.isPresent) {
            with(customerOpt.get()) {
                name = body.nameCustomer
                lastName = body.surnameCustomer
                val result = customerRepository.save(this)
                return "Updated OK with id: ${result.id}"
            }
        }
        return "NOt found customer with id: $id"
    }
}