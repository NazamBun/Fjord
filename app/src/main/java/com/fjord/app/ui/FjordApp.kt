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
import org.koin.androidx.compose.koinViewModel

@Composable
fun FjordApp() {
    val navController = rememberNavController()
    val viewModel: HabitViewModel = koinViewModel()

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