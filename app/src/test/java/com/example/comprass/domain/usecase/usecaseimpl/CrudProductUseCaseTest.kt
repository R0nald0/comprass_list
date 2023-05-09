package com.example.comprass.domain.usecase.usecaseimpl

import com.example.comprass.domain.model.Product
import com.example.comprass.domain.model.ToProductView
import com.example.comprass.domain.model.User
import com.example.comprass.domain.repository.ProductRepository
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CrudProductUseCaseTest {

    @Mock
    lateinit var repository: ProductRepository
    lateinit var productUseCase: CrudProductUseCase

    val user = User("Miau",1)
    val list = listOf(
        Product(1,"cafe",5.50,user.id),
        Product(2,"Açucar",6.31,user.id),
        Product(3,"leite",2.34,user.id),
        Product(4,"pizza",10.56,user.id),
        Product(5,"frutas",7.92,user.id),
    )

    @Before
    fun setUp() {
      MockitoAnnotations.openMocks(this::class.java)
        productUseCase = CrudProductUseCase(repository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getAllProduct() {
        Mockito.`when`(repository.getAllProducts()).thenReturn(
            list
        )
        val result = productUseCase.getAllProduct()

        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrThrow()).hasSize(5)
    }

    @Test
    fun findProductById() {
        Mockito.`when`(repository.findProductById(1)).thenReturn(
            list[0]
        )

        val result= productUseCase.findProductById(1)
        assertThat(result.isSuccess).isTrue()
        assertThat(result.getOrThrow().name).isEqualTo("cafe")
    }

    @Test
    fun insertProduct() {
       val product = list.get(3)
        Mockito.`when`(repository.insertProduct(product)).thenReturn(
            false
        )

        val result = productUseCase.insertProduct(product.ToProductView())
        assertThat(result.isSuccess).isTrue()
    }

    @Test
    fun delete() {
        val product = list.get(3)
        Mockito.`when`(repository.delete(product)).thenReturn(
            true
        )
        val result = productUseCase.delete(product.ToProductView())
        assertThat(result.isSuccess).isTrue()

    }
}