package com.vectorcircle.meddlingcalculator.presentation

import com.vectorcircle.meddlingcalculator.domain.MathOperation
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val displayNumber: String = "0",
    val operation: MathOperation? = null,
    val currentEquation: String = "",
    val equation: String = "",
//    val equations: List<String> = emptyList(),
    val equations: List<Notes> = emptyList(),
)

//for notes
data class Notes(
    val equation: String ="",
    val id: Int,
    val tital: String,
    val createAt: String
)