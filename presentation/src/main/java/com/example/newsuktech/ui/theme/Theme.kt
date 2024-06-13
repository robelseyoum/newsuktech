package com.example.newsuktech.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)
val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val CodingChallenge2024White = Color(0xeFFFFFFFF)
val SkyBlue = Color(0xeFF00B0FF)
val BlueEllipse = Color(0xeFF1E87E5)
val BlueEllipseDarker = Color(0xeFF186cb7)
val LeafGreen = Color(0xFF00E676)
val FiredRed = Color(0xFFFF3D00)
val TomatoRed = Color(0xFFE63700)
val FriendlyCreditRed = Color(0xFFD62839)
val SparkYellow = Color(0xFFFDD835)
val RatingExcellent = Color(0xFF00BFA5)
val RatingGood = Color(0xFF00E676)
val HourlyUsageStatus = Color(0xFF01bfa5)
val RatingAverage = Color(0xFFFFD600)
val UnSelectedElecBarChartDarkmode = Color(0xFF655615)
val UnSelectedElecBarChartLightmode = Color(0xFFfeefae)
val UnSelectedGasBarChartLightMode = Color(0xFFb4e7ff)
val UnSelectedGasBarChartDarkMode = Color(0xFF004666)
val RatingPoor = Color(0xFFFF9100)
val BackgroundLight = Color(0xFFFFFFFF)
val BackgroundDark = Color(0xFF000000)
val CardBackgroundLight = Color(0xFFFFFFFF)
val CardBackgroundDark = Color(0xFF2B2C2F)
val CardBackgroundLightMUThree = Color(0xFFF8F8F8)
val CardBackgroundDarkMUThree = Color(0xFF333333)
val CardBorderLightMUThree = Color(0xFFe0e0e0)
val CardBorderDarkMUThree = Color(0xFF333333)
val TitlesLight = Color(0xFF000000)
val TitlesDark = Color(0xFFFFFFFF)
val BodyCopyLight = Color(0xFF757575)
val BodyCopyDark = Color(0xFFCCCCCC)
val GreyButtonLighter = Color(0xFFF5F5F5)
val GreyButtonLight = Color(0xFFBDBDBD)
val GreyButtonDarker = Color(0xFF333333)
val GreyButtonDark = Color(0xFF656668)
val GreyButtonStyleLight = Color(0xFFBDBDBD)
val GreyButtonStyleDark = Color(0xFF656668)
val IndicatorLight = Color(0xFFCCCCCC)
val IndicatorDark = Color(0xFF656668)
val CheckBoxLight = Color(0xFFFFFFFF)
val CheckBoxDark = Color(0xFF000000)
val FormBackgroundLight = Color(0xFFFFFFFF)
val FormBackgroundDark = Color(0xFF484848)
val BorderLight = Color(0xFFFFFFFF)
val BorderDark = Color(0xFF46474D)
val RewardCardBackgroundLight = Color(0xFFF8F8F8)
val RewardCardBackgroundDark = Color(0xFF333333)
val RatingContainerLight = Color(0xFFFFFFFF)
val RatingContainerDark = Color(0xFF151515)
val ChooseAnAmountLight = Color(0xFFF5F5F5)
val ChooseAnAmountDark = Color(0xFF484848)
val PlaceHolderField = Color(0xFF9E9E9E)
val CodingChallenge2024GreenDark = Color(0xFF00C853)
val DividerMU2Light = Color(0xffF4F4F6)
val DividerLight = Color(0xFFDDDDDD)
val DividerMU2Dark = Color(0xff46474D)
val DividerDark = Color(0xFF3C3C3C)
val CodingChallenge2024GreyLight = Color(0xFF757575)
val CodingChallenge2024GreyDark = Color(0xFFB3B3B3)
val BaseDialogBackgroundColorLight = Color(0xFFFFFFFF)
val BaseDialogBackgroundColorDark = Color(0xFF333333)
val CodingChallenge2024Grey = Color(0xFF8E8E8E)
val LightSilver = Color(0xFFBDBDBD)
val CommonTextFieldForeground = Color(0xFF9E9E9E)
val CommonDayModeTextFieldBackground = Color(0xFFF8F8F8)
val CommonNightModeTextFieldBackground = Color(0xFF333333)
val HighContrastDayModeTextFieldForeground = Color(0xFF000000)
val HighContrastNightModeTextFieldForeground = Color(0xFFFFFFFF)
val HighContrastDayModeTextFieldBackground = Color(0xFFFFFFFF)
val HighContrastNightModeTextFieldBackground = Color(0xFF000000)
val LightYellow = Color(0xFFFEF3C2)
val LightBlueLight = Color(0xFFE5F7FF)
val LightBlueDark = Color(0xFF00354C)
val LightGrey01 = Color(0xFFF8F8F8)
val DarkGrey01 = Color(0xFF333333)
val VisaBackground = Color(0xFF0123A0)
val CalendarValidDayLight = Color(0xFFD9F3FF)
val CalendarValidDayDark = Color(0xFF005880)
val CalendarInvalidDay = Color(0xFFF5F5F5)
val PreSignCardLight = Color(0xFFF5F5F5)
val PreSignCardDark = Color(0xFF2B2B2B)
val BarcodeCardBackgroundLight = Color(0xFFF8F8F8)
val BarcodeCardBackgroundDark = Color(0xFFFFFFFF)
val LabelBoxLight = Color(0xFFF8F8F8)
val LabelBoxDark = Color(0xFF000000)
val FriendlyCreditBackgroundRedLight = Color(0xFFF7D4D7)
val FriendlyCreditBackgroundRedDark = Color(0xFF561017)
val FriendlyCreditBackgroundGreenLight = Color(0xFFE6FAEE)
val FriendlyCreditBackgroundGreenDark = Color(0xFF003C19)
val EmergencyCreditDark = Color(0xFF4A4A4A)
val EmergencyCreditElec = Color(0xFFFAE37D)
val EmergencyCreditGas = Color(0xFFB3E7FF)
val ThumbColor = Color(0xfff0f0f0)
val PersonaliseYourSmartScoreLight = Color(0xFFe5e5e5)
val PersonaliseYourSmartScoreDark = Color(0xFF484848)
val UpgradeCardBackgroundLight = Color(0xFFF8F8F8)
val UpgradeCardBackgroundDark = Color(0xFF2B2C2F)
val RafBottomRectLight = Color(0xFFe0e0e0)
val RafBottomRectDark = Color(0xFF191919)
val EmergencyCreditActivatingBoxLight = Color(0xFFCCEFFF)
val EmergencyCreditActivatingBoxDark = Color(0xFF002333)
val EmergencyCreditGray = Color(0xFF868686)
val DateBoxLight = Color(0xFFf5f5f5)
val DateBoxDark = Color(0xFF333333)

