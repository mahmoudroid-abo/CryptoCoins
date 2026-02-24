package com.mahmoudroid.cryptocoins.views.coinlist

import androidx.lifecycle.ViewModel
import com.mahmoudroid.domain.usecases.coinsList.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.mahmoudroid.domain.core.Results
import com.mahmoudroid.domain.model.Coin
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }


    private fun getCoins() {
        getCoinsUseCase()
            .onEach { result: Results<List<Coin>> ->
                when (result) {
                    is Results.Success -> {
                        // update state with result.data
                        _state.value = CoinListState(coins = result.data ?: emptyList())
                    }
                    is Results.Failure -> {
                        // update state with result.throwable
                        _state.value = CoinListState(error = result.throwable.message ?: "Unknown error")
                    }
                    is Results.Loading -> {
                        // update state with result.data
                        _state.value = CoinListState(isLoading = true)
                    }
                }
            }
            .launchIn(viewModelScope)
    }
}