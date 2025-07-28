package com.example.oop_solid.domain

class LoadTasksUseCase(private val taskRepository: TaskRepository) {
    fun execute(onSuccess: (List<Task>) -> Unit, onFailure: (Throwable) -> Unit) {
        taskRepository.getTasks { result ->
            result.onSuccess(onSuccess)
                .onFailure(onFailure)
        }
    }
}