private val LightColorPalette = NewsUkTechColors(
    BlackOrWhite = Color.Black,
    WhiteOrBlack = Color.White,
    CodingChallenge2024White = CodingChallenge2024White,
    SkyBlue = SkyBlue,
    BlueEllipse = BlueEllipse,
    BlueEllipseDarker = BlueEllipseDarker,
    LeafGreen = LeafGreen,
    FiredRed = FiredRed,
    SparkYellow = SparkYellow,
    TomatoRed = TomatoRed,
    RatingExcellent = RatingExcellent,
    RatingGood = RatingGood,
    RatingAverage = RatingAverage,
    RatingPoor = RatingPoor,
    Background = BackgroundLight,
    CardBackground = CardBackgroundLight,
    CardBackgroundNew = CardBackgroundLightMUThree,
    Titles = TitlesLight,
    BodyCopy = BodyCopyLight,
    GreyButton = GreyButtonLight,
    IndicatorColor = IndicatorLight,
    FormBackground = FormBackgroundLight,
    Border = BorderLight,
    RatingContainer = RatingContainerLight,
    rewardCardBackground = RewardCardBackgroundLight,
    ChooseAnAmount = ChooseAnAmountLight,
    PlaceHolderField = PlaceHolderField,
    colorSmartScoreHistoryTitle = BodyCopyLight,
    colorSmartScoreHistorySubTitle = TitlesLight,
    colorCardTitle = CodingChallenge2024GreyLight,
    colorCarbonFootprintAccessCardTitle = CodingChallenge2024GreyLight,
    primaryButton = SkyBlue,
    completeButton = CodingChallenge2024GreenDark,
    deleteButton = FiredRed,
    secondaryButton = GreyButtonLight,
    lightButton = GreyButtonLighter,
    divider = DividerLight,
    dividerMU2 = DividerMU2Light,
    baseDialogBackground = BaseDialogBackgroundColorLight,
    selectAllButton = GreyButtonLighter,
    CodingChallenge2024Grey = CodingChallenge2024Grey,
    checkBoxBackground = CheckBoxLight,
    visaBackground = VisaBackground,
    chatWithUsColor = LightBlueLight,
    calendarValidDayLight = CalendarValidDayLight,
    calendarValidDayDark = CalendarValidDayDark,
    calendarInvalidDay = CalendarInvalidDay,
    commonDayModeTextFieldBackground = CommonDayModeTextFieldBackground,
    commonNightModeTextFieldBackground = CommonNightModeTextFieldBackground,
    barcodeCardBackground = BarcodeCardBackgroundLight,
    labelBox = LabelBoxLight,
    chartElecLineUnselected = UnSelectedElecBarChartLightmode,
    chartGasLineUnselected = UnSelectedGasBarChartLightMode,
    personaliseYourSmartScore = PersonaliseYourSmartScoreLight,
    greyButtonStyle = GreyButtonStyleLight,
    upgradeCardBackground = UpgradeCardBackgroundLight,
    rafBottomRect = RafBottomRectLight,
    preSignCard = PreSignCardLight,
    cardBorder = CardBorderLightMUThree,
    FriendlyCreditBackgroundRed = FriendlyCreditBackgroundRedLight,
    FriendlyCreditBackgroundGreen = FriendlyCreditBackgroundGreenLight,
    emergencyCreditGas = EmergencyCreditGas,
    emergencyCreditElec = EmergencyCreditElec,
    emergencyCreditActivatingBox = EmergencyCreditActivatingBoxLight,
    emergencyCreditGray = EmergencyCreditGray,
    isDark = false
)

