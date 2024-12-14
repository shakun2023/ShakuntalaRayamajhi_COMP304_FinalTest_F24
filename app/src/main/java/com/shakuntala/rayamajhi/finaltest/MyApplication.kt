package com.shakuntala.rayamajhi.finaltest

import android.app.Application
import androidx.room.Room
import com.shakuntala.rayamajhi.finaltest.data.AppDatabase


class MyApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "stock_db"
        ).build()
    }
}
