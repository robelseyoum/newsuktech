package com.example.newsuktech.components

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.domain.model.CoinDataState
import com.example.newsuktech.R
import com.example.newsuktech.ui.theme.NewsUkTechTheme
import com.example.newsuktech.ui.theme.Typography

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CoinDetailContainer(
    coinDataState: CoinDataState,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(id = R.dimen.spacing_20),
                end = dimensionResource(id = R.dimen.spacing_20)
            )
    ) {
        coinDataState.coinsData?.let { coinData ->
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(top = dimensionResource(id = R.dimen.spacing_16))
                ) {
                    Text(
                        text = coinData.name,
                        overflow = TextOverflow.Ellipsis,
                        color = NewsUkTechTheme.colors.Titles,
                        style = Typography.LargeTitleMessages,
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.spacing_16))
                        .align(Alignment.CenterEnd),
                ) {
                    GlideImage(
                        model = Uri.parse(coinData.logo),
                        contentDescription = "",
                        modifier = Modifier
                            .width(dimensionResource(id = R.dimen.spacing_48))
                            .height(dimensionResource(id = R.dimen.spacing_48))
                            .clip(shape = CircleShape),
                    ) {
                        it.error(R.drawable.ic_launcher_foreground)
                            .transition(DrawableTransitionOptions.withCrossFade())
                            .fitCenter()
                            .load(Uri.parse(coinData.logo))
                    }
                }
            }
            Divider(color = NewsUkTechTheme.colors.divider)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.spacing_10))
                    .fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.weight(weight = 8f),
                    verticalArrangement = Arrangement.Center
                ) {

                    androidx.compose.material.Text(
                        text = "Symbol",
                        style = Typography.SmallTitle,
                        color = NewsUkTechTheme.colors.Titles,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(top = dimensionResource(id = R.dimen.spacing_4))
                            .semantics { contentDescription = "" }
                    )

                    androidx.compose.material.Text(
                        text = "Rank",
                        style = Typography.SmallTitle,
                        color = NewsUkTechTheme.colors.Titles,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(bottom = dimensionResource(R.dimen.spacing_1))
                            .semantics { contentDescription = "" }
                    )

                    androidx.compose.material.Text(
                        text = "Platform",
                        style = Typography.SmallTitle,
                        color = NewsUkTechTheme.colors.Titles,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(bottom = dimensionResource(R.dimen.spacing_1))
                            .semantics { contentDescription = "" }
                    )
                }

                Column(
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = coinData.symbol,
                        style = Typography.BodyCopy,
                        color = NewsUkTechTheme.colors.CodingChallenge2024Grey,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(top = dimensionResource(id = R.dimen.spacing_4))
                            .semantics {
                                contentDescription = ""
                            }
                    )

                    androidx.compose.material.Text(
                        text = coinData.rank.toString(),
                        style = Typography.BodyCopy,
                        color = NewsUkTechTheme.colors.CodingChallenge2024Grey,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(top = dimensionResource(id = R.dimen.spacing_10))
                            .semantics {
                                contentDescription = ""
                            }
                    )

                    Text(
                        text = coinData.platform ?: "Unknown",
                        style = Typography.BodyCopy,
                        color = NewsUkTechTheme.colors.CodingChallenge2024Grey,
                        textAlign = TextAlign.Left,
                        modifier = Modifier
                            .padding(top = dimensionResource(id = R.dimen.spacing_8))
                            .semantics {
                                contentDescription = ""
                            }
                    )
                }
            }

            Text(
                modifier = Modifier
                    .padding(top = dimensionResource(id = R.dimen.spacing_16)),
                text = coinData.description ?: "It doesn't have a description",
                color = NewsUkTechTheme.colors.Titles,
                style = Typography.BodyCopyRegular,
            )
        }
    }
}