package com.example.comprass.domain.usecase.usecaseimpl

import com.example.comprass.domain.model.User
import com.example.comprass.domain.repository.UserRepository
import com.example.comprass.domain.usecase.UserCrudUseCase
import javax.inject.Inject

class UserCrudUseCaseImpl @Inject constructor(
     private val repository: UserRepository
) : UserCrudUseCase {
    override fun getAllUser(): Result<List<User>> {
        TODO("Not yet implemented")
    }

    override fun findUSerById(idUser:Long): Result<User> {
         try {
             val user = repository.findUserById(idUser)
             return Result.success(user)
         }catch (e : Throwable){
             e.printStackTrace()
             return Result.failure(Throwable("Nenhum usuario com esse identificador",e))
         }
    }

    override fun insertUser(user: User): Result<Boolean> {
        try {
            val result = repository.insertUser(user)
            if (result) return  Result.success(result)
            else return Result.failure(Throwable("Usuario não cadastrado verifique os campos"))
        }catch (e :Throwable){
            e.printStackTrace()
            return Result.failure(Throwable("erro ao cadastrar o usuario",e))
        }
    }

    override fun delete(user: User): Result<Boolean> {
         try {
             val result = repository.delete(user)
             if (result) return  Result.success(result)
             else return Result.failure(Throwable("Usuario não deletado"))
         }catch (e:Throwable){
             e.printStackTrace()
             return Result.failure(Throwable("falha ao deletar usuario",e))
         }
    }


}