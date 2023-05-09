package com.example.comprass.domain.usecase

import com.example.comprass.domain.model.User

interface UserCrudUseCase {
    fun  getAllUser():Result<List<User>>
    fun  findUSerById(idUser : Long):Result<User>
    fun  insertUser( user:User):Result<Boolean>
    fun  delete( user: User):Result<Boolean>
}