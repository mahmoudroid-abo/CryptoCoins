package com.mahmoudroid.domain.repository

import com.mahmoudroid.domain.model.Coin
import com.mahmoudroid.domain.model.CoinDetail

interface CoinRepository {
    suspend fun getCoins(): List<Coin>
    suspend fun getCoinById(coinId: String): CoinDetail
}
