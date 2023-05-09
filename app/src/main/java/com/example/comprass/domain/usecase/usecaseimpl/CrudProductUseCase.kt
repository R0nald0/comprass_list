package com.example.comprass.domain.usecase.usecaseimpl

import androidx.core.content.res.ResourcesCompat.ThemeCompat
import com.example.comprass.domain.model.Product
import com.example.comprass.domain.model.ToProductView
import com.example.comprass.domain.repository.ProductRepository
import com.example.comprass.domain.repository.UserRepository
import com.example.comprass.domain.usecase.ProductUseCase
import com.example.comprass.view.model.ProductView
import com.example.comprass.view.model.toProduct
import javax.inject.Inject

class CrudProductUseCase @Inject constructor(
    private val repository: ProductRepository
) : ProductUseCase {
    override fun getAllProduct(): Result<List<ProductView>> {
         try {
             val listProduct = repository.getAllProducts()
              if (listProduct.isNotEmpty()){
                   val listProductView = listProduct.map {  product ->
                          product.ToProductView()
                   }
                  return  Result.success(listProductView)
              }else{
                  return Result.success(listOf())
              }
         }catch (e :Throwable){
             e.printStackTrace()
             return Result.failure(Throwable("erro ao buscar Lista De Produtos",e))
         }
    }

    override fun findProductById(idProduct: Long): Result<ProductView> {
         try {
             val product = repository.findProductById(idProduct)
                val productView = product.ToProductView()
               return Result.success(productView)
         }catch (e:Throwable){
             e.printStackTrace()
             return Result.failure(Throwable("Usuario não encontrado",e))
         }
    }

    override fun insertProduct(productView: ProductView): Result<Boolean> {
        return try {
            val result = repository.insertProduct(productView.toProduct())
            Result.success(result)
        }catch (e:Throwable){
            e.printStackTrace()
            Result.failure(Throwable("erro ao salvar produto",e))
        }
    }

    override fun delete( productView : ProductView): Result<Boolean> {
        return   try {
              val result = repository.delete(productView.toProduct())
                return  Result.success(result)
          }catch (e:Throwable){
              e.printStackTrace()
              Result.failure(Throwable("erro ao deletar produto",e))
          }
    }

}