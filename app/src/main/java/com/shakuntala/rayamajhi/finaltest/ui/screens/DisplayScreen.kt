package com.shakuntala.rayamajhi.finaltest.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.shakuntala.rayamajhi.finaltest.data.CompanyStock

@Composable
fun DisplayScreen(stock: CompanyStock?) {
    if (stock != null) {
        Text(text = "Company: ${stock.companyName}")
        Text(text = "Opening Price: ${stock.openingPrice}")
        Text(text = "Closing Price: ${stock.closingPrice}")
    } else {
        Text(text = "No data available")
    }
}
