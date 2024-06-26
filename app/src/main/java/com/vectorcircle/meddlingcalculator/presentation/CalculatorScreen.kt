package com.vectorcircle.meddlingcalculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vectorcircle.meddlingcalculator.domain.ButtonAction
import com.vectorcircle.meddlingcalculator.domain.MathOperation
import com.vectorcircle.meddlingcalculator.ui.theme.MeddlingCalculatorTheme
import com.vectorcircle.meddlingcalculator.ui.theme.backgroundGray
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun CalculatorScreen(
    state: CalculatorState,
    onButtonPress: (ButtonAction) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray)
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.End
    ) {
        HistoryDisplay(state = state, modifier = Modifier.weight(1f))
        DisplayScreen(state = state)
        Keypad(onButtonPress = onButtonPress)
    }
}

@Preview
@Composable
fun CalculatorScreenPreview() {
    val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.TAIWAN)
    MeddlingCalculatorTheme {
        var state = CalculatorState()
        state = state.copy(
            displayNumber = "3.14",
            number1 = "3",
            number2 = "3.14",
            operation = MathOperation.Multiplication,
            currentEquation = "3 x 3.14",
//            equations = listOf("7 x 7 = 49", "16 ÷ 2 = 8", "1 + 2 = 3")
            equations = listOf<Notes>(
                Notes("7 x 7 = 49", 1, "First calculate", sdf.format(Date())),
                Notes("7 x 8 = 56", 2, "Second calculate", sdf.format(Date())),
                Notes("7 x 9 = 63", 3, "Third calculate", sdf.format(Date())),
                Notes("9 x 9 = 81", 4, "Fourth calculate", sdf.format(Date())),
            )
        )
        CalculatorScreen(state = state, onButtonPress = {})
    }
}
