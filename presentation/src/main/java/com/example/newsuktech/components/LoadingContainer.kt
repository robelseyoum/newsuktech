package com.example.newsuktech.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.domain.model.LoadingState

@Composable
fun LoadingContainer(
    state: LoadingState,
    modifier: Modifier = Modifier,
    loadingStateComponent: @Composable () -> Unit = {
        Box(modifier = modifier) {
            LoadingView()
        }
    },
    errorStateComponent: @Composable () -> Unit,
    readyStateComponent: @Composable () -> Unit,
) {
    when (state) {
        LoadingState.READY -> readyStateComponent()
        LoadingState.LOADING -> loadingStateComponent()
        LoadingState.ERROR -> errorStateComponent()
        else -> { /*NO-OP*/ }
    }
}

@Composable
fun LoadingView(modifier: Modifier = Modifier) {
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color(1f, 1f, 1f, 0.5f))
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) { }
    ) {
        CircularProgressIndicator(color = Color.Black)
    }
}
