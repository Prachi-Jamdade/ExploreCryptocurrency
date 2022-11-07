package com.codemonk.explorecryptocurrency.domain.use_cases.get_single_coin

import com.codemonk.explorecryptocurrency.common.Resource
import com.codemonk.explorecryptocurrency.data.remote.dto.toCoin
import com.codemonk.explorecryptocurrency.data.remote.dto.toCoinDetail
import com.codemonk.explorecryptocurrency.domain.model.Coin
import com.codemonk.explorecryptocurrency.domain.model.CoinDetail
import com.codemonk.explorecryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSingleCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoinByID(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }
        catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
        catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}