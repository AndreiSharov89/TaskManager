package com.example.oop_solid.data

import com.example.oop_solid.domain.Task
import com.example.oop_solid.domain.TaskRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskRepositoryImpl(
    private val taskNetworkClient: TaskNetworkClient,
    private val taskManager: TaskManager
) : TaskRepository {
    override fun getTasks(callback: (Result<List<Task>>) -> Unit) {
        taskNetworkClient.loadTasks(object : Callback<List<TaskDto>> {
            override fun onResponse(call: Call<List<TaskDto>>, response: Response<List<TaskDto>>) {
                val taskDtos = response.body() ?: emptyList()
                val tasks = taskDtos.map { Task(it.id, it.title, it.completed) }
                taskManager.saveCompletedTasks(tasks)
                callback(Result.success(tasks))
            }

            override fun onFailure(call: Call<List<TaskDto>>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }
}