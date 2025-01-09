package com.example.bininfo.domain.model

import com.example.bininfo.data.local.BinHistory

data class HistoryItem(
    val id: Int,
    val bin: String,
    val country: String,
    val coordinates: String,
    val cardType: String,
    val bank: String
)

fun BinHistory.toDomainModel() = HistoryItem(
    id, bin, country, coordinates, cardType, bank
)