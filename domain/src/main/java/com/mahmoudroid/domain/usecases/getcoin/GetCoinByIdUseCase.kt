package com.mahmoudroid.domain.usecases.getcoin

import com.mahmoudroid.domain.core.Results
import com.mahmoudroid.domain.model.Coin
import com.mahmoudroid.domain.model.CoinDetail
import com.mahmoudroid.domain.repository.CoinRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class GetCoinByIdUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Results<CoinDetail>> = flow {
        try {
            val coin = repository.getCoinById(coinId)
            emit(Results.Success(coin))
        } catch (e: IOException) {
            emit(Results.Failure(e))
        } catch (e: Exception) {
            emit(Results.Failure(e))
        }
    }
}