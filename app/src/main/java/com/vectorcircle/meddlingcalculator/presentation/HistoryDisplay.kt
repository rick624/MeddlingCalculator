package com.vectorcircle.meddlingcalculator.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vectorcircle.meddlingcalculator.ui.theme.MeddlingCalculatorTheme
import com.vectorcircle.meddlingcalculator.ui.theme.Purple80
import com.vectorcircle.meddlingcalculator.ui.theme.screenBackground
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HistoryDisplay(state: CalculatorState, modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()

    LaunchedEffect(state.equations.size) {
        listState.animateScrollToItem(index = state.equations.size)
    }

/*    val listState = rememberLazyListState(
        initialFirstVisibleItemIndex = state.scrollPosition
    )
    LaunchedEffect(state.equations.size) {
        listState.animateScrollToItem(index = state.equations.size)
        snapshotFlow {
            listState.firstVisibleItemIndex
        }
    }*/

    LazyColumn(
        state = listState,
        modifier = modifier
    ) {
        itemsIndexed(state.equations) {index, equation ->
            val rowColor = if (index % 2 == 0) Purple80 else screenBackground
            HistoryItem(item = equation, rowColor = rowColor)
        }
    }
}

@Composable
fun HistoryItem(item: Notes, rowColor: Color) {
    Row (
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
//                    .background(screenBackground)
            .background(rowColor)
            .padding(4.dp)
    ){
        Column {        //for notes by Rick
            Spacer(Modifier.width(4.dp))
            Text(
                text = item.equation,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 28.sp,
                modifier = Modifier
                    .background(rowColor)
            )
            Text(text = item.tital + " " + item.createAt)
            Spacer(Modifier.width(4.dp))
        }

    }
    Spacer(Modifier.height(4.dp))
}

@Preview
@Composable
fun HistoryPreview() {
    MeddlingCalculatorTheme {
        val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.TAIWAN)
        var state = CalculatorState()
        state = state.copy(
            equations = listOf<Notes>(
                Notes("7 x 7 = 49", 1, "First calculate", sdf.format(Date())),
                Notes("7 x 8 = 56", 2, "Second calculate", sdf.format(Date())),
                Notes("7 x 9 = 63", 3, "Third calculate", sdf.format(Date())),
                Notes("9 x 9 = 81", 4, "Fourth calculate", sdf.format(Date())),
            )
        )
        HistoryDisplay(state = state)
    }
}