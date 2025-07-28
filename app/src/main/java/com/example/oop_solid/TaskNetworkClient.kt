package com.example.oop_solid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Callback

class TaskNetworkClient {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.example.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val taskService = retrofit.create(TaskService::class.java)

    fun loadTasks(callback: Callback<List<Task>>) {
        taskService.getTasks().enqueue(callback)
    }
}