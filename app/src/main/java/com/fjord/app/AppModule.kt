package com.fjord.app

import androidx.room.Room
import com.fjord.app.data.FjordDatabase
import com.fjord.app.data.HabitRepository
import com.fjord.app.ui.HabitViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            FjordDatabase::class.java,
            "fjord_database"
        ).build()
    }
    single { get<FjordDatabase>().habitDao() }
    single { HabitRepository(get()) }
    viewModel { HabitViewModel(get()) }
}