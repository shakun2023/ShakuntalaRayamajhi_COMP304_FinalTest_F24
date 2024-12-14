
package com.shakuntala.rayamajhi.finaltest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.shakuntala.rayamajhi.finaltest.MyApplication
import com.shakuntala.rayamajhi.finaltest.data.AppDatabase
import com.shakuntala.rayamajhi.finaltest.data.CompanyStock
import com.shakuntala.rayamajhi.finaltest.repository.CompanyStockRepository
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

class CompanyStockViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CompanyStockRepository

    // Initialize allStocks as LiveData
    val allStocks: LiveData<List<CompanyStock>>

    init {
        val companyStockDao = AppDatabase.getDatabase(application).companyStockDao()
        repository = CompanyStockRepository(companyStockDao)
        allStocks = repository.getAllStocks() // Fetch all stocks from repository
    }

    fun insertStock(stock: CompanyStock) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertStock(stock)
        }
        fun fetchStockByName(name: String): LiveData<CompanyStock> {
            return repository.getStockByName(name)
        }

        fun getStockByName(name: String): LiveData<CompanyStock> {
            return repository.getStockByName(name)
        }

    }

}


