package com.shakuntala.rayamajhi.finaltest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.shakuntala.rayamajhi.finaltest.viewmodel.CompanyStockViewModel
import com.shakuntala.rayamajhi.finaltest.data.CompanyStock
import com.shakuntala.rayamajhi.finaltest.ui.screens.MainScreen
import androidx.room.Room
import com.shakuntala.rayamajhi.finaltest.data.AppDatabase
import com.shakuntala.rayamajhi.finaltest.repository.CompanyStockRepository
import com.shakuntala.rayamajhi.finaltest.ui.screens.MainScreen
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.shakuntala.rayamajhi.finaltest.ui.screens.MainScreen

class ShakuntalaActivity : ComponentActivity() {

    private lateinit var viewModel: CompanyStockViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(CompanyStockViewModel::class.java)
        setContent {
            MainScreen(viewModel)
        }
    }
}



