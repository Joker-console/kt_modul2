package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Column(modifier = Modifier.statusBarsPadding()) {
                    OriginalCircle()
                    StretchedCircle()
                }
            }
        }
    }
}

@Composable
fun OriginalCircle(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.circle),
        contentDescription = "Оранжевый круг",
        modifier = modifier
            .size(240.dp, 120.dp)
            .background(Color.Black),
        alignment = Alignment.TopEnd,
        contentScale = ContentScale.None

    )
}

@Composable
fun StretchedCircle(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.circle),
        contentDescription = "Фиолетовый овал",
        modifier = modifier
            .size(240.dp, 120.dp)
            .background(Color.Blue),
        alignment = Alignment.Center,
        contentScale = ContentScale.FillBounds,
        colorFilter = ColorFilter.tint(Color(0xFF800080))
    )
}



@Preview(showBackground = true)
@Composable
fun OriginalCirclePreview() {
    OriginalCircle()
}

@Preview(showBackground = true)
@Composable
fun StretchedCirclePreview() {
    StretchedCircle()
}
