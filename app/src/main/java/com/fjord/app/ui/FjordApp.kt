package com.fjord.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjord.app.FjordApplication

@Composable
fun FjordApp() {
    val navController = rememberNavController()
    val application = LocalContext.current.applicationContext as FjordApplication
    val viewModel: HabitViewModel = viewModel(
        factory = viewModelFactory {
            initializer { HabitViewModel(application.repository) }
        }
    )

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            HabitListScreen(
                viewModel = viewModel,
                onAddClick = { navController.navigate("add") }
            )
        }
        composable("add") {
            AddHabitScreen(
                onSave = { name ->
                    viewModel.addHabit(name)
                    navController.popBackStack()
                }
            )
        }
    }
}