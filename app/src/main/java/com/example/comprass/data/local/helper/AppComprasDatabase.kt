package com.example.comprass.data.local.helper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.comprass.data.local.dao.ProductDao
import com.example.comprass.data.local.dao.UserDao
import com.example.comprass.data.local.entity.ProductDAO
import com.example.comprass.data.local.entity.UserDAO

@Database(
    entities = [UserDAO::class,ProductDAO::class],
    version = 1,
)
 abstract class ComprasDatabase :RoomDatabase() {
    abstract fun userDao():UserDao
    abstract fun productDao():ProductDao

    companion object{
           var instancie : ComprasDatabase? = null

        fun getDataBase(context: Context):ComprasDatabase{
            return instancie ?: Room.databaseBuilder(
                context,
                ComprasDatabase::class.java,
                "appComprassDatabase.db"
            ).build()
        }
    }
}