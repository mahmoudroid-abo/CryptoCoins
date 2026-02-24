package com.mahmoudroid.domain.usecases.coinsList

import com.mahmoudroid.domain.core.Results
import com.mahmoudroid.domain.model.Coin
import com.mahmoudroid.domain.repository.CoinRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository) {
    operator fun invoke(): Flow<Results<List<Coin>>> = flow {
        try {
            val coins = repository.getCoins()
            emit(Results.Success(coins))
        } catch (e: IOException) {
            emit(Results.Failure(e))
        } catch (e: Exception) {
            emit(Results.Failure(e))
        }
    }
}
