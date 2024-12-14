package com.shakuntala.rayamajhi.finaltest.ui.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.shakuntala.rayamajhi.finaltest.MyApplication
import com.shakuntala.rayamajhi.finaltest.viewmodel.CompanyStockViewModel
import com.shakuntala.rayamajhi.finaltest.data.CompanyStock
import kotlinx.coroutines.launch

private val Int.companyName: String
    get() {return "Company Name for $this"}

@Composable
fun MainScreen(viewModel: CompanyStockViewModel) {
    val context = LocalContext.current
    val stockName = remember { mutableStateOf("") }
    val openingPrice = remember { mutableStateOf("") }
    val closingPrice = remember { mutableStateOf("") }
    val stockList = viewModel.allStocks.observeAsState(emptyList())
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(stockList.value) { stock ->
                    Text(text = "Company: ${stock.companyName}")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = stockName.value,
                onValueChange = { stockName.value = it },
                label = { Text("Stock Symbol") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = openingPrice.value,
                onValueChange = { openingPrice.value = it },
                label = { Text("Opening Price") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = closingPrice.value,
                onValueChange = { closingPrice.value = it },
                label = { Text("Closing Price") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (stockName.value.isNotEmpty() && openingPrice.value.isNotEmpty() && closingPrice.value.isNotEmpty()) {
                        val opening = openingPrice.value.toDoubleOrNull()
                        val closing = closingPrice.value.toDoubleOrNull()
                        if (opening != null && closing != null) {
                            val stock = CompanyStock(
                                companyName = stockName.value,
                                openingPrice = opening,
                                closingPrice = closing
                            )
                            viewModel.insertStock(stock)
                            stockName.value = ""
                            openingPrice.value = ""
                            closingPrice.value = ""
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Stock saved successfully")
                            }
                        } else {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Prices must be valid numbers")
                            }
                        }
                    } else {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("All fields must be filled")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Stock")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    // Mock ViewModel for Preview
   MainScreen(viewModel = CompanyStockViewModel(viewModel()))
}
