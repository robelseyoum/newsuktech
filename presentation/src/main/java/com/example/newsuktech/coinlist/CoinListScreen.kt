package com.example.newsuktech.coinlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.CoinDataState
import com.example.domain.model.LoadingState
import com.example.newsuktech.R
import com.example.newsuktech.components.CoinsContainer
import com.example.newsuktech.components.CustomToolbar
import com.example.newsuktech.components.LoadingContainer
import com.example.newsuktech.ui.theme.NewsUkTechTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun CoinListScreen(
    onCoinsDataTapped: (coinId: String) -> Unit,
    viewModel: CoinListViewModel = hiltViewModel()
) {

    val isLoadingState = remember { mutableStateOf(false) }
    val isSwipeRefreshing = remember { mutableStateOf(false) }
    val stateSwipeToRefresh = rememberSwipeRefreshState(isSwipeRefreshing.value)
    val listState = rememberLazyListState()

    isLoadingState.value = viewModel.isLoadingState == LoadingState.LOADING

    SwipeRefresh(
        state = stateSwipeToRefresh,
        onRefresh = { viewModel.onSwipeRefreshCoins() }
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            snackbarHost = { /* NO-OP */ },
            containerColor = MaterialTheme.colorScheme.background,
            content = { innerPadding ->
                LoadingContainer(
                    isLoading = isLoadingState.value,
                    modifier = Modifier.padding(innerPadding),
                ) {
                    BuildContent(
                        listState = listState,
                        coinDataState = viewModel.coinDataState,
                        onCoinsDataTapped = onCoinsDataTapped
                    )
                }
            }
        )
    }
}


@Composable
private fun BuildContent(
    listState: LazyListState,
    coinDataState: MutableList<CoinDataState>?,
    onCoinsDataTapped: (id: String) -> Unit,
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                bottom = dimensionResource(id = R.dimen.spacing_20),
            )
    ) {
        BuildTopBar()
        Text(
            text = "Paprika Coins",
            modifier = Modifier.padding(dimensionResource(id = R.dimen.spacing_20)),
            color = NewsUkTechTheme.colors.Titles,
            style = com.example.newsuktech.ui.theme.Typography.LargeTitleMessages,
        )
        androidx.compose.material.Text(
            text = "Active".uppercase(),
            modifier = Modifier.padding(start = dimensionResource(id = R.dimen.spacing_20)),
            style = com.example.newsuktech.ui.theme.Typography.CustomSubTitle,
            color = NewsUkTechTheme.colors.CodingChallenge2024Grey
        )
        BuildCoinsList(
            listState = listState,
            coinDataState = coinDataState,
            onCoinsDataTapped = onCoinsDataTapped
        )
    }
}

@Composable
fun BuildCoinsList(
    listState: LazyListState,
    coinDataState: MutableList<CoinDataState>?,
    onCoinsDataTapped: (id: String) -> Unit
) {
    coinDataState?.let { coinsList ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = dimensionResource(id = R.dimen.spacing_10))
        ) {
            items(coinsList.size) { index ->
                CoinsContainer(
                    coinDataState = coinsList[index],
                    onCoinsDataClicked = onCoinsDataTapped
                )
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_5)))
            }
        }
    }
}

@Composable
private fun BuildTopBar() {
    CustomToolbar(
        title = stringResource(id = R.string.news_uk_challenge_main_title)
    )
}

@Preview(showBackground = true)
@Composable
fun BuildCoinsListPreview() {
    NewsUkTechTheme {
        CoinListScreen(
            onCoinsDataTapped = {},
            viewModel = hiltViewModel()
        )
    }
}