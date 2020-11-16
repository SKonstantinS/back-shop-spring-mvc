package com.example.demo.controller


import com.example.demo.domain.Buy
import com.example.demo.domain.Product
import com.example.demo.dto.ProductRequest
import com.example.demo.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductController(
        private val productService: ProductService
) {
    @GetMapping("/getAll")
    fun getAllBuys(): List<Product> {
        return productService.getAll()
    }

    @PostMapping("/create")
    fun add(@RequestParam name: String, @RequestParam price: Float): String {
        return productService.create(
                name,
                price
        )
    }

    @PostMapping("/update/{id}")
    fun update(@PathVariable id: String, @RequestBody body: ProductRequest): String {
        return productService.updateById(id = id.toLong(), body = body)
    }

    @PostMapping("/delete/{id}")
    fun delete(@PathVariable id: String): String {
        return productService.deleteById(id = id.toLong())
    }
}