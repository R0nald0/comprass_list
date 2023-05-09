package com.example.comprass.data.repository

import com.example.comprass.data.local.helper.ComprasDatabase
import com.example.comprass.domain.model.User
import com.example.comprass.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val db : ComprasDatabase
) : UserRepository {
    override fun getAllUser(): List<User> {
        TODO("Not yet implemented")
    }

    override fun findUserById(idUser: Long): User {
        TODO("Not yet implemented")
    }

    override fun insertUser(user: User): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(user: User): Boolean {
        TODO("Not yet implemented")
    }

}
