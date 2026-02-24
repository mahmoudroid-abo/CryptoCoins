package com.mahmoudroid.cryptocoins.views.coinlist

import com.mahmoudroid.domain.model.Coin

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
