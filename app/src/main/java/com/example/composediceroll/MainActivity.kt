package com.example.composediceroll

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.composediceroll.ui.theme.ComposeDiceRollTheme
import com.example.composediceroll.ui.theme.Teal200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDiceRollTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}
@Composable
fun DiceRollerApp(){

    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )

}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier){
    var result by remember{ mutableStateOf(1) }
    val imageResource = when (result){
        1 -> R.drawable.ic_dice_1
        2 -> R.drawable.ic_dice_2
        3 -> R.drawable.ic_dice_3
        4 -> R.drawable.ic_dice_4
        5 -> R.drawable.ic_dice_5
        else -> R.drawable.ic_dice_6
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Dice Image"
        )
        Spacer(modifier = Modifier.height(16.dp))
        val btncolor= R.color.app_colorrr
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.app_colorrr), contentColor = colorResource(
                id = R.color.btn_text_color
            )),
            onClick = {
                result = (1 .. 6).random()
            }

        ){
            Text(
                 text = stringResource(R.string.roll),
                 fontSize = 24.sp,
                 fontFamily = FontFamily(Font(R.font.source_sans_pro_semibold))


            )

        }

    }
}

