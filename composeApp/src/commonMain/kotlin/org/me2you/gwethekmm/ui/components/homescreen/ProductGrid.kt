package org.me2you.gwethekmm.ui.components.homescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GwetheProductGrid(
    products: Map<String, Int>,
    onProductClick: (String) -> Unit = {}
) {
    FlowRow(
        maxLines = 2,
        maxItemsInEachRow = 5,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        products.forEach { (name, price) ->
            ProductItem(name, price
            ) { onProductClick(name) }
        }
    }
}
