package com.vectorcircle.meddlingcalculator.presentation

import com.vectorcircle.meddlingcalculator.domain.MathOperation

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val displayNumber: String = "0",
    val operation: MathOperation? = null,
    val currentEquation: String = "",
    val equations: List<String> = emptyList()
)
