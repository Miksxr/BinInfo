package com.example.bininfo.domain.usecase

import com.example.bininfo.data.local.BinHistory
import com.example.bininfo.domain.repository.BinRepository

class GetHistoryUseCase(private val repository: BinRepository) {
    suspend operator fun invoke(): List<BinHistory> {
        return repository.getHistory()
    }
}