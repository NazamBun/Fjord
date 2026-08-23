package com.fjord.app.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fjord.app.data.Habit

@Composable
fun HabitItem(habit: Habit, onToggle: () -> Unit, modifier: Modifier = Modifier.Companion) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { onToggle() }        // on prévient le parent, c'est tout
    ) {
        Row(
            modifier = Modifier.Companion.padding(16.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {
            Text(text = habit.icon, style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.Companion.width(16.dp))
            Column {
                Text(text = habit.name, style = MaterialTheme.typography.titleMedium)
                Text(text = habit.description, style = MaterialTheme.typography.bodySmall)
            }
            Spacer(Modifier.Companion.weight(1f))
            Text(text = if (habit.isDone) "✅" else "⬜️")   // lit la vérité reçue
        }
    }
}