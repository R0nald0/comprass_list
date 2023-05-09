package com.example.comprass.domain.usecase

import com.example.comprass.domain.model.Product
import com.example.comprass.view.model.ProductView


interface ProductUseCase {
    fun  getAllProduct():Result<List<ProductView>>
    fun  findProductById(idProduct : Long):Result<ProductView>
    fun  insertProduct( ProductView: ProductView):Result<Boolean>
    fun  delete( productView: ProductView):Result<Boolean>
}