package com.mahmoudroid.data.repositoryImpl

import com.mahmoudroid.cryptocurrency.data.remote.dto.toCoinDetail
import com.mahmoudroid.data.remote.CoinPaprikaApi
import com.mahmoudroid.data.remote.dto.toCoin
import com.mahmoudroid.domain.model.Coin
import com.mahmoudroid.domain.model.CoinDetail
import com.mahmoudroid.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
       return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return api.getCoinById(coinId).toCoinDetail()

    }
}