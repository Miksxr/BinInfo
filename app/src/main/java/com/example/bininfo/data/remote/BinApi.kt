package com.example.bininfo.data.remote

import com.example.bininfo.data.remote.models.BinInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface BinApi {
    @GET("/{bin}")
    suspend fun getBinInfo(@Path("bin") bin: String): BinInfo
}