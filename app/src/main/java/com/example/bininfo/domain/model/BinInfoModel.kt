package com.example.bininfo.domain.model

import com.example.bininfo.data.local.BinHistory
import com.example.bininfo.data.remote.models.BinInfo

data class BinInfoModel(
    val country: String,
    val coordinates: String,
    val cardType: String,
    val bank: String
)

fun BinInfo.toDomainModel() = BinInfoModel(
    country = this.country?.name ?: "Unknown",
    coordinates = "${this.country?.latitude}, ${this.country?.longitude}",
    cardType = this.type ?: "Unknown",
    bank = this.bank?.name ?: "Unknown"
)

fun BinInfoModel.toEntity(bin: String): BinHistory {
    return BinHistory(
        bin = bin,
        country = this.country,
        coordinates = this.coordinates,
        cardType = this.cardType,
        bank = this.bank
    )
}