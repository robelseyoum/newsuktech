package com.example.newsuktech.components

import androidx.annotation.DimenRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.newsuktech.R
import com.example.newsuktech.ui.theme.NewsUkTechTheme


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
