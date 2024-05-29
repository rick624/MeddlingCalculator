package com.vectorcircle.meddlingcalculator.presentation

import android.view.Surface
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vectorcircle.meddlingcalculator.domain.MathOperation
import com.vectorcircle.meddlingcalculator.ui.theme.MeddlingCalculatorTheme
import com.vectorcircle.meddlingcalculator.ui.theme.Purple80
import com.vectorcircle.meddlingcalculator.ui.theme.backgroundGray
import com.vectorcircle.meddlingcalculator.ui.theme.screenBackground

@Composable
fun DisplayScreen(state: CalculatorState, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(15.dp))
            .background(screenBackground)
            .padding(6.dp)
    ) {
        ScreenRow(
            fontSize = 34,
            text = state.currentEquation,
            modifier = modifier,
        )
        ScreenRow(
            fontSize = 60,
            text = state.displayNumber,
            modifier = modifier
        )
    }
}

@Composable
private fun ScreenRow(fontSize: Int, text: String, modifier: Modifier = Modifier) {
    Row (modifier = modifier){
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = fontSize.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(4.dp))
    }
}

@Preview
@Composable
fun DisplayScreenPreview() {
    MeddlingCalculatorTheme {
        var state = CalculatorState()
        state = state.copy(
            displayNumber = "3.14",
            number1 = "3",
            number2 = "3.14",
            operation = MathOperation.Multiplication,
            currentEquation = "3 x 3.14"
        )
        DisplayScreen(state = state)
    }
}