package com.codemonk.explorecryptocurrency.data.remote

import com.codemonk.explorecryptocurrency.data.remote.dto.CoinDTO
import com.codemonk.explorecryptocurrency.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path


interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getAllCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinByID(@Path("coinId") coinId: String): CoinDetailDTO
}