package com.vectorcircle.meddlingcalculator.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.vectorcircle.meddlingcalculator.domain.ButtonAction
import com.vectorcircle.meddlingcalculator.domain.ButtonData
import com.vectorcircle.meddlingcalculator.domain.MathOperation
import com.vectorcircle.meddlingcalculator.ui.theme.Blue
import com.vectorcircle.meddlingcalculator.ui.theme.MeddlingCalculatorTheme

@Composable
fun Keypad(onButtonPress: (ButtonAction) -> Unit) {
    val clear = {onButtonPress(ButtonAction.Clear)}
    val backspace = {onButtonPress(ButtonAction.Backspace)}
    val negate = {onButtonPress(ButtonAction.Negation)}
    val decimal = {onButtonPress(ButtonAction.Decimal)}
    val equals = {onButtonPress(ButtonAction.Equals)}
    val addition = {onButtonPress(ButtonAction.Operation(MathOperation.Addition))}
    val subtraction = {onButtonPress(ButtonAction.Operation(MathOperation.Subtraction))}
    val multiplication = {onButtonPress(ButtonAction.Operation(MathOperation.Multiplication))}
    val division = {onButtonPress(ButtonAction.Operation(MathOperation.Division))}

    var numbers: List<() -> Unit> = emptyList()
    for (i in 0..9){
        numbers = numbers + {onButtonPress(ButtonAction.Number(i))}
    }

    val row1 = listOf(
        ButtonData(text = "AC", onPress = clear),
        ButtonData(text = "⌫", onPress = backspace),
        ButtonData(text = "+/-", onPress = negate),
        ButtonData(text = "÷", onPress = division),
    )

    val row2 = listOf(
        ButtonData(text = "7", onPress = numbers[7]),
        ButtonData(text = "8", onPress = numbers[8]),
        ButtonData(text = "9", onPress = numbers[9]),
        ButtonData(text = "x", onPress = multiplication),
    )

    val row3 = listOf(
        ButtonData(text = "4", onPress = numbers[4]),
        ButtonData(text = "5", onPress = numbers[5]),
        ButtonData(text = "6", onPress = numbers[6]),
        ButtonData(text = "-", onPress = subtraction),
    )

    val row4 = listOf(
        ButtonData(text = "1", onPress = numbers[1]),
        ButtonData(text = "2", onPress = numbers[2]),
        ButtonData(text = "3", onPress = numbers[3]),
        ButtonData(text = "+", onPress = addition),
    )

    val row5 = listOf(
        ButtonData(text = "0", onPress = numbers[0]),
        ButtonData(text = ".", onPress = decimal),
        ButtonData(text = "=", onPress = equals),
    )

    Column {
        BuildRow(row1)
        BuildRow(row2)
        BuildRow(row3)
        BuildRow(row4)
        BuildRow(row5)
    }
}

@Composable
fun BuildRow(row: List<ButtonData>) {
    Spacer(modifier = Modifier.height(2.dp))
    Row (
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ){
        for (item in row){
            Spacer(modifier = Modifier.width(2.dp))
            CalculatorButton(
                button = item,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(2.dp))
        }
    }
    Spacer(modifier = Modifier.height(2.dp))
}

@Composable
fun CalculatorButton(button: ButtonData, modifier: Modifier = Modifier) {
    var color = Blue
    var textColor = Color.White

    if (button.text == "AC" || button.text == "⌫") {
        color = Color.Gray
        textColor = Color.Black
    }
    if (button.text.isDigitsOnly() || button.text == ".") {
        color = Color.DarkGray
    }
    
    Button(
        onClick = button.onPress,
        shape = RoundedCornerShape(15.dp),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(color)
        ) {
        Text(
            text = button.text,
            fontSize = 34.sp,
            color = textColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun KeypadPreview(){
    MeddlingCalculatorTheme {
        Keypad{}
    }
}