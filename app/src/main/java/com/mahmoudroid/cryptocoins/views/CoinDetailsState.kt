package com.mahmoudroid.cryptocoins.views

import com.mahmoudroid.domain.model.CoinDetail

class CoinDetailsState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)