package com.shakuntala.rayamajhi.finaltest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.lifecycle.ViewModelProvider
import com.shakuntala.rayamajhi.finaltest.ui.screens.DisplayScreen
import com.shakuntala.rayamajhi.finaltest.viewmodel.CompanyStockViewModel

class DisplayActivity : ComponentActivity() {

    private lateinit var viewModel: CompanyStockViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val companyName = intent.getStringExtra("companyName") ?: ""

        viewModel = ViewModelProvider(this).get(CompanyStockViewModel::class.java)


            }
        }


