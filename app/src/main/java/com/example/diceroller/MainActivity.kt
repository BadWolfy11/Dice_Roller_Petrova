package com.example.diceroller

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview
@Composable
fun DiceRollerApp() {

    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier .fillMaxSize()
    .wrapContentSize(Alignment.Center)) {
    var result by remember { mutableStateOf(1) }
    var imageResource = when (result) {
        1 -> R.drawable.whitebishop
        2 -> R.drawable.whitehorse
        3 -> R.drawable.whiteking
        4 -> R.drawable.whitepawn
        5 -> R.drawable.whiterook
        6 -> R.drawable.whitequeen
        7 -> R.drawable.blackbishop
        8 -> R.drawable.blackking
        9 -> R.drawable.blackknight
        10 -> R.drawable.blackpawn
        11 -> R.drawable.blackqueen
        else -> R.drawable.blackrook
    }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = imageResource),  modifier = Modifier.fillMaxSize(0.3f), contentDescription = result.toString())
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier)
        {

            Button(onClick = { result = (7..12).random() }) {
                Text(stringResource(R.string.chess_one))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { result = (1..6).random() }) {
                Text(stringResource(R.string.chess_two))
            }
        }


    }
}

