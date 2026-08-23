package com.fjord.app.data

data class Habit(
    val id: Int,
    val name: String,
    val description: String,
    val icon: String,
    val isDone: Boolean
)