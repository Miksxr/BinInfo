package com.example.bininfo.di

import android.content.Context
import androidx.room.Room
import com.example.bininfo.data.local.BinDao
import com.example.bininfo.data.local.BinDatabase
import com.example.bininfo.data.remote.BinApi
import com.example.bininfo.data.repository.BinRepositoryImpl
import com.example.bininfo.domain.repository.BinRepository
import com.example.bininfo.domain.usecase.FetchBinInfoUseCase
import com.example.bininfo.domain.usecase.GetHistoryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BinDatabase {
        return BinDatabase.getInstance(context)
    }

    @Provides
    fun provideBinDao(database: BinDatabase): BinDao {
        return database.binDao()
    }

    @Provides
    @Singleton
    fun provideBinApi(): BinApi {
        return Retrofit.Builder()
            .baseUrl(BinApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinApi::class.java)
    }

    @Provides
    @Singleton
    fun provideBinRepository(api: BinApi, dao: BinDao): BinRepository {
        return BinRepositoryImpl(api, dao)
    }
}
