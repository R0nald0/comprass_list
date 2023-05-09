package com.example.comprass.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.comprass.data.local.entity.ProductDAO


@Dao
interface ProductDao {
    @Query(value = "SELECT *FROM product_table")
     fun getAllProducts() : List<ProductDAO>
     @Query(value = "SELECT *FROM product_table WHERE id_product = :idProduct")
     fun findProductById(idProduct: Long) :List<ProductDAO>

    @Insert
     fun insertProduct(productDAO: ProductDAO):Long
    @Delete
     fun deleteProduct(productDAO: ProductDAO):Int

}