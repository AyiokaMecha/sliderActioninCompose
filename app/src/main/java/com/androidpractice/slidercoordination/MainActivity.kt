package com.androidpractice.slidercoordination

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.androidpractice.slidercoordination.ui.theme.SliderCoordinationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SliderCoordinationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}

@Composable
fun SliderScreen() {
    var fontSize by remember {
        mutableStateOf(35f)
    }
    fun setFontSize(multipier: Float) {
        fontSize = fontSize * multipier
    }

   var sfz: (x: Float) -> Unit = {
       x -> fontSize *= x
   }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f, fill = true),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "DanMecha",
                fontSize = fontSize.sp)
        }

        Divider(color = Color.Black)

        Box(modifier = Modifier.weight(0.05f, fill = true)
        , contentAlignment = Alignment.Center){
            SliderM3(::setFontSize)
        }

        Divider(color = Color.Black)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.25f, fill = true),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        )  {
            Text(text = "FontSize = $fontSize",
               fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SliderCoordinationTheme {
        SliderScreen()
    }
}

@Composable
fun SliderM3(fontSize: (Float) -> Unit) {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it
    fontSize(it)})

}