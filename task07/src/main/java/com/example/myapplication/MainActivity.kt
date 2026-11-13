package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ContactList(modifier = Modifier.statusBarsPadding())
            }
        }
    }
}

@Composable
fun ContactColumn(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Имя: Евгений", fontSize = 14.sp)
        Text("Отчество: Андреевич", fontSize = 14.sp)
        Text("Фамилия: Лукашин", fontSize = 14.sp)
        Text("Мобильный телефон: +7 495 495 95 95", fontSize = 14.sp)
        Text(
            "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12",
            fontSize = 14.sp
        )
    }
}

@Composable
fun ContactCard(
    name: String,
    patronymic: String,
    surname: String,
    phone: String,
    address: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Имя: $name", fontSize = 14.sp)
        Text("Отчество: $patronymic", fontSize = 14.sp)
        Text("Фамилия: $surname", fontSize = 14.sp)
        Text("Мобильный телефон: $phone", fontSize = 14.sp)
        Text(
            text = "Адрес: $address",
            fontSize = 14.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ContactList(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ContactCard(
            name = "Евгений",
            patronymic = "Андреевич",
            surname = "Лукашин",
            phone = "+7 495 495 95 95",
            address = "г. Москва, 3-я улица Строителей, д. 25, кв. 12"
        )

        ContactCard(
            name = "Василий",
            patronymic = "Егорович",
            surname = "Кузякин",
            phone = "---",
            address = "Ивановская область, дер. Крутово, д. 4"
        )

        ContactCard(
            name = "Людмила",
            patronymic = "Прокофьевна",
            surname = "Калугина",
            phone = "+7 495 788 78 78",
            address = "Москва, Большая Никитская, д. 43, кв. 290"
        )
    }
}

@Composable
fun ContactRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Имя: Евгений", fontSize = 14.sp)
            Text("Отчество: Андреевич", fontSize = 14.sp)
            Text("Фамилия: Лукашин", fontSize = 14.sp)
            Text("Мобильный телефон: +7 495 495 95 95", fontSize = 14.sp)
            Text(
                text = "Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 14.sp
            )
        }

        Image(
            painter = painterResource(android.R.drawable.btn_star_big_on),
            contentDescription = "Избранный контакт",
            modifier = Modifier.size(32.dp)
        )
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun ContactColumnPreview() {
    MyApplicationTheme {
        ContactColumn()
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun ContactListPreview() {
    MyApplicationTheme {
        ContactList()
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun ContactRowPreview() {
    MyApplicationTheme {
        ContactRow()
    }
}
