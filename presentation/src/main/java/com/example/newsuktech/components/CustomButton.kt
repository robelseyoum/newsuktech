package com.example.newsuktech.components

import androidx.annotation.DimenRes
import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.domain.model.LoadingState
import com.example.newsuktech.R
import com.example.newsuktech.ui.theme.NewsUkTechTheme
import com.example.newsuktech.ui.theme.Shapes

@Preview
@Composable
fun previewMUTextButton() {
    MUTextButton(
        title = "MUTextButton",
        textColor = Color.Black,
        backgroundColor = Color.LightGray
    ) {}
}

@Composable
fun MUTextButton(
    model: MUButtonModel,
    modifier: Modifier = Modifier,
    isInsideButton: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    model.title?.let {
        MUTextButton(
            title = stringResource(id = it),
            style = model.style,
            modifier = modifier,
            isInsideButton = isInsideButton,
            enabled = enabled,
            onClick = onClick
        )
    }

    model.titleStr?.let {
        MUTextButton(
            title = it,
            style = model.style,
            modifier = modifier,
            isInsideButton = isInsideButton,
            enabled = enabled,
            onClick = onClick
        )
    }
}

@Composable
fun MUTextButton(
    isInsideButton: Boolean = false,
    loadingStateNextButton: LoadingState = LoadingState.READY,
    title: String,
    style: MUButtonStyle,
    compactMode: Boolean = false,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    style.customColors = NewsUkTechTheme.colors

    MUTextButton(
        isInsideButton = isInsideButton,
        loadingStateNextButton = loadingStateNextButton,
        title = title,
        textColor = style.getTextColor(),
        backgroundColor = style.getBackgroundColor(),
        compactMode = compactMode,
        contentPadding = contentPadding,
        modifier = modifier,
        onClick = onClick,
        enabled = enabled
    )
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun MUTextButton(
    isInsideButton: Boolean = false,
    loadingStateNextButton: LoadingState = LoadingState.READY,
    title: String,
    modifier: Modifier = Modifier,
    textColor: Color = Color.Black,
    backgroundColor: Color = Color.LightGray,
    compactMode: Boolean = false,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {

    MUBaseButton(
        backgroundColor = if (loadingStateNextButton == LoadingState.LOADING) {
            Color.LightGray
        } else {
            backgroundColor
        },
        onClick = onClick,
        compactMode = compactMode,
        contentPadding = contentPadding,
        enabled = if (loadingStateNextButton == LoadingState.LOADING) {
            false
        } else {
            enabled
        },
        content = {
            LoadingContainer(
                isLoading = (loadingStateNextButton == LoadingState.LOADING),
                modifier = Modifier.padding(),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(
                        text = title,
                        style = com.example.newsuktech.ui.theme.Typography.ButtonTitle,
                        maxLines = 1,
                        color = textColor,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }

    )
}

@Composable
fun MUIconButton(
    icon: Int,
    style: MUButtonStyle,
    contentScale: ContentScale = ContentScale.FillHeight,
    compactMode: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    style.customColors = NewsUkTechTheme.colors

    MUIconButton(
        icon = icon,
        iconTint = style.getTextColor(),
        backgroundColor = style.getBackgroundColor(),
        contentScale = contentScale,
        compactMode = compactMode,
        modifier = modifier,
        onClick = onClick
    )
}

@Composable
fun MUIconButton(
    icon: Int,
    iconTint: Color = Color.Black,
    backgroundColor: Color = Color.LightGray,
    contentScale: ContentScale = ContentScale.FillHeight,
    compactMode: Boolean = false,
    @DimenRes roundDimen: Int = R.dimen.spacing_4,
    modifier: Modifier = Modifier,
    imagePadding: Dp = dimensionResource(R.dimen.spacing_4),
    elevation: ButtonElevation? = ButtonDefaults.elevation(
        defaultElevation = dimensionResource(id = R.dimen.spacing_0),
        pressedElevation = dimensionResource(id = R.dimen.spacing_0),
        disabledElevation = dimensionResource(id = R.dimen.spacing_0)
    ),
    onClick: () -> Unit = {}
) {
    MUBaseButton(
        backgroundColor = backgroundColor,
        onClick = onClick,
        elevation = elevation,
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.spacing_0)),
        compactMode = compactMode,
        roundDimen = roundDimen,
        modifier = modifier,
        content = {
            Image(
                painterResource(icon),
                colorFilter = ColorFilter.tint(iconTint),
                contentDescription = "",
                contentScale = contentScale,
                modifier = Modifier.padding(imagePadding)
            )
        }
    )
}

@Composable
fun MUTextButtonWithIcon(
    title: String,
    icon: Int,
    iconTint: Color? = Color.White,
    backgroundColor: Color = NewsUkTechTheme.colors.GreyButton,
    contentScale: ContentScale = ContentScale.FillHeight,
    compactMode: Boolean = false,
    @DimenRes roundDimen: Int = R.dimen.spacing_4,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    textAlign: TextAlign = TextAlign.Start,
    onClick: () -> Unit = {}
) {
    MUBaseButton(
        backgroundColor = backgroundColor,
        onClick = onClick,
        elevation = elevation,
        contentPadding = PaddingValues(0.dp),
        compactMode = compactMode,
        roundDimen = roundDimen,
        modifier = modifier,
        content = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painterResource(icon),
                    colorFilter = if (iconTint != null) ColorFilter.tint(iconTint) else null,
                    contentDescription = "",
                    contentScale = contentScale,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.spacing_16),
                        top = dimensionResource(R.dimen.spacing_14)
                    )
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(end = 20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MUBodyCopyStrongWhite(
                        text = title,
                        modifier = textModifier
                            .fillMaxWidth(),
                        textAlign = textAlign
                    )
                }
            }
        }
    )
}

