package com.example.comprass.domain.repository

import com.example.comprass.domain.model.User

interface UserRepository {
    fun getAllUser():List<User>
    fun findUserById(idUser:Long):User
    fun insertUser(user: User):Boolean
    fun delete(user: User):Boolean
}