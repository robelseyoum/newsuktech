package com.example.newsuktech.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.data.utilities.Constants.Companion.COIN_ID
import com.example.newsuktech.coindetail.CoinDetailScreen
import com.example.newsuktech.coinlist.CoinListScreen

@Composable
fun MainNavigation(
    navController: NavHostController = rememberNavController()
) {
    //todo for coin detail screen navigation
    NavHost(
        navController = navController,
        startDestination = ScreenNav.CoinListScreen.route
    ) {
        composable(
            route = ScreenNav.CoinListScreen.route
        ) {
            CoinListScreen(
                onGoToCoinDetails = { id ->
                    navController.navigate(
                        ScreenNav.CoinDetailScreen.route.plus("/$id")
                    )
                }
            )
        }

        composable(
            route = ScreenNav.CoinDetailScreen.route.plus(("/{$COIN_ID}")),
            arguments = listOf(navArgument(COIN_ID) { type = NavType.StringType })
        ) {
            CoinDetailScreen(
                coinId = requireNotNull(it.arguments?.getString(COIN_ID)),
                onBackPressed = { navController.navigateUp() }
            )
        }
    }
}