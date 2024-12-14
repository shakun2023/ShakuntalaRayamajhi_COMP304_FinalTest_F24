package com.shakuntala.rayamajhi.finaltest.repository

import androidx.lifecycle.LiveData
import com.shakuntala.rayamajhi.finaltest.data.CompanyStock
import com.shakuntala.rayamajhi.finaltest.data.CompanyStockDao

class CompanyStockRepository(private val companyStockDao: CompanyStockDao) {

    fun getAllStocks(): LiveData<List<CompanyStock>> {
        return companyStockDao.getAllStocks()
    }

    fun getStockByName(name: String): LiveData<CompanyStock> {
        return companyStockDao.getStockByName(name)
    }

    suspend fun insertStock(stock: CompanyStock) {
        companyStockDao.insertStock(stock)
    }

    suspend fun deleteStock(stock: CompanyStock) {
        companyStockDao.deleteStock(stock)
    }


}