package com.example.newsuktech.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.newsuktech.R
import com.example.newsuktech.ui.theme.NewsUkTechTheme
import com.example.newsuktech.ui.theme.Typography

@Composable
fun ErrorMessageComponent() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            text = "Whoops! something went wrong.",
            color = NewsUkTechTheme.colors.Titles,
            style = Typography.LargeTitleMessages,
            textAlign = TextAlign.Center,
        )

        Text(
            text = "Sorry, we can't get coins information",
            overflow = TextOverflow.Ellipsis,
            color = NewsUkTechTheme.colors.Titles,
            style = Typography.BlockLinkDescription,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = dimensionResource(id = R.dimen.spacing_10)),
        )
    }
}