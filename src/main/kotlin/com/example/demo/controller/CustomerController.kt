package com.example.demo.controller

import com.example.demo.domain.Customer
import com.example.demo.dto.CustomerRequest
import com.example.demo.service.CustomerService
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping ("/customers")
class CustomerController (
        private val customerService: CustomerService
){
//    @Autowired
//    private lateinit var customerService: customerService //

    @GetMapping("/greeting")
    fun greeting(@RequestParam(name = "name", required = false, defaultValue = "World") name: String, model: Model): String {
        model.addAttribute("name", name)
        return "greeting"
    }

    @GetMapping("/test")
    fun test() = "taaast"

//    @GetMapping("/getAllWithModel")
//    fun mainSide(model: Model): String {
//        val customers = customRep.findAll()
//        model.addAttribute("customers", customers)
//        return "customers"
//    }

    @GetMapping("/getAll")
    fun getAllCustomers(): List<Customer> {
        return customerService.getAll()
    }

    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: String): Customer? {
        //TODO chck id вдруг не long
        return customerService.getById(id.toLong())
    }

    @PostMapping("/create")
    fun add(@RequestParam name: String, @RequestParam lastName: String): String {
        return customerService.create(
                name,
                lastName
        )
    }

    @PostMapping("/update/{id}")
    fun update(@PathVariable id: String, @RequestBody body: CustomerRequest): String {
        return customerService.updateById(id = id.toLong(), body = body)
    }
}