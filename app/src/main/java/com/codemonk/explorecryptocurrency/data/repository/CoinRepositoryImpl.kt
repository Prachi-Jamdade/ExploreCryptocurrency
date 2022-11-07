package com.codemonk.explorecryptocurrency.data.repository

import com.codemonk.explorecryptocurrency.data.remote.CoinPaprikaAPI
import com.codemonk.explorecryptocurrency.data.remote.dto.CoinDTO
import com.codemonk.explorecryptocurrency.data.remote.dto.CoinDetailDTO
import com.codemonk.explorecryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaAPI
): CoinRepository {
    override suspend fun getAllCoins(): List<CoinDTO> {
        return api.getAllCoins()
    }

    override suspend fun getCoinByID(coinId: String): CoinDetailDTO {
        return api.getCoinByID(coinId)
    }
}