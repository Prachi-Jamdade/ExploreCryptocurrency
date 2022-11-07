package com.codemonk.explorecryptocurrency.presentation.coin_list

import com.codemonk.explorecryptocurrency.common.Resource
import com.codemonk.explorecryptocurrency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
