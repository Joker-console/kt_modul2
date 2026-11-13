package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kotlin.random.Random
import com.example.myapplication.ui.theme.MyApplicationTheme

data class Cart(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                ShoppingCartScreen(
                    modifier = Modifier.safeDrawingPadding()
                )
            }
        }
    }
}

@Composable
fun ShoppingCartScreen(modifier: Modifier = Modifier) {
    var cart by remember {
        mutableStateOf(
            Cart(
                products = listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        )
    }

    val context = LocalContext.current
    val totalSum = cart.products.sumOf { it.price }

    Column(modifier = modifier) {
        for (product in cart.products) {
            Text(text = "${product.name} - ${product.price} рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Товаров на сумму: $totalSum рублей")

        AddProductSection(
            onAdd = {
                val newProduct = Product(
                    id = cart.products.size,
                    name = "Товар #${cart.products.size + 1}",
                    price = Random.nextInt(0, 100)
                )

                cart = cart.copy(
                    products = cart.products + newProduct
                )

                if (cart.products.sumOf { it.price } > 500) {
                    Toast.makeText(
                        context,
                        "Доставка бесплатная!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )

        if (cart.products.isNotEmpty()) {
            RemoveProductSection(
                onRemove = {
                    cart = cart.copy(
                        products = cart.products.dropLast(1)
                    )
                }
            )
        }
    }
}

@Composable
fun AddProductSection(
    onAdd: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onAdd,
        modifier = modifier
    ) {
        Text(text = "Добавить товар")
    }
}

@Composable
fun RemoveProductSection(
    onRemove: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onRemove,
        modifier = modifier
    ) {
        Text(text = "Удалить товар")
    }
}
