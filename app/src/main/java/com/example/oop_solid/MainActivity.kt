package com.example.oop_solid

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var loadTasksUseCase: LoadTasksUseCase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val taskNetworkClient = TaskNetworkClient()
        val taskManager = TaskManager(this)
        loadTasksUseCase = LoadTasksUseCase(taskNetworkClient, taskManager)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_tasks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadTasksUseCase.execute { tasks ->
            val adapter = TaskListAdapter(tasks)
            recyclerView.adapter = adapter
        }
    }
}