package com.example.comprass.data.repository

import com.example.comprass.data.local.helper.ComprasDatabase
import com.example.comprass.domain.model.Product
import com.example.comprass.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val db : ComprasDatabase
) : ProductRepository{
    override fun getAllProducts(): List<Product> {

        TODO("Not yet implemented")
    }

    override fun findProductById(idProduct: Long): Product {
        TODO("Not yet implemented")
    }

    override fun insertProduct(product: Product): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(product: Product): Boolean {
        TODO("Not yet implemented")
    }

}
