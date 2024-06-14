package com.example.newsuktech.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.newsuktech.navigation.MainNavigation
import com.example.newsuktech.ui.theme.NewsUkTechTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsUkTechTheme {
                MainNavigation()
            }
        }
    }
}

