package com.example.comprass.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.comprass.data.local.entity.UserDAO
import com.example.comprass.data.local.helper.ComprasDatabase
import com.google.common.truth.Truth.assertThat

import org.junit.After
import org.junit.Before
import org.junit.Test


class UserDAODaoTest {

    private lateinit var comprassDatabase : ComprasDatabase
    private lateinit var  userDao : UserDao

    @Before
    fun setUp() {
        comprassDatabase = Room.inMemoryDatabaseBuilder(
             ApplicationProvider.getApplicationContext(),
            ComprasDatabase::class.java
        ).allowMainThreadQueries().build()

        userDao = comprassDatabase.userDao()
    }

    @Test
    fun insertUser_createUserAndRetunrOne() {
        val userDAO = UserDAO(0,"Miau")
        val resInser = userDao.insertUser(userDAO)
         assertThat(resInser).isGreaterThan(0)
    }

    @Test
    fun getAllUsers_getAllUserAndReturnListUsers(){
        val userDAO = UserDAO(0,"Miau")
        userDao.insertUser(userDAO)

        val result =userDao.getAllUsers()
        assertThat(result).hasSize(1)
    }
    @Test
    fun findUserById_receiveIdUserAndReturnListUserWithOneUser(){
        val userDAO = UserDAO(0,"Miau")
        userDao.insertUser(userDAO)

        val result = userDao.findUserById(1)

        assertThat(result).hasSize(1)
    }

    @Test
    fun delete_receiveIdUserAndReturnZero(){
         val userDAO = UserDAO(0,"Miau")
         val resDelete = userDao.deleteUser(userDAO)
         assertThat(resDelete).isEqualTo(0)
    }

    @After
    fun tearDown() {
        comprassDatabase.close()
    }
}