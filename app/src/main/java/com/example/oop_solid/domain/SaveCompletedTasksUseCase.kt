package com.example.oop_solid.domain

import com.example.oop_solid.data.TaskManager

class SaveCompletedTasksUseCase(
    private val taskManager: TaskManager
) {
    fun execute(tasks: List<Task>) {
        taskManager.saveCompletedTasks(tasks)
    }
}