package com.codemonk.explorecryptocurrency.di

import com.codemonk.explorecryptocurrency.common.Constants
import com.codemonk.explorecryptocurrency.data.remote.CoinPaprikaAPI
import com.codemonk.explorecryptocurrency.data.repository.CoinRepositoryImpl
import com.codemonk.explorecryptocurrency.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCoinPaprikaAPI(): CoinPaprikaAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}