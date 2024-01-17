package com.androidpractice.slidercoordination.ui.theme

import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SliderM3(fontSize: (Float) -> Unit) {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Slider(
        value = sliderPosition,
        onValueChange = {//TODO
        },
        valueRange = 0f..5f,
        steps = 4,
        onValueChangeFinished = {
//        //push the slider value to a viewModel
       }

    )

}