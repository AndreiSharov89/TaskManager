package com.example.oop_solid.ui

import com.example.oop_solid.domain.Task

interface TasksInteractor {
    fun loadTasks(consumer: TasksConsumer)

    fun saveCompletedTasks(tasks: List<Task>)

    interface TasksConsumer {
        fun consume(tasks: List<Task>?)
    }
}