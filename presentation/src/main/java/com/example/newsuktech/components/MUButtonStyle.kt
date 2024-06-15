package com.example.newsuktech.components

import androidx.compose.ui.graphics.Color
import com.example.newsuktech.ui.theme.BlueEllipseDarker
import com.example.newsuktech.ui.theme.NewsUkTechColors

abstract class MUButtonStyle() {
    lateinit var customColors: NewsUkTechColors

    open fun getTextColor(): Color = customColors.CodingChallenge2024White
    open fun getBackgroundColor(): Color = customColors.Background
}

class PrimaryButtonStyle : MUButtonStyle() {
    override fun getBackgroundColor(): Color = customColors.primaryButton
}

class SecondaryButtonStyle : MUButtonStyle() {
    override fun getBackgroundColor(): Color = customColors.secondaryButton
}

class CompleteButtonStyle : MUButtonStyle() {
    override fun getBackgroundColor(): Color = customColors.completeButton
}

class DeleteButtonStyle : MUButtonStyle() {
    override fun getBackgroundColor(): Color = customColors.deleteButton
}

class LightButtonStyle : MUButtonStyle() {
    override fun getTextColor(): Color = customColors.Titles
    override fun getBackgroundColor(): Color = customColors.lightButton
}

class BlueEllipseDarkerButtonStyle : MUButtonStyle() {
    override fun getTextColor(): Color = customColors.CodingChallenge2024White
    override fun getBackgroundColor(): Color = BlueEllipseDarker
}

class SelectAllButtonStyle(private val colorText: Color, private val colorBackground: Color) : MUButtonStyle() {
    override fun getTextColor(): Color = colorText
    override fun getBackgroundColor(): Color = colorBackground
}

class GreyButtonStyle : MUButtonStyle() {
    override fun getTextColor(): Color = customColors.Titles
    override fun getBackgroundColor(): Color = customColors.greyButtonStyle
}

enum class ButtonStyleEnum(val style: String) {
    PRIMARY("PRIMARY"),
    SECONDARY("SECONDARY"),
    SUCCESS("SUCCESS"),
    DANGER("DANGER"),
    DEFAULT("DEFAULT")
}
