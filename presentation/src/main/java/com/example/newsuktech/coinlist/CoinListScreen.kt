package com.example.newsuktech.coinlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsuktech.ui.theme.NewsUkTechTheme


@Composable
fun CoinListScreen(
    onGoToCoinDetails: (coinId: String) -> Unit,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    // A surface container using the 'background' color from the theme
    val coinDataState = viewModel.coinDataState

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting(coinDataState.firstOrNull()?.coinsData?.id ?: "")
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