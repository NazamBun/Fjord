package com.fjord.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fjord.app.ui.theme.FjordTheme
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.fjord.app.data.Habit
import com.fjord.app.data.sampleHabits
import com.fjord.app.ui.FjordApp
import com.fjord.app.ui.HabitItem
import com.fjord.app.ui.HabitListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FjordTheme {
                FjordApp()
            }
        }
    }
}


@Composable
fun HabitListContent(
    habits: List<Habit>,
    onToggle: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    // partie visuelle : ne connaît aucun ViewModel, juste des données et un callback
    LazyColumn(modifier = modifier) {
        items(habits, key = { it.id }) { habit ->
            HabitItem(
                habit = habit,
                onToggle = { onToggle(habit.id) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HabitListScreenPreview() {
    FjordTheme {
        HabitListContent(habits = sampleHabits, onToggle = {})
    }
}