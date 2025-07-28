package com.example.oop_solid

data class Task(val id: Int, val title: String, var completed: Boolean) {
    fun markAsCompleted() {
        completed = true
    }

    fun markAsIncomplete() {
        completed = false
    }
}