private val DarkColorPalette = NewsUkTechColors(
    BlackOrWhite = Color.White,
    WhiteOrBlack = Color.Black,
    CodingChallenge2024White = CodingChallenge2024White,
    SkyBlue = SkyBlue,
    BlueEllipse = BlueEllipse,
    BlueEllipseDarker = BlueEllipseDarker,
    LeafGreen = LeafGreen,
    FiredRed = FiredRed,
    SparkYellow = SparkYellow,
    TomatoRed = TomatoRed,
    RatingExcellent = RatingExcellent,
    RatingGood = RatingGood,
    RatingAverage = RatingAverage,
    RatingPoor = RatingPoor,
    Background = BackgroundDark,
    CardBackground = CardBackgroundDark,
    CardBackgroundNew = CardBackgroundDarkMUThree,
    Titles = TitlesDark,
    BodyCopy = BodyCopyDark,
    GreyButton = GreyButtonDark,
    IndicatorColor = IndicatorDark,
    FormBackground = FormBackgroundDark,
    Border = BorderDark,
    RatingContainer = RatingContainerDark,
    rewardCardBackground = RewardCardBackgroundDark,
    ChooseAnAmount = ChooseAnAmountDark,
    PlaceHolderField = PlaceHolderField,
    colorSmartScoreHistoryTitle = CodingChallenge2024GreenDark,
    colorSmartScoreHistorySubTitle = FormBackgroundDark,
    colorCardTitle = CodingChallenge2024GreyDark,
    colorCarbonFootprintAccessCardTitle = CodingChallenge2024GreyDark,
    primaryButton = SkyBlue,
    completeButton = CodingChallenge2024GreenDark,
    deleteButton = FiredRed,
    secondaryButton = GreyButtonDark,
    lightButton = GreyButtonDarker,
    divider = DividerDark,
    dividerMU2 = DividerMU2Dark,
    baseDialogBackground = BaseDialogBackgroundColorDark,
    selectAllButton = SkyBlue,
    CodingChallenge2024Grey = CodingChallenge2024Grey,
    checkBoxBackground = CheckBoxDark,
    visaBackground = VisaBackground,
    calendarValidDayLight = CalendarValidDayLight,
    calendarValidDayDark = CalendarValidDayDark,
    calendarInvalidDay = CalendarInvalidDay,
    commonNightModeTextFieldBackground = CommonNightModeTextFieldBackground,
    commonDayModeTextFieldBackground = CommonDayModeTextFieldBackground,
    chatWithUsColor = LightBlueDark,
    barcodeCardBackground = BarcodeCardBackgroundDark,
    labelBox = LabelBoxDark,
    chartElecLineUnselected = UnSelectedElecBarChartDarkmode,
    chartGasLineUnselected = UnSelectedGasBarChartDarkMode,
    personaliseYourSmartScore = PersonaliseYourSmartScoreDark,
    greyButtonStyle = GreyButtonStyleDark,
    upgradeCardBackground = UpgradeCardBackgroundDark,
    rafBottomRect = RafBottomRectDark,
    preSignCard = PreSignCardDark,
    cardBorder = CardBorderDarkMUThree,
    FriendlyCreditBackgroundRed = FriendlyCreditBackgroundRedDark,
    FriendlyCreditBackgroundGreen = FriendlyCreditBackgroundGreenDark,
    emergencyCreditGas = EmergencyCreditDark,
    emergencyCreditElec = EmergencyCreditDark,
    emergencyCreditActivatingBox = EmergencyCreditActivatingBoxDark,
    emergencyCreditGray = EmergencyCreditGray,
    isDark = true
)

