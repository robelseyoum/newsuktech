package com.example.newsuktech.coinlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.utilities.Constants.Companion.requestDispatchers
import com.example.domain.interactors.coinsusecase.GetCoinsUsecase
import com.example.domain.model.CoinData
import com.example.domain.model.CoinDataState
import com.example.domain.model.LoadingState
import com.example.newsuktech.utilities.extensions.mapToCollection
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUsecase: GetCoinsUsecase
) : ViewModel() {

    private val lock = Any()
    private var loadJob: Job? = null

    var isLoadingState by mutableStateOf(LoadingState.NONE)
        private set

    var coinDataState = mutableStateListOf(CoinDataState())

    init {
        fetchCoins()
    }

    fun onSwipeRefreshCoins() {
        fetchCoins()
    }

    private fun fetchCoins() {
        updateLoadingState(LoadingState.LOADING)
        loadJob?.cancel()
        loadJob = viewModelScope.launch(requestDispatchers) {
            getCoinsUsecase.invoke().catch {
                updateLoadingState(LoadingState.ERROR)
            }.collectLatest { result ->
                result?.let {
                    updateCoinsDataState(it)
                    updateLoadingState(LoadingState.READY)
                }
            }
        }
    }

    private fun updateCoinsDataState(coinDataList: List<CoinData>) {
        val filteredActiveCoins = coinDataList
            .filter { it.isActive }
            .sortedBy { it.name }
            .take(200)
        coinDataState.clear()
        coinDataState.addAll(mapToCollection(filteredActiveCoins))

    }

    private fun updateLoadingState(loadingState: LoadingState) {
        synchronized(lock) {
            isLoadingState = loadingState
        }
    }
}