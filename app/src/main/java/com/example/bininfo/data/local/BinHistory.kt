package com.example.bininfo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_history")
data class BinHistory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bin: String,
    val country: String,
    val coordinates: String,
    val cardType: String,
    val bank: String,
    val timestamp: Long = System.currentTimeMillis()
)