@Composable
fun MUTextButtonOutlineBorderWithRightIcon(
    title: String,
    icon: Int,
    iconTint: Color = NewsUkTechTheme.colors.SkyBlue,
    contentScale: ContentScale = ContentScale.FillHeight,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    onClick: () -> Unit = {}
) {
    val modifierValue = Modifier
        .border(
            width = dimensionResource(id = R.dimen.spacing_2),
            color = NewsUkTechTheme.colors.SkyBlue,
            shape = Shapes.RoundedCorner5
        )
        .background(color = NewsUkTechTheme.colors.checkBoxBackground)
        .clickable { onClick.invoke() }
        .height(dimensionResource(id = R.dimen.spacing_50))

    Row(
        modifier = modifierValue
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                MUBodyLink(
                    text = title,
                    modifier = textModifier
                        .fillMaxWidth(),
                    textAlign = textAlign
                )
            }
            Column(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .fillMaxHeight()
                    .padding(end = dimensionResource(id = R.dimen.spacing_16)),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painterResource(icon),
                    colorFilter = ColorFilter.tint(iconTint),
                    contentDescription = "",
                    contentScale = contentScale
                )
            }
        }
    }
}

@Composable
fun MUTextButtonWithRightIcon(
    title: String,
    icon: Int,
    iconTint: Color = Color.White,
    backgroundColor: Color = NewsUkTechTheme.colors.SkyBlue,
    contentScale: ContentScale = ContentScale.FillHeight,
    compactMode: Boolean = false,
    @DimenRes roundDimen: Int = R.dimen.spacing_4,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    elevation: ButtonElevation? = ButtonDefaults.elevation(
        defaultElevation = dimensionResource(R.dimen.spacing_0),
        pressedElevation = dimensionResource(R.dimen.spacing_0),
        disabledElevation = dimensionResource(R.dimen.spacing_0),
        hoveredElevation = dimensionResource(R.dimen.spacing_0),
        focusedElevation = dimensionResource(R.dimen.spacing_0)
    ),
    textAlign: TextAlign = TextAlign.Start,
    onClick: () -> Unit = {}
) {
    MUBaseButton(
        backgroundColor = backgroundColor,
        onClick = onClick,
        elevation = elevation,
        contentPadding = PaddingValues(dimensionResource(R.dimen.spacing_0)),
        compactMode = compactMode,
        roundDimen = roundDimen,
        modifier = modifier,
        content = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    MUBodyCopyStrongWhite(
                        text = title,
                        modifier = textModifier
                            .fillMaxWidth(),
                        textAlign = textAlign
                    )
                }
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = dimensionResource(R.dimen.spacing_18))
                ) {
                    Image(
                        painterResource(icon),
                        colorFilter = ColorFilter.tint(iconTint),
                        contentDescription = "",
                        contentScale = contentScale
                    )
                }
            }
        }
    )
}

@Composable
fun MUBaseButton(
    content: @Composable () -> Unit,
    backgroundColor: Color = Color.LightGray,
    contentPadding: PaddingValues,
    compactMode: Boolean = false,
    @DimenRes roundDimen: Int = R.dimen.spacing_4,
    modifier: Modifier = Modifier,
    elevation: ButtonElevation? = ButtonDefaults.elevation(
        defaultElevation = 0.dp,
        pressedElevation = 0.dp,
        disabledElevation = 0.dp,
        hoveredElevation = 0.dp,
        focusedElevation = 0.dp
    ),
    enabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = { onClick.invoke() },
        contentPadding = contentPadding,
        elevation = elevation,
        colors = ButtonDefaults.textButtonColors(backgroundColor = backgroundColor),
        modifier = modifier.composed {
            clip(RoundedCornerShape(dimensionResource(roundDimen)))
            height(
                dimensionResource(
                    if (compactMode) R.dimen.spacing_40 else R.dimen.spacing_52
                )
            )
        },
        enabled = enabled
    ) {
        content()
    }
}
