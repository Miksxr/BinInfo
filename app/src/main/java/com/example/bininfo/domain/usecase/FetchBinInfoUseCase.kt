package com.example.bininfo.domain.usecase

import com.example.bininfo.domain.model.BinInfoModel
import com.example.bininfo.domain.repository.BinRepository
import javax.inject.Inject

class FetchBinInfoUseCase @Inject constructor(private val repository: BinRepository) {
    suspend operator fun invoke(bin: String): BinInfoModel {
        return repository.fetchBinInfo(bin)
    }
}