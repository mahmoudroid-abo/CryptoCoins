package com.mahmoudroid.cryptocoins.views.coindetails

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahmoudroid.cryptocoins.common.Constants.PARAM_COIN_ID
import com.mahmoudroid.cryptocoins.views.CoinDetailsState
import com.mahmoudroid.domain.core.Results
import com.mahmoudroid.domain.model.CoinDetail
import com.mahmoudroid.domain.usecases.getcoin.GetCoinByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinByIdUseCase: GetCoinByIdUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID).let { coinId->
            getCoins(coinId.toString())
        }
    }


    private fun getCoins(coinId: String) {
        getCoinByIdUseCase(coinId)
            .onEach { result: Results<CoinDetail> ->
                when (result) {
                    is Results.Success -> {
                        _state.value = CoinDetailsState(coins = result.data)
                    }
                    is Results.Failure -> {
                        // update state with result.throwable
                        _state.value = CoinDetailsState(error = result.throwable.message ?: "Unknown error")
                    }
                    is Results.Loading -> {
                        // update state with result.data
                        _state.value = CoinDetailsState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)
    }
}