package com.example.newsuktech.components

import androidx.compose.ui.graphics.Color
import com.example.newsuktech.ui.theme.NewsUkTechColors

abstract class MUButtonStyle() {
    lateinit var customColors: NewsUkTechColors

    open fun getTextColor(): Color = customColors.CodingChallenge2024White
    open fun getBackgroundColor(): Color = customColors.Background
}

class LightButtonStyle : MUButtonStyle() {
    override fun getTextColor(): Color = customColors.Titles
    override fun getBackgroundColor(): Color = customColors.lightButton
}



