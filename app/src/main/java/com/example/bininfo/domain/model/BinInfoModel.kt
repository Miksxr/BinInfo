package com.example.bininfo.domain.model

data class BinInfoModel(
    val scheme: String?,
    val type: String?,
    val bankName: String?,
    val bankUrl: String?,
    val bankPhone: String?,
    val countryName: String?,
    val latitude: Double?,
    val longitude: Double?
)