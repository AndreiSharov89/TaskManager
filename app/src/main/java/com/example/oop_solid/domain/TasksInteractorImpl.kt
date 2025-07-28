/*
package com.example.oop_solid.domain

import com.example.oop_solid.data.TaskDto
import com.example.oop_solid.data.TaskManager
import com.example.oop_solid.data.TaskNetworkClient
import com.example.oop_solid.ui.TasksInteractor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TasksInteractorImpl(
    private val taskNetworkClient: TaskNetworkClient,
    private val taskManager: TaskManager
) : TasksInteractor
{

    override fun loadTasks(consumer: TasksInteractor.TasksConsumer) {
        taskNetworkClient.loadTasks(object : Callback<List<TaskDto>> {
            override fun onResponse(call: Call<List<Task>>, response: Response<List<Task>>) {
                val tasks = response.body() ?: emptyList()
                consumer.consume(tasks)
            }

            override fun onFailure(call: Call<List<Task>>, t: Throwable) {
                consumer.consume(null)
            }
        })
    }

    override fun saveCompletedTasks(tasks: List<Task>) {
        taskManager.saveCompletedTasks(tasks)
    }
}*/
