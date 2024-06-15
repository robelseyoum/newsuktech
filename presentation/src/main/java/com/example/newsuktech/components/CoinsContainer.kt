package com.example.newsuktech.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.newsuktech.ui.theme.NewsUkTechTheme
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import com.example.domain.model.CoinDataState
import com.example.newsuktech.R

@Composable
fun CoinsContainer(
    coinDataState: CoinDataState,
    onCoinsDataClicked: (id: String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.spacing_15),
                end = dimensionResource(id = R.dimen.spacing_20)
            )
            .clickable(onClick = {
                onCoinsDataClicked.invoke(coinDataState.coinsData?.id ?: "")
            })
    ) {
        Divider(color = NewsUkTechTheme.colors.divider)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(dimensionResource(R.dimen.spacing_68))
        ) {
            Column(
                modifier = Modifier
                    .padding(
                        top = dimensionResource(R.dimen.spacing_15),
                        bottom = dimensionResource(R.dimen.spacing_15)
                    )
                    .weight(weight = 8f)
            ) {
                //Coin Name Title
                Text(
                    text = "Coin Name",
                    style = com.example.newsuktech.ui.theme.Typography.SmallTitle,
                    color = NewsUkTechTheme.colors.Titles,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(bottom = dimensionResource(R.dimen.spacing_1))
                        .semantics { contentDescription = "" }
                )

                //Coin type Title
                androidx.compose.material.Text(
                    text = "Coin Type",
                    style = com.example.newsuktech.ui.theme.Typography.MU3PowerUpBodyText,
                    color = NewsUkTechTheme.colors.Titles,
                    textAlign = TextAlign.Left,
                    modifier = Modifier.semantics {
                        contentDescription = ""
                    }
                )
            }
            Column(
                modifier = Modifier.padding(end = dimensionResource(R.dimen.spacing_9)),
                verticalArrangement = Arrangement.Center
            ) {
                coinDataState.coinsData?.let {
                    //Coin Name  value
                    Text(
                        text = it.name,
                        style = com.example.newsuktech.ui.theme.Typography.SmallTitle,
                        color = NewsUkTechTheme.colors.Titles,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(bottom = dimensionResource(R.dimen.spacing_1))
                            .semantics { contentDescription = "" }
                    )
                    //Coin type value
                    androidx.compose.material.Text(
                        text = it.type,
                        style = com.example.newsuktech.ui.theme.Typography.MU3PowerUpBodyText,
                        color = NewsUkTechTheme.colors.Titles,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.semantics {
                            contentDescription = ""
                        }
                    )
                }
            }
        }
    }
}