package com.example.oop_solid

import android.content.Context
import com.example.oop_solid.data.TaskManager
import com.example.oop_solid.data.TaskNetworkClient
import com.example.oop_solid.data.TaskRepositoryImpl
import com.example.oop_solid.domain.LoadTasksUseCase
import com.example.oop_solid.domain.TaskRepository

object Creator {

    private fun getTaskNetworkClient(): TaskNetworkClient {
        return TaskNetworkClient()
    }

    private fun getTaskManager(context: Context): TaskManager {
        return TaskManager(context)
    }

    private fun getTaskRepository(context: Context): TaskRepository {
        return TaskRepositoryImpl(getTaskNetworkClient(), getTaskManager(context))
    }

    fun provideLoadTasksUseCase(context: Context): LoadTasksUseCase {
        return LoadTasksUseCase(getTaskRepository(context))
    }
}