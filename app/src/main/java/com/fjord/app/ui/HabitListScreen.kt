package com.fjord.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.fjord.app.HabitListContent

@Composable
fun HabitListScreen(
    modifier: Modifier = Modifier.Companion,
    viewModel: HabitViewModel = viewModel()
) {
    val habits by viewModel.habits.collectAsState()   // on écoute le StateFlow

    HabitListContent(
        habits = habits,
        onToggle = { id -> viewModel.toggleHabit(id) },
        modifier = modifier
    )
}