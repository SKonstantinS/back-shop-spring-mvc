package com.example.demo.service

import com.example.demo.SimpleShopApplication
import com.example.demo.dto.CustomerRequest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [SimpleShopApplication::class])
class CustomerServiceTest {

    @Autowired
    private lateinit var customerServiceTest: CustomerService

    @Test
    fun testCreate() {
        val testName = "Donald"
        val testLastName = "Trump"
        val idCreate = customerServiceTest.createL(testName, testLastName)
        val customerEx = idCreate?.let { customerServiceTest.getById(it) }
        println("customer from db: $customerEx")
        Assertions.assertEquals(testName, customerEx?.name, "wrong result")
    }

    @Test
    fun testUpdate() {
        val testName = "Donald"
        val testLastName = "Trump"
        val idCreate = customerServiceTest.createL(testName, testLastName)
        Assertions.assertNotNull(idCreate)
        val newName = "Joe"
        val newSurname = "Biden"
        customerServiceTest.updateById(idCreate!!, CustomerRequest(nameCustomer = newName, surnameCustomer =  newSurname))

        val customerEx = customerServiceTest.getById(idCreate)
        Assertions.assertNotNull(customerEx)
        Assertions.assertEquals(newSurname, customerEx!!.lastName, "wrong surname")
        Assertions.assertEquals(newName, customerEx.name, "wrong name")

    }
}