package com.example.oop_solid

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaskManager(private val context: Context) {
    private val sharedPreferences = context.getSharedPreferences("task_preferences", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveCompletedTasks(tasks: List<Task>) {
        val completedTaskIds = tasks.filter { it.completed }.map { it.id }
        val json = gson.toJson(completedTaskIds)
        sharedPreferences.edit().putString("completed_tasks", json).apply()
    }

    fun getCompletedTaskIds(): List<Int> {
        val json = sharedPreferences.getString("completed_tasks", null)
        return json?.let {
            gson.fromJson<List<Int>>(it, object : TypeToken<List<Int>>() {}.type)
        } ?: emptyList()
    }
}