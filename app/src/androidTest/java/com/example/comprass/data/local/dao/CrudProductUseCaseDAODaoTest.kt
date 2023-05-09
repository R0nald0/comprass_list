package com.example.comprass.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.comprass.data.local.entity.ProductDAO
import com.example.comprass.data.local.entity.UserDAO
import com.example.comprass.data.local.helper.ComprasDatabase
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test

class CrudProductUseCaseDAODaoTest {
    private lateinit var comprasDatabase: ComprasDatabase
    private lateinit var productDao: ProductDao
    private lateinit var userDao: UserDao

    @Before
    fun setUp() {
        comprasDatabase =Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                ComprasDatabase::class.java
            ).allowMainThreadQueries()
             .build()
        productDao = comprasDatabase.productDao()
        userDao  = comprasDatabase.userDao()
    }
    @Test
    fun insertUser_createProductAndRetunrLongOne() {
        val userDAO = UserDAO(0,"Miau")
        userDao.insertUser(userDAO)
        val productDAO = ProductDAO(0,"Notebook",12.43,12.00,false,1)
        val resInser = productDao.insertProduct(productDAO)
        assertThat(resInser).isEqualTo(1)
    }

    @Test
    fun getAllProducts_getAllProductsAndReturnListProducts(){
        val userDAO = UserDAO(0,"Miau")
        userDao.insertUser(userDAO)
        val productDAO = ProductDAO(0,"Notebook",12.43,12.00,false,1)
       productDao.insertProduct(productDAO)
       val listProduct  = productDao.getAllProducts()

        assertThat(listProduct).hasSize(1)
        assertThat(listProduct[0].Name).isEqualTo("Notebook")
    }

    @Test
    fun findUserById_receiveIdUserAndReturnListUserWithOneUser(){
        val userDAO = UserDAO(0,"Miau")
        userDao.insertUser(userDAO)

        val productDAO = ProductDAO(0,"Notebook",12.43,12.00,false,1)
        productDao.insertProduct(productDAO)
        val result = productDao.findProductById(1)

        assertThat(result).hasSize(1)
        assertThat(result[0].price).isEqualTo(12.43)
    }

    @Test()
    fun delete_receiveProductAndReturnZero(){
        val productDAO = ProductDAO(0,"Notebook",12.43,12.00,false,1)
        val resDelete = productDao.deleteProduct(productDAO)
        assertThat(resDelete).isEqualTo(0)
    }



    @After
    fun tearDown() {
        comprasDatabase.close()
    }
}