package com.codemonk.explorecryptocurrency.presentation.coin_detail

import com.codemonk.explorecryptocurrency.common.Resource
import com.codemonk.explorecryptocurrency.domain.model.Coin
import com.codemonk.explorecryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
