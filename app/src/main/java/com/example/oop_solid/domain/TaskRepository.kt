package com.example.oop_solid.domain

interface TaskRepository {
    fun getTasks(callback: (Result<List<Task>>) -> Unit)
}