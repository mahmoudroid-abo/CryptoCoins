package com.mahmoudroid.cryptocoins.views

import com.mahmoudroid.domain.model.CoinDetail

class CoinDetailsState(
    val isLoading: Boolean = false,
    val coins: CoinDetail? = null,
    val error: String = ""
)