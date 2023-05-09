package com.example.comprass.domain.repository

import com.example.comprass.domain.model.Product

interface ProductRepository {
    fun getAllProducts():List<Product>
    fun findProductById(idProduct :Long): Product
    fun insertProduct(product: Product):Boolean
    fun delete(product: Product):Boolean
}