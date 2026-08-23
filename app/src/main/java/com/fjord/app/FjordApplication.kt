package com.fjord.app

import android.app.Application
import androidx.room.Room
import com.fjord.app.data.FjordDatabase
import com.fjord.app.data.HabitRepository

class FjordApplication : Application() {

    val database by lazy {
        Room.databaseBuilder(
            this,
            FjordDatabase::class.java,
            "fjord_database"
        ).build()
    }

    val repository by lazy {
        HabitRepository(database.habitDao())
    }
}