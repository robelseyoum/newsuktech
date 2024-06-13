package com.example.newsuktech.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
        composable(route = ScreenNav.CoinListScreen.route) {
            CoinListScreen()
        }
    }
}