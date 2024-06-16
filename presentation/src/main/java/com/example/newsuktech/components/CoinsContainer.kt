package com.example.newsuktech.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.data.utilities.Constants.Companion.EMPTY
import com.example.domain.model.CoinDataState
import com.example.newsuktech.R
import com.example.newsuktech.ui.theme.NewsUkTechTheme

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
            .clickable(onClick = {
                onCoinsDataClicked.invoke(coinDataState.coinsData?.id ?: EMPTY)
            })
    ) {
        Divider(color = NewsUkTechTheme.colors.divider)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(id = R.dimen.spacing_15),
                    end = dimensionResource(id = R.dimen.spacing_20)
                )
                .height(dimensionResource(R.dimen.spacing_68))
        ) {
            coinDataState.coinsData?.let {
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
                        text = stringResource(id = R.string.coins_list_title_name),
                        style = com.example.newsuktech.ui.theme.Typography.SmallTitle,
                        color = NewsUkTechTheme.colors.Titles,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(bottom = dimensionResource(R.dimen.spacing_1))
                    )

                    //Coin type Title
                    androidx.compose.material.Text(
                        text = stringResource(id = R.string.coins_list_title_type),
                        style = com.example.newsuktech.ui.theme.Typography.MU3PowerUpBodyText,
                        color = NewsUkTechTheme.colors.Titles,
                        textAlign = TextAlign.Left,
                    )
                }
                Column(
                    modifier = Modifier.padding(end = dimensionResource(R.dimen.spacing_15)),
                    verticalArrangement = Arrangement.Center
                ) {
                    //Coin Name  value
                    Text(
                        text = it.name,
                        style = com.example.newsuktech.ui.theme.Typography.FAQsQuestions,
                        color = NewsUkTechTheme.colors.Titles,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(bottom = dimensionResource(R.dimen.spacing_1))
                    )
                    //Coin type value
                    androidx.compose.material.Text(
                        text = it.type,
                        style = com.example.newsuktech.ui.theme.Typography.MU3PowerUpBodyText,
                        color = NewsUkTechTheme.colors.Titles,
                        textAlign = TextAlign.Left,
                    )
                }
                //Arrow
                Image(
                    painter = painterResource(id = R.drawable.ic_chevron_right),
                    contentDescription = EMPTY
                )
            }
        }
    }
}