package com.example.oop_solid.data

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TaskNetworkClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val taskService = retrofit.create(TaskService::class.java)

    fun loadTasks(callback: Callback<List<TaskDto>>) {
        taskService.getTasks().enqueue(callback)
    }
}