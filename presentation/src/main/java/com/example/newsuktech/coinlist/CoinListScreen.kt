package com.example.newsuktech.coinlist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import com.example.newsuktech.R
import com.example.newsuktech.components.CoinsContainer
import com.example.newsuktech.components.CustomToolbar
import com.example.newsuktech.components.ErrorMessageComponent
import com.example.newsuktech.components.LoadingContainer
import com.example.newsuktech.ui.theme.NewsUkTechTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun CoinListScreen(
    onCoinsDataTapped: (coinId: String) -> Unit,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val isSwipeRefreshing = remember { mutableStateOf(false) }
    val stateSwipeToRefresh = rememberSwipeRefreshState(isSwipeRefreshing.value)
    val listState = rememberLazyListState()

    SwipeRefresh(
        state = stateSwipeToRefresh,
        modifier = Modifier.fillMaxSize(),
        onRefresh = {
            viewModel.onSwipeRefreshCoins()
        },
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            snackbarHost = { /* NO-OP */ },
            containerColor = NewsUkTechTheme.colors.Background,
            content = { innerPadding ->
                LoadingContainer(
                    modifier = Modifier.padding(innerPadding),
                    state = viewModel.isLoadingState,
                    errorStateComponent = {
                        BuildTopBar(
                            onBackButtonClick = { viewModel.onSwipeRefreshCoins() },
                            showBackButton = true
                        )
                        ErrorMessageComponent()
                    },
                    readyStateComponent = {
                        BuildContent(
                            listState = listState,
                            coinDataState = viewModel.coinDataState,
                            onCoinsDataTapped = onCoinsDataTapped
                        )
                    }
                )
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
                AnimatedVisibility(
                    visible = true,
                    enter = fadeIn(animationSpec = tween(durationMillis = 500)) + expandVertically(),
                    exit = fadeOut(animationSpec = tween(durationMillis = 500)) + shrinkVertically()
                ) {
                    CoinsContainer(
                        coinDataState = coinsList[index],
                        onCoinsDataClicked = onCoinsDataTapped
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_5)))
                }
            }
        }
    }
}

@Composable
private fun BuildTopBar(
    onBackButtonClick: () -> Unit = {},
    showBackButton: Boolean = false,
) {
    CustomToolbar(
        showBackButton = showBackButton,
        onBackButtonClick = onBackButtonClick,
        title = stringResource(id = R.string.news_uk_challenge_main_title)
    )
}

@Preview(showBackground = true)
@Composable
fun BuildCoinsListPreview() {
    NewsUkTechTheme {
        CoinListScreen(
            onCoinsDataTapped = {/* NO-OP */ },
            viewModel = hiltViewModel()
        )
    }
}