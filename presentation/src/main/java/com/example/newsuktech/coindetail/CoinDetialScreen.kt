package com.example.newsuktech.coindetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.CoinDataState
import com.example.newsuktech.R
import com.example.newsuktech.components.CoinDetailContainer
import com.example.newsuktech.components.CustomToolbar
import com.example.newsuktech.components.ErrorMessageComponent
import com.example.newsuktech.components.LoadingContainer
import com.example.newsuktech.ui.theme.NewsUkTechTheme

@Composable
fun CoinDetailScreen(
    coinId: String,
    viewModel: CoinDetailViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {

    val coinDataState = viewModel.coinDataState

    LaunchedEffect(coinId) {
        viewModel.fetchCoinDetail(coinId)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        snackbarHost = { /* NO-OP */ },
        containerColor = MaterialTheme.colorScheme.background,
        content = { innerPadding ->
            LoadingContainer(
                modifier = Modifier.padding(innerPadding),
                state = viewModel.isLoadingState,
                errorStateComponent = {
                    BuildTopBar(onBackButtonClick = onBackPressed)
                    ErrorMessageComponent()
                },
                readyStateComponent = {
                    BuildContent(
                        coinDataState = coinDataState,
                        onBackButtonClick = onBackPressed,
                    )
                }
            )
        }
    )
}

@Composable
private fun BuildContent(
    coinDataState: CoinDataState,
    onBackButtonClick: (() -> Unit)
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = dimensionResource(id = R.dimen.spacing_20))
    ) {
        BuildTopBar(onBackButtonClick)
        CoinDetailContainer(coinDataState)
    }
}

@Composable
private fun BuildTopBar(onBackButtonClick: (() -> Unit)) {
    CustomToolbar(
        onBackButtonClick = onBackButtonClick,
        showBackButton = true,
        title = stringResource(id = R.string.news_uk_challenge_main_title_detail_title)
    )
}

@Preview(showBackground = true)
@Composable
fun CoinDetailScreenPreview() {
    NewsUkTechTheme {
        CoinDetailScreen(
            coinId = "",
            viewModel = hiltViewModel(),
            onBackPressed = {},
        )
    }
}