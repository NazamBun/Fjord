package com.fjord.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fjord.app.data.Habit
import com.fjord.app.data.HabitRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HabitViewModel(private val repository: HabitRepository) : ViewModel() {

    val habits: StateFlow<List<Habit>> = repository.allHabits
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun addHabit(name: String) {
        viewModelScope.launch {
            repository.insert(
                Habit(name = name, description = "", icon = "📝", isDone = false)
            )
        }
    }

    fun toggleHabit(id: Int) {
        viewModelScope.launch {
            val habit = habits.value.find { it.id == id } ?: return@launch
            repository.update(habit.copy(isDone = !habit.isDone))
        }
    }

    fun deleteHabit(id: Int) {
        viewModelScope.launch {
            val habit = habits.value.find { it.id == id } ?: return@launch
            repository.delete(habit)
        }
    }
}