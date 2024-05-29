package com.vectorcircle.meddlingcalculator.domain

data class ButtonData(
    val text: String,
    val onPress: () -> Unit
)
