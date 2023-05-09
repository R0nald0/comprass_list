package com.example.comprass.view.model

import com.example.comprass.domain.model.Product

data class ProductView(val id: Long, val name : String,val price:Double,val userId:Long)

fun ProductView.toProduct() = Product(
    id = this.id,
    name = this.name,
    price = this.price,
    userId =this.userId
)