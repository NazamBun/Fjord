package com.fjord.app.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun FjordApp() {
    val navController = rememberNavController()
    val viewModel: HabitViewModel = viewModel()

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