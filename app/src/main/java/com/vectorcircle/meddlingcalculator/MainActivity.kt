package com.vectorcircle.meddlingcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vectorcircle.meddlingcalculator.presentation.CalculatorScreen
import com.vectorcircle.meddlingcalculator.presentation.CalculatorViewModel
import com.vectorcircle.meddlingcalculator.ui.theme.MeddlingCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeddlingCalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                CalculatorScreen(
                    state = state,
                    onButtonPress = viewModel::onButton
                )
            }
        }
    }
}