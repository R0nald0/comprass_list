package com.example.comprass.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "product_table",
    foreignKeys =[
        ForeignKey(entity = UserDAO::class, parentColumns = ["id_user"], childColumns = ["userId_product"])
    ]
)
data class ProductDAO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_product")
    val id :Long,
    @ColumnInfo(name = "name_product")
    val Name :String,
    @ColumnInfo(name = "price_product")
    val price :Double,
    @ColumnInfo(name = "pricePromotion_product")
    val pricePromotion :Double,
    @ColumnInfo(name = "promotion_product")
    val promotion : Boolean,
    @ColumnInfo(name = "userId_product")
    val userId: Long
    )