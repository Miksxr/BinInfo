package com.example.bininfo.data.remote.models

data class BinInfo(
    val scheme: String?,
    val type: String?,
    val brand: String?,
    val country: Country?,
    val bank: Bank?
)
