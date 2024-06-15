package com.example.newsuktech.ui.theme


import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.newsuktech.R

val GilroyFontFamily = FontFamily(
    Font(R.font.gilroymedium, FontWeight.Medium),
    Font(R.font.gilroybold, FontWeight.Bold),
    Font(R.font.gilroysemibold, FontWeight.SemiBold),
    Font(R.font.gilroyregular, FontWeight.Normal)
)

object Typography {

    val SubTitle = TextStyle(
        fontSize = 12.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val SmallTitle = TextStyle(
        fontSize = 18.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val MediumTitle = TextStyle(
        fontSize = 24.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val LargeTitle = TextStyle(
        fontSize = 32.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val LargeTitleMessages = TextStyle(
        fontSize = 30.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val GiantTitle = TextStyle(
        fontSize = 40.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val ButtonTitle = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val ListTileTitle = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val ListTileMessage = TextStyle(
        fontSize = 14.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Normal
    )

    val FAQsQuestions = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val BodyCopy = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium
    )

    val BodyCopyRegular = TextStyle(
        lineHeight = 20.sp,
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Normal
    )

    val BodyCopyRegularCentered = TextStyle(
        lineHeight = 20.sp,
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center
    )

    val BodyCopyStrong = TextStyle(
        lineHeight = 20.sp,
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val BlockLinkTitle = TextStyle(
        lineHeight = 22.sp,
        fontSize = 18.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val BlockLinkDescription = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium
    )

    val BodyLink = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val PromoCardDescription = TextStyle(
        fontSize = 12.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val MU3PromoCardTitle = TextStyle(
        lineHeight = 16.sp,
        fontSize = 12.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val MU3PowerUpBodyText = TextStyle(
        lineHeight = 14.sp,
        fontSize = 12.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Normal
    )

    val MU3PromoCardDescription = TextStyle(
        lineHeight = 24.sp,
        fontSize = 20.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val DataTitle = TextStyle(
        fontSize = 13.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )
    val DataTitleRegular = TextStyle(
        lineHeight = 17.sp,
        fontSize = 13.sp,
        fontFamily = GilroyFontFamily
    )

    val TableCellsButtons = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val NoInternetCopy = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium
    )

    val EstimatedText = TextStyle(
        fontSize = 13.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium
    )

    val MU2NoInternetCopy = TextStyle(
        lineHeight = 16.sp,
        fontSize = 14.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium
    )

    val stateSubText = TextStyle(
        fontSize = 12.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium
    )

    val CustomSubTitle = TextStyle(
        fontSize = 14.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val FriendlyCreditEntryButtonText = TextStyle(
        fontSize = 14.sp,
        lineHeight = 14.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val CarbonFootPrintContent = TextStyle(
        fontSize = 20.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val TextFieldTitle = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val TextFieldRegular = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Normal
    )

    val FieldPlaceholder = TextStyle(
        fontSize = 16.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Normal
    )

    val BigDetailSemiBold = TextStyle(
        fontSize = 28.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 52.sp
    )

    val CarbonFootPrintSemiBold = TextStyle(
        fontSize = 28.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 28.sp
    )

    val UsageTotalsSemiBold = TextStyle(
        fontSize = 28.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp
    )

    val BodyCopySmall = TextStyle(
        fontSize = 12.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium
    )

    val Greetings = TextStyle(
        fontSize = 28.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium,
        lineHeight = 16.sp
    )

    val Avatar = TextStyle(
        fontSize = 28.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Black
    )

    val BadgeText = TextStyle(
        fontSize = 10.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Bold
    )

    val WeeklyScoreCardDate = TextStyle(
        fontSize = 10.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Medium
    )

    val BadgeMediumText = TextStyle(
        fontSize = 14.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Bold
    )

    val TextListSmall = TextStyle(
        fontSize = 18.sp,
        lineHeight = 9.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val TextTitleSmall = TextStyle(
        fontSize = 18.sp,
        lineHeight = 22.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold
    )

    val LargeTitlePrize = TextStyle(
        fontSize = 30.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 38.sp
    )

    val LargeTitleRefer = TextStyle(
        fontSize = 34.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 38.sp
    )

    val LargeTitlePreSign = TextStyle(
        fontSize = 45.sp,
        fontFamily = GilroyFontFamily,
        fontWeight = FontWeight.Bold,
        lineHeight = 45.sp
    )
}
