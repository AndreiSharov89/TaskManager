package com.example.oop_solid.data

import retrofit2.Call
import retrofit2.http.GET

interface TaskService {
    @GET("tasks")
    fun getTasks(): Call<List<TaskDto>>
}