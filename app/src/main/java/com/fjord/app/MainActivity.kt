package com.fjord.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.fjord.app.ui.theme.FjordTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FjordTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HabitListScreen(
                        habits = sampleHabits,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun HabitListScreen(habits: List<Habit>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(habits) { habit ->
            HabitItem(habit = habit)
        }
    }
}

@Composable
fun HabitItem(habit: Habit, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = habit.icon, style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.width(16.dp))
            Column {
                Text(text = habit.name, style = MaterialTheme.typography.titleMedium)
                Text(text = habit.description, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.weight(1f))
            Text(text = if (habit.isDone) "✅" else "⬜️")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FjordTheme {
        HabitListScreen(habits = sampleHabits)
    }
}