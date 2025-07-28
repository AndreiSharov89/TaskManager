package com.example.oop_solid

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoadTasksUseCase(
    private val taskNetworkClient: TaskNetworkClient,
    private val taskManager: TaskManager
) {
    fun execute(callback: (List<Task>) -> Unit) {
        taskNetworkClient.loadTasks(object : Callback<List<Task>> {
            override fun onResponse(call: Call<List<Task>>, response: Response<List<Task>>) {
                val tasks = response.body() ?: emptyList()
                callback(tasks)
                taskManager.saveCompletedTasks(tasks)
            }

            override fun onFailure(call: Call<List<Task>>, t: Throwable) {
                // Обработка ошибки, возможно, через другой callback или логирование
                //onFailure(t)
            }
        })
    }
}