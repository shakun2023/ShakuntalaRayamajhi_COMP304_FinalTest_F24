package com.shakuntala.rayamajhi.finaltest.data
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CompanyStockDao {


    @Query("SELECT * FROM company_stock WHERE companyName = :name LIMIT 1")
    fun getStockByName(name: String): LiveData<CompanyStock>

    @Query("SELECT * FROM company_stock")
    fun getAllStocks(): LiveData<List<CompanyStock>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStock(stock: CompanyStock)

    @Delete
    suspend fun deleteStock(stock: CompanyStock) }
