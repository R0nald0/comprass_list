package com.example.comprass.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName ="user_table"
)
data class UserDAO (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_user")
    val id :Long,
    @ColumnInfo(name = "name_user")
    val name :String,
)