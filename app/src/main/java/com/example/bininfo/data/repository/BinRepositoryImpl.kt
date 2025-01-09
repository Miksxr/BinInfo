package com.example.bininfo.data.repository

import com.example.bininfo.data.local.BinDao
import com.example.bininfo.data.local.BinHistory
import com.example.bininfo.data.remote.BinApi
import com.example.bininfo.domain.model.BinInfoModel
import com.example.bininfo.domain.model.HistoryItem
import com.example.bininfo.domain.model.toDomainModel
import com.example.bininfo.domain.model.toEntity
import com.example.bininfo.domain.repository.BinRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BinRepositoryImpl @Inject constructor(
    private val api: BinApi,
    private val dao: BinDao
) : BinRepository {
    override suspend fun fetchBinInfo(bin: String): BinInfoModel {
        val response = api.getBinInfo(bin)
        val model = response.toDomainModel()
        dao.insert(model.toEntity(bin))
        return model
    }

    override fun getHistory(): Flow<List<HistoryItem>> {
        return dao.getAll().map { list ->
            list.map { it.toDomainModel() }
        }
    }
}