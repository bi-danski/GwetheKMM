package org.me2you.gwethekmm.ui.components.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.me2you.gwethekmm.isPlatformDesktop
import org.me2you.gwethekmm.ui.theme.AccentC
import org.me2you.gwethekmm.ui.theme.AccentG
import org.me2you.gwethekmm.ui.theme.GwetheKMMTheme

@Composable
fun ProductItem(
    name: String,
    price: Int,
    onClick: (Pair<String, Boolean>) -> Unit = {}
) {
    var isFavourite by remember { mutableStateOf(false) }

    Surface(
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp,
        modifier = Modifier
            .clickable { onClick(Pair(name, isFavourite)) }
            .padding(4.dp)
            .width(if (isPlatformDesktop()) 300.dp else 150.dp)
            .height(if (isPlatformDesktop()) 300.dp else 150.dp)
            .background(AccentG.copy(0.1f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AccentG.copy(0.1f))
                .clip(RoundedCornerShape(15.dp))
        ) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Cart",
                tint = AccentC,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(10.dp)
                    .size(if (isPlatformDesktop()) 28.dp else 20.dp)
            )
            Icon(
                imageVector = if (isFavourite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "Favourite",
                tint = if (isFavourite) Color.Red else AccentC,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(10.dp)
                    .size(if (isPlatformDesktop()) 28.dp else 20.dp)
                    .clickable { isFavourite = !isFavourite }
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = if (isPlatformDesktop()) 30.dp else 20.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = name,
                    tint = AccentG,
                    modifier = Modifier.size(if (isPlatformDesktop()) 100.dp else 50.dp)
                )

                Spacer(modifier = Modifier.height(if (isPlatformDesktop()) 22.dp else 10.dp) )

                Text(
                    text = name,
                    fontSize = if (isPlatformDesktop()) 32.sp else 22.sp,
                    color = AccentC,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.ExtraBold
                )

                Row(
                    modifier = Modifier.padding(if (isPlatformDesktop()) 10.dp else 5.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "$price",
                        fontSize = if (isPlatformDesktop()) 28.sp else 18.sp,
                        color = AccentC,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(if (isPlatformDesktop()) 8.dp else 4.dp) )
                    Text(
                        text = "KES",
                        fontSize = if (isPlatformDesktop()) 24.sp else 16.sp,
                        color = AccentC,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.ExtraBold,
//                        fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProductItem() {
    GwetheKMMTheme {
        ProductItem("Veve", price = 300)
    }
}
