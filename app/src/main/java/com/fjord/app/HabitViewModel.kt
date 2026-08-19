package com.fjord.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HabitViewModel : ViewModel() {

    var habits by mutableStateOf(sampleHabits)
        private set

    fun toggleHabit(id: Int) {
        habits = habits.map { habit ->
            if (habit.id == id) habit.copy(isDone = !habit.isDone) else habit
        }
    }
}