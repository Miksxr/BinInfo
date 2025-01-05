package com.example.bininfo.domain.repository

import com.example.bininfo.data.local.BinHistory
import com.example.bininfo.domain.model.BinInfoModel

interface BinRepository {
    suspend fun fetchBinInfo(bin: String): BinInfoModel
    suspend fun getHistory(): List<BinHistory>
}