private object NewsUkTechThemeRippleTheme : RippleTheme {
    @Composable
    override fun defaultColor(): Color = CodingChallenge2024Theme.colors.GreyButton

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        Color.Black,
        lightTheme = !isSystemInDarkTheme()
    )
}

@Composable
fun NewsUkTechTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = if (useDarkTheme) DarkColorPalette else LightColorPalette

    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Purple40.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = useDarkTheme
        }
    }

    ProvideNewsUkTechColors(colors) {
      MaterialTheme {
            CompositionLocalProvider(
                LocalRippleTheme provides NewsUkTechThemeRippleTheme,
                content = content
            )
        }
    }
}


object CodingChallenge2024Theme {
    val colors: NewsUkTechColors
        @Composable
        get() = LocalNewsUkTechColors.current
}

@Stable
class NewsUkTechColors(
    BlackOrWhite: Color,
    WhiteOrBlack: Color,
    CodingChallenge2024White: Color,
    SkyBlue: Color,
    BlueEllipse: Color,
    BlueEllipseDarker: Color,
    LeafGreen: Color,
    FiredRed: Color,
    SparkYellow: Color,
    TomatoRed: Color,
    RatingExcellent: Color,
    RatingGood: Color,
    RatingAverage: Color,
    RatingPoor: Color,
    Background: Color,
    CardBackground: Color,
    CardBackgroundNew: Color,
    Titles: Color,
    BodyCopy: Color,
    GreyButton: Color,
    IndicatorColor: Color,
    FormBackground: Color,
    Border: Color,
    RatingContainer: Color,
    rewardCardBackground: Color,
    ChooseAnAmount: Color,
    PlaceHolderField: Color,
    colorSmartScoreHistoryTitle: Color,
    colorSmartScoreHistorySubTitle: Color,
    colorCardTitle: Color,
    colorCarbonFootprintAccessCardTitle: Color,
    primaryButton: Color,
    completeButton: Color,
    deleteButton: Color,
    secondaryButton: Color,
    lightButton: Color,
    divider: Color,
    dividerMU2: Color,
    baseDialogBackground: Color,
    selectAllButton: Color,
    CodingChallenge2024Grey: Color,
    checkBoxBackground: Color,
    visaBackground: Color,
    chatWithUsColor: Color,
    calendarValidDayLight: Color,
    calendarValidDayDark: Color,
    calendarInvalidDay: Color,
    commonDayModeTextFieldBackground: Color,
    commonNightModeTextFieldBackground: Color,
    barcodeCardBackground: Color,
    labelBox: Color,
    chartElecLineUnselected: Color,
    chartGasLineUnselected: Color,
    personaliseYourSmartScore: Color,
    greyButtonStyle: Color,
    upgradeCardBackground: Color,
    rafBottomRect: Color,
    preSignCard: Color,
    cardBorder: Color,
    FriendlyCreditBackgroundRed: Color,
    FriendlyCreditBackgroundGreen: Color,
    emergencyCreditGas: Color,
    emergencyCreditElec: Color,
    emergencyCreditActivatingBox: Color,
    emergencyCreditGray: Color,
    isDark: Boolean
) {
    var BlackOrWhite by mutableStateOf(BlackOrWhite)
        private set
    var WhiteOrBlack by mutableStateOf(WhiteOrBlack)
        private set
    var CodingChallenge2024White by mutableStateOf(CodingChallenge2024White)
        private set
    var SkyBlue by mutableStateOf(SkyBlue)
        private set
    var BlueEllipse by mutableStateOf(BlueEllipse)
        private set
    var BlueEllipseDarker by mutableStateOf(BlueEllipseDarker)
        private set
    var LeafGreen by mutableStateOf(LeafGreen)
        private set
    var FiredRed by mutableStateOf(FiredRed)
        private set
    var SparkYellow by mutableStateOf(SparkYellow)
        private set
    var TomatoRed by mutableStateOf(TomatoRed)
        private set
    var RatingExcellent by mutableStateOf(RatingExcellent)
        private set
    var RatingGood by mutableStateOf(RatingGood)
        private set
    var RatingAverage by mutableStateOf(RatingAverage)
        private set
    var RatingPoor by mutableStateOf(RatingPoor)
        private set
    var Background by mutableStateOf(Background)
        private set
    var CardBackground by mutableStateOf(CardBackground)
        private set
    var CardBackgroundNew by mutableStateOf(CardBackgroundNew)
        private set
    var Titles by mutableStateOf(Titles)
        private set
    var BodyCopy by mutableStateOf(BodyCopy)
        private set
    var GreyButton by mutableStateOf(GreyButton)
        private set
    var IndicatorColor by mutableStateOf(GreyButton)
        private set
    var FormBackground by mutableStateOf(FormBackground)
        private set
    var Border by mutableStateOf(Border)
        private set
    var RatingContainer by mutableStateOf(RatingContainer)
        private set
    var ChooseAnAmount by mutableStateOf(ChooseAnAmount)
        private set
    var PlaceHolderField by mutableStateOf(PlaceHolderField)
        private set
    var colorSmartScoreHistoryTitle by mutableStateOf(colorSmartScoreHistoryTitle)
        private set
    var colorSmartScoreHistorySubTitle by mutableStateOf(colorSmartScoreHistorySubTitle)
        private set
    var primaryButton by mutableStateOf(primaryButton)
        private set
    var completeButton by mutableStateOf(completeButton)
        private set
    var deleteButton by mutableStateOf(deleteButton)
        private set
    var secondaryButton by mutableStateOf(secondaryButton)
        private set
    var lightButton by mutableStateOf(lightButton)
        private set
    var divider by mutableStateOf(divider)
        private set
    var dividerMU2 by mutableStateOf(dividerMU2)
        private set
    var colorCarbonFootprintAccessCardTitle by mutableStateOf(colorCarbonFootprintAccessCardTitle)
        private set
    var colorCardTitle by mutableStateOf(colorCardTitle)
        private set
    var baseDialogBackground by mutableStateOf(baseDialogBackground)
        private set
    var selectAllButton by mutableStateOf(selectAllButton)
        private set
    var CodingChallenge2024Grey by mutableStateOf(CodingChallenge2024Grey)
        private set
    var checkBoxBackground by mutableStateOf(checkBoxBackground)
        private set
    var rewardCardBackground by mutableStateOf(rewardCardBackground)
        private set
    var visaBackground by mutableStateOf(visaBackground)
        private set
    var chatWithUsColor by mutableStateOf(chatWithUsColor)
        private set
    var isDark by mutableStateOf(isDark)
        private set
    var CalendarValidDayLight by mutableStateOf(calendarValidDayLight)
        private set
    var CalendarValidDayDark by mutableStateOf(calendarValidDayDark)
        private set
    var CalendarInvalidDay by mutableStateOf(calendarInvalidDay)
        private set
    var CommonDayModeTextFieldBackground by mutableStateOf(commonDayModeTextFieldBackground)
        private set
    var CommonNightModeTextFieldBackground by mutableStateOf(commonNightModeTextFieldBackground)
        private set
    var BarcodeCardBackground by mutableStateOf(barcodeCardBackground)
        private set
    var LabelBox by mutableStateOf(labelBox)
        private set
    var chartElecLineSelected by mutableStateOf(SparkYellow)
        private set
    var chartGasLineSelected by mutableStateOf(SkyBlue)
        private set
    var chartElecLineUnselected by mutableStateOf(chartElecLineUnselected)
        private set
    var chartGasLineUnselected by mutableStateOf(chartGasLineUnselected)
        private set
    var personaliseYourSmartScore by mutableStateOf(personaliseYourSmartScore)
        private set
    var greyButtonStyle by mutableStateOf(greyButtonStyle)
        private set
    var upgradeCardBackground by mutableStateOf(upgradeCardBackground)
        private set
    var rafBottomRect by mutableStateOf(rafBottomRect)
        private set
    var preSignCard by mutableStateOf(preSignCard)
        private set
    var emergencyCreditGas by mutableStateOf(emergencyCreditGas)
        private set
    var emergencyCreditElec by mutableStateOf(emergencyCreditElec)
        private set
    var emergencyCreditActivatingBox by mutableStateOf(emergencyCreditActivatingBox)
        private set
    var emergencyCreditGray by mutableStateOf(emergencyCreditGray)
        private set
    var cardBorder by mutableStateOf(cardBorder)
        private set
    var FriendlyCreditBackgroundRed by mutableStateOf(FriendlyCreditBackgroundRed)
        private set

    var FriendlyCreditBackgroundGreen by mutableStateOf(FriendlyCreditBackgroundGreen)
        private set

    fun update(other: NewsUkTechColors) {
        BlackOrWhite = other.BlackOrWhite
        WhiteOrBlack = other.WhiteOrBlack
        CodingChallenge2024White = other.CodingChallenge2024White
        SkyBlue = other.SkyBlue
        BlueEllipse = other.BlueEllipse
        BlueEllipseDarker = other.BlueEllipseDarker
        LeafGreen = other.LeafGreen
        FiredRed = other.FiredRed
        SparkYellow = other.SparkYellow
        TomatoRed = other.TomatoRed
        RatingExcellent = other.RatingExcellent
        RatingGood = other.RatingGood
        RatingAverage = other.RatingAverage
        RatingPoor = other.RatingPoor
        Background = other.Background
        CardBackground = other.CardBackground
        CardBackgroundNew = other.CardBackgroundNew
        Titles = other.Titles
        BodyCopy = other.BodyCopy
        GreyButton = other.GreyButton
        IndicatorColor = other.IndicatorColor
        FormBackground = other.FormBackground
        Border = other.Border
        RatingContainer = other.RatingContainer
        ChooseAnAmount = other.ChooseAnAmount
        PlaceHolderField = other.PlaceHolderField
        colorSmartScoreHistoryTitle = other.colorSmartScoreHistoryTitle
        colorSmartScoreHistorySubTitle = other.colorSmartScoreHistorySubTitle
        colorCardTitle = other.colorCardTitle
        primaryButton = other.primaryButton
        completeButton = other.completeButton
        deleteButton = other.deleteButton
        secondaryButton = other.secondaryButton
        lightButton = other.lightButton
        divider = other.divider
        dividerMU2 = other.dividerMU2
        colorCarbonFootprintAccessCardTitle = other.colorCarbonFootprintAccessCardTitle
        baseDialogBackground = other.baseDialogBackground
        selectAllButton = other.selectAllButton
        CodingChallenge2024Grey = other.CodingChallenge2024Grey
        checkBoxBackground = other.checkBoxBackground
        visaBackground = other.visaBackground
        chatWithUsColor = other.chatWithUsColor
        rewardCardBackground = other.rewardCardBackground
        CalendarValidDayLight = other.CalendarValidDayLight
        CalendarValidDayDark = other.CalendarValidDayDark
        CalendarInvalidDay = other.CalendarInvalidDay
        CommonNightModeTextFieldBackground = other.CommonNightModeTextFieldBackground
        CommonDayModeTextFieldBackground = other.CommonDayModeTextFieldBackground
        BarcodeCardBackground = other.BarcodeCardBackground
        isDark = other.isDark
        LabelBox = other.LabelBox
        chartElecLineUnselected = other.chartElecLineUnselected
        chartGasLineUnselected = other.chartGasLineUnselected
        personaliseYourSmartScore = other.personaliseYourSmartScore
        greyButtonStyle = other.greyButtonStyle
        upgradeCardBackground = other.upgradeCardBackground
        rafBottomRect = other.rafBottomRect
        preSignCard = other.preSignCard
        cardBorder = other.cardBorder
        FriendlyCreditBackgroundRed = other.FriendlyCreditBackgroundRed
        FriendlyCreditBackgroundGreen = other.FriendlyCreditBackgroundGreen
        emergencyCreditGas = other.emergencyCreditGas
        emergencyCreditElec = other.emergencyCreditElec
        emergencyCreditActivatingBox = other.emergencyCreditActivatingBox
        emergencyCreditGray = other.emergencyCreditGray
    }
}

@Composable
fun ProvideNewsUkTechColors(
    colors: NewsUkTechColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalNewsUkTechColors provides colorPalette, content = content)
}

private val LocalNewsUkTechColors = staticCompositionLocalOf<NewsUkTechColors> {
    error("No NewsUkTechColors provided")
}