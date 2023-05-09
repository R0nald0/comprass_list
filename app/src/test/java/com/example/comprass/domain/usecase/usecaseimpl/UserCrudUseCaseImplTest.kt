package com.example.comprass.domain.usecase.usecaseimpl

import com.example.comprass.domain.model.User
import com.example.comprass.domain.repository.UserRepository
import com.example.comprass.domain.usecase.UserCrudUseCase
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UserCrudUseCaseImplTest {

    @Mock
    lateinit var repository: UserRepository
    private lateinit var useCaseImpl:UserCrudUseCase


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        useCaseImpl = UserCrudUseCaseImpl(repository)
    }

    @Test
    fun findUSerById_receiveUserIdAndReturnUser(){
        Mockito.`when`(repository.findUserById(ArgumentMatchers.anyLong())).thenReturn(
            User("Miau",1)
        )
        val result = useCaseImpl.findUSerById(1)
        val user = result.getOrThrow()
        assertThat(result.isSuccess).isTrue()
        assertThat(user.name).isEqualTo("Miau")
    }

    @Test
    fun insertUser_mostReceiveUserAndRetunsTrue(){
       val user  = User("Miau",1)
        Mockito.`when`(repository.insertUser(user)).thenReturn(
            true
        )
        val result = useCaseImpl.insertUser(user)
        assertThat(result.isSuccess).isTrue()

    }

    @Test
    fun delete_mostReceiveUserAndRetunsTrue(){
        val user  = User("Miau",1)
        Mockito.`when`(repository.delete(user)).thenReturn(
            true
        )
        val result = useCaseImpl.delete(user)
        assertThat(result.isSuccess).isTrue()
    }

    @After
    fun tearDown() {

    }
}