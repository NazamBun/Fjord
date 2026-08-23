package com.fjord.app.ui

import androidx.lifecycle.ViewModel
import com.fjord.app.data.Habit
import com.fjord.app.data.sampleHabits
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

    fun addHabit(name: String) {
        val newId = (_habits.value.maxOfOrNull { it.id } ?: 0) + 1
        val newHabit = Habit(
            id = newId,
            name = name,
            description = "",
            icon = "📝",
            isDone = false
        )
        _habits.value = _habits.value + newHabit
    }
}