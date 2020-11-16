package com.example.demo.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Товар
 *
 * @param id id
 * @param name именование товара
 * @param price цена
 * @param createDate дата создания
 * @param deleteDate дата удаления
 */
@Entity
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,
        var name: String,
        var price: Float,
        val createDate: Date,
        var deleteDate: Date?
)