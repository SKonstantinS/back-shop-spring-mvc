package com.example.demo.service

import com.example.demo.domain.Product
import com.example.demo.dto.ProductRequest
import com.example.demo.repos.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getAll(): List<Product>{
        val products = productRepository.findAll()
        return products.toList()
    }
    //TODO Product - не хватает полей
    fun create(name: String, price: Float): String {
        val productExemplar = Product(
                name = name,
                price = price,
                createDate = Date(),
                deleteDate = null)
        val result = productRepository.save(productExemplar)
        return "Created OK with id: ${result.id}"
    }

    fun updateById(id: Long, body: ProductRequest): String{
        val productEx = productRepository.findById(id)
        if (productEx.isPresent){
            with(productEx.get()){
                name = body.nameProduct
                price = body.priceProduct
                val rezult = productRepository.save(this)
                return "Found and changed product with id: ${rezult.id}"
            }
        }
        return "NOt found product with id: $id"
    }

    fun deleteById (id: Long):String {
        val productEx = productRepository.findById(id)
        if (productEx.isPresent){
            with(productEx.get()){
                val rezult = productRepository.delete(this)
                return "Delete product with id: ${id}"
            }
        }
        return "NOt found product with id: $id"
    }
}