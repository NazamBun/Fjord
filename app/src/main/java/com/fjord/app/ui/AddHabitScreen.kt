package com.fjord.app.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fjord.app.ui.theme.FjordTheme

@Composable
fun AddHabitScreen(
    onSave: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var name by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nom de l'habitude") }
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { onSave(name) },
            enabled = name.isNotBlank()
        ) {
            Text("Ajouter")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AddHabitScreenPreview() {
    FjordTheme {
        AddHabitScreen(onSave = {})
    }
}