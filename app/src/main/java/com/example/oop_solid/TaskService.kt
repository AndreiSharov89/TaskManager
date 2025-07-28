package com.example.oop_solid

import retrofit2.Call
import retrofit2.http.GET

interface TaskService {
    @GET("tasks")
    fun getTasks(): Call<List<Task>>
}