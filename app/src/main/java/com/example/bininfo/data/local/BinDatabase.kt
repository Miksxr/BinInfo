package com.example.bininfo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BinHistory::class], version = 1, exportSchema = false)
abstract class BinDatabase : RoomDatabase() {
    abstract fun binDao(): BinDao
}