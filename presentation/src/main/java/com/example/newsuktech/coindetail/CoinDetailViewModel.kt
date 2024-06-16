package com.example.newsuktech.coindetail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.utilities.Constants
import com.example.domain.interactors.coindetailusecase.GetCoinDetailUseCase
import com.example.domain.model.CoinData
import com.example.domain.model.CoinDataState
import com.example.domain.model.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailUsecase: GetCoinDetailUseCase
) : ViewModel() {

    private var loadJob: Job? = null

    var isLoadingState by mutableStateOf(LoadingState.NONE)
        private set

    var coinDataState by mutableStateOf(CoinDataState())
        private set


    fun innitCoinDetail(id: String) {
        fetchCoinDetail(id = id)
    }

    private fun fetchCoinDetail(id: String) {
        updateLoadingState(LoadingState.LOADING)
        loadJob?.cancel()
        loadJob = viewModelScope.launch(Constants.requestIODispatchers) {
            getCoinDetailUsecase.invoke(id).catch {
                updateLoadingState(LoadingState.ERROR)
            }.collectLatest { result ->
                result?.let {
                    updateCoinDetailsDataState(it)
                    updateLoadingState(LoadingState.READY)
                }
            }
        }
    }

    private fun updateCoinDetailsDataState(coinData: CoinData) {
        coinDataState = coinDataState.copy(
            coinsData = coinData
        )
    }

    private fun updateLoadingState(loadingState: LoadingState) {
        viewModelScope.launch(Constants.requestMainDispatchers) {
            isLoadingState = loadingState
        }
    }
}