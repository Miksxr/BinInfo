package com.example.bininfo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BinDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBinHistory(binHistory: BinHistory)

    @Query("SELECT * FROM binhistory ORDER BY timestamp DESC")
    suspend fun getBinHistory(): List<BinHistory>
}

