package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                TextExamples()
            }
        }
    }
}

@Composable
fun TextExamples(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        GreenText()
        SingleLineText()
        IndentedText()
    }
}

@Composable
fun GreenText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = modifier.fillMaxWidth(),
        color = Color.Green,
        fontSize = 16.sp,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center
    )
}

@Composable
fun SingleLineText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = modifier.fillMaxWidth(),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun IndentedText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.compose_description),
        modifier = modifier
            .fillMaxWidth()
            .background(Color.Green),
        color = Color.Black,
        fontSize = 24.sp,
        textDecoration = TextDecoration.Underline,
        style = TextStyle(
            textIndent = TextIndent(firstLine = 48.sp)
        )
    )
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun GreenTextPreview() {
    MyApplicationTheme {
        GreenText()
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun SingleLineTextPreview() {
    MyApplicationTheme {
        SingleLineText()
    }
}

@Preview(showBackground = true, widthDp = 360)
@Composable
fun IndentedTextPreview() {
    MyApplicationTheme {
        IndentedText()
    }
}
