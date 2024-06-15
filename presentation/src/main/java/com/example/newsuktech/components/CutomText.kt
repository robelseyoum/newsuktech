package com.example.newsuktech.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.newsuktech.ui.theme.NewsUkTechTheme
import com.example.newsuktech.ui.theme.Typography

@Composable
fun MULargeTitle(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = NewsUkTechTheme.colors.Titles,
    style: TextStyle = com.example.newsuktech.ui.theme.Typography.LargeTitle,
    overflow: TextOverflow = TextOverflow.Clip,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = style,
        overflow = overflow,
        maxLines = maxLines
    )
}

@Composable
fun MULargeTitleMainScreen(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = NewsUkTechTheme.colors.Titles,
        style = com.example.newsuktech.ui.theme.Typography.LargeTitleMessages
    )
}

@Composable
fun MULargeTitleCenter(
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = NewsUkTechTheme.colors.Titles,
    style: TextStyle = com.example.newsuktech.ui.theme.Typography.LargeTitle,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = style,
        textAlign = textAlign
    )
}

@Composable
fun MUGiantTitleCenter(text: String, textAlign: TextAlign = TextAlign.Center, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = NewsUkTechTheme.colors.Titles,
        style = com.example.newsuktech.ui.theme.Typography.GiantTitle,
        textAlign = textAlign
    )
}

@Composable
fun MUMediumTitle(text: String, textAlign: TextAlign = TextAlign.Start, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = NewsUkTechTheme.colors.Titles,
        style = com.example.newsuktech.ui.theme.Typography.MediumTitle,
        textAlign = textAlign
    )
}

@Composable
fun MUSmallTitle(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        color = NewsUkTechTheme.colors.Titles,
        style =  com.example.newsuktech.ui.theme.Typography.SmallTitle,
        textAlign = textAlign
    )
}

@Composable
fun MUBodyCopy(
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    modifier: Modifier = Modifier,
    color: Color = NewsUkTechTheme.colors.Titles,
    style: TextStyle =  com.example.newsuktech.ui.theme.Typography.BodyCopyRegular
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = style,
        textAlign = textAlign
    )
}

@Composable
fun MUPowerupBody(text: String, textAlign: TextAlign = TextAlign.Start, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        color = NewsUkTechTheme.colors.Titles,
        style =  com.example.newsuktech.ui.theme.Typography.MU3PowerUpBodyText,
        textAlign = textAlign
    )
}

@Composable
fun MUBodyCopyStrongWhite(text: String, modifier: Modifier = Modifier, textAlign: TextAlign = TextAlign.Start) {
    Text(
        text = text,
        modifier = modifier,
        color = NewsUkTechTheme.colors.IndicatorColor,
        style = Typography.BodyCopyStrong,
        textAlign = textAlign
    )
}

@Composable
fun MUBodyCopyStrong(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = NewsUkTechTheme.colors.Titles,
    style: TextStyle = Typography.BodyCopyStrong,
    overflow: TextOverflow = TextOverflow.Clip,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        style = style,
        overflow = overflow,
        maxLines = maxLines,
        textAlign = textAlign
    )
}

@Composable
fun MUBadgeText(
    text: String,
    textAlign: TextAlign = TextAlign.Start,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(
        text = text,
        modifier = modifier,
        color = NewsUkTechTheme.colors.Titles,
        style = Typography.BadgeText,
        textAlign = textAlign,
        fontWeight = fontWeight
    )
}

@Composable
fun MUButtonTitle(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    overFlow: TextOverflow = TextOverflow.Visible
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.ButtonTitle,
        color = NewsUkTechTheme.colors.CodingChallenge2024White,
        textAlign = textAlign,
        overflow = overFlow
    )
}

@Composable
fun MUTextTitleRegularClickable(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Text(
        text = text,
        modifier = modifier.clickable { onClick.invoke() },
        style = Typography.ButtonTitle,
        color = NewsUkTechTheme.colors.CodingChallenge2024Grey
    )
}

@Composable
fun MUTextDataTitle(text: String, modifier: Modifier = Modifier,
                    color: Color = NewsUkTechTheme.colors.CodingChallenge2024Grey) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.DataTitle,
        color = color
    )
}

@Composable
fun MUTextFieldTitleRegular(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = NewsUkTechTheme.colors.CodingChallenge2024Grey,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.DataTitleRegular,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun MURowLinkDescription(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.CustomSubTitle,
        color = NewsUkTechTheme.colors.CodingChallenge2024Grey
    )
}

@Composable
fun MUBodyLink(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = NewsUkTechTheme.colors.SkyBlue,
    textAlign: TextAlign = TextAlign.Start,
    style: TextStyle = Typography.BodyLink
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.BodyLink,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun MUTextFieldTitle(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = NewsUkTechTheme.colors.Titles
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.TextFieldTitle,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun MUTextUsageTotalsValues(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = NewsUkTechTheme.colors.Titles
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.UsageTotalsSemiBold,
        color = color,
        textAlign = textAlign
    )
}

@Composable
fun MUTextFieldTitleRegular(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.TextFieldRegular,
        color = NewsUkTechTheme.colors.Titles,
        textAlign = textAlign
    )
}

@Composable
fun MUTextEstimatedText(
    text: String,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.EstimatedText,
        color = NewsUkTechTheme.colors.CodingChallenge2024Grey,
        textAlign = textAlign
    )
}

@Composable
fun MUFieldPlaceholder(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.FieldPlaceholder,
        color = NewsUkTechTheme.colors.PlaceHolderField
    )
}

@Composable
fun MUPromoTitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.MU3PromoCardTitle,
        color = NewsUkTechTheme.colors.colorCardTitle
    )
}

@Composable
fun MUChartTempMetric(
    text: String,
    modifier: Modifier = Modifier,
    isTabletDevice: Boolean,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        text = text,
        modifier = modifier,
        style = if (isTabletDevice) {
            Typography.MU3PromoCardTitle.copy(fontSize = 16.sp)
        } else {
            Typography.MU3PromoCardTitle
        },
        color = NewsUkTechTheme.colors.Titles,
        textAlign = textAlign
    )
}

@Composable
fun MUPromoDescription(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = Typography.MU3PromoCardDescription,
        color = NewsUkTechTheme.colors.Titles
    )
}

@Composable
fun MUClickableText(
    textBefore: String? = null,
    textLink: String,
    textAfter: String? = null,
    modifier: Modifier = Modifier,
    textAlign: TextStyle = Typography.BodyCopyRegular,
    textLinkColor: Color = NewsUkTechTheme.colors.SkyBlue,
    onClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        textBefore?.let {
            withStyle(
                style = SpanStyle(
                    color = NewsUkTechTheme.colors.Titles
                )
            ) {
                append(it)
            }
        }

        pushStringAnnotation(
            tag = textLink,
            annotation = textLink
        )

        withStyle(
            style = SpanStyle(
                color = textLinkColor,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            append(" $textLink")
        }

        textAfter?.let {
            withStyle(
                style = SpanStyle(
                    color = NewsUkTechTheme.colors.Titles
                )
            ) {
                append(it)
            }
        }

        pop()
    }

    ClickableText(
        text = annotatedText,
        style = textAlign,
        modifier = modifier,
        onClick = { offset ->
            var stringRange = annotatedText.getStringAnnotations(
                tag = textLink,
                start = offset,
                end = offset
            )
            if (stringRange.isNotEmpty()) {
                stringRange[0]?.let {
                    onClick.invoke()
                }
            }
        }
    )
}