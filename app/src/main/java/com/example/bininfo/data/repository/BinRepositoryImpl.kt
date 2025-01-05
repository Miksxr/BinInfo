package com.example.bininfo.data.repository

import com.example.bininfo.data.local.BinDao
import com.example.bininfo.data.local.BinHistory
import com.example.bininfo.data.remote.BinApi
import com.example.bininfo.domain.model.BinInfoModel
import com.example.bininfo.domain.repository.BinRepository

class BinRepositoryImpl(
    private val binApi: BinApi,
    private val binDao: BinDao
) : BinRepository {
    override suspend fun fetchBinInfo(bin: String): BinInfoModel {
        val response = binApi.getBinInfo(bin)
        val model = BinInfoModel(
            scheme = response.scheme,
            type = response.type,
            bankName = response.bank?.name,
            bankUrl = response.bank?.url,
            bankPhone = response.bank?.phone,
            countryName = response.country?.name,
            latitude = response.country?.latitude,
            longitude = response.country?.longitude
        )
        binDao.insertBinHistory(BinHistory(bin = bin, info = model.toString(), timestamp = System.currentTimeMillis()))
        return model
    }

    override suspend fun getHistory(): List<BinHistory> {
        return binDao.getBinHistory()
    }
}