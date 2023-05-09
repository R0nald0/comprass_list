package com.example.comprass.domain.model

import com.example.comprass.view.model.ProductView

data class Product(
    val id :Long,
    val name :String,
    val price :Double,
    val userId: Long
)

fun Product.ToProductView() = ProductView(
    id =this.id,
    name = this.name,
    price =this.price,
    userId = this.userId
)