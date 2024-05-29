package com.vectorcircle.meddlingcalculator.domain

sealed class MathOperation(val symbol: String) {
    object Addition: MathOperation("+")
    object Subtraction: MathOperation("-")
    object Multiplication: MathOperation("x")
    object Division: MathOperation("÷")
}
