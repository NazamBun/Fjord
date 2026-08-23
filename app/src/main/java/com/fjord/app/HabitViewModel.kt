package com.fjord.app

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HabitViewModel : ViewModel() {

    private val _habits = MutableStateFlow(sampleHabits)
    val habits: StateFlow<List<Habit>> = _habits.asStateFlow()

    fun toggleHabit(id: Int) {
        _habits.value = _habits.value.map { habit ->
            if (habit.id == id) habit.copy(isDone = !habit.isDone) else habit
        }
    }
}