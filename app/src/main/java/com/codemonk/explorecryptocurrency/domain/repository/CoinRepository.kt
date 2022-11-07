package com.codemonk.explorecryptocurrency.domain.repository

import com.codemonk.explorecryptocurrency.data.remote.dto.CoinDTO
import com.codemonk.explorecryptocurrency.data.remote.dto.CoinDetailDTO

interface CoinRepository {
    suspend fun getAllCoins(): List<CoinDTO>

    suspend fun getCoinByID(coinId: String): CoinDetailDTO
}