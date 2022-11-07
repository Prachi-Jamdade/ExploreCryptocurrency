package com.codemonk.explorecryptocurrency.domain.use_cases.get_all_coins

import com.codemonk.explorecryptocurrency.common.Resource
import com.codemonk.explorecryptocurrency.data.remote.dto.toCoin
import com.codemonk.explorecryptocurrency.domain.model.Coin
import com.codemonk.explorecryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getAllCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }
        catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        }
        catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}