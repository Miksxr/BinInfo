package com.example.bininfo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BinHistory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bin: String,
    val info: String,
    val timestamp: Long
)