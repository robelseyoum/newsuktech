package com.example.newsuktech.coindetail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsuktech.ui.theme.NewsUkTechTheme

@Composable
fun CoinDetailScreen(
    coinId: String,
    viewModel: CoinDetailViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    // A surface container using the 'background' color from the theme
    val coinDataState = viewModel.coinDataState

    LaunchedEffect(coinId) {
        viewModel.innitCoinDetail(coinId)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting(coinDataState.coinsData?.name ?: "")
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsUkTechTheme {
        Greeting("Android")
    }
}