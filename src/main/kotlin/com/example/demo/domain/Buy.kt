package com.example.demo.domain

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Покупка
 */
@Entity
data class Buy(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null,
        val customerId: Long,
        val productId: Long,
        val count: Int,
        val createDate: Date
)