package com.example.comprass.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.comprass.data.local.entity.UserDAO

@Dao
interface UserDao {

      @Query("SELECT *FROM user_table")
      fun getAllUsers() : List<UserDAO>

      @Query(value = "SELECT * FROM user_table WHERE id_user =:idUser")
      fun findUserById(idUser: Long) : List<UserDAO>

      @Insert()
      fun insertUser(userDAO :UserDAO):Long

      @Delete
      fun deleteUser(userDAO: UserDAO):Int
}