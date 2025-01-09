package com.example.bininfo.domain.usecase

import com.example.bininfo.domain.model.HistoryItem
import com.example.bininfo.domain.repository.BinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHistoryUseCase @Inject constructor(private val repository: BinRepository) {
    operator fun invoke(): Flow<List<HistoryItem>> {
        return repository.getHistory()
    }
}
