package com.example.bininfo.domain.repository

import com.example.bininfo.data.local.BinHistory
import com.example.bininfo.domain.model.BinInfoModel
import com.example.bininfo.domain.model.HistoryItem
import kotlinx.coroutines.flow.Flow

interface BinRepository {
    suspend fun fetchBinInfo(bin: String): BinInfoModel
    fun getHistory(): Flow<List<HistoryItem>>
}