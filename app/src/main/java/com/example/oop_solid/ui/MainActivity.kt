package com.example.oop_solid.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.oop_solid.Creator
import com.example.oop_solid.R
import com.example.oop_solid.domain.LoadTasksUseCase
import com.example.oop_solid.ui.presentation.TaskListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var loadTasksUseCase: LoadTasksUseCase
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadTasksUseCase = Creator.provideLoadTasksUseCase(this)

        recyclerView = findViewById(R.id.recycler_view_tasks)
        recyclerView.layoutManager = LinearLayoutManager(this)

        loadTasks()
    }

    private fun loadTasks() {
        loadTasksUseCase.execute(
            onSuccess = { tasks ->
                val adapter = TaskListAdapter(tasks)
                recyclerView.adapter = adapter
            },
            onFailure = { throwable ->
                Toast.makeText(this, "Ошибка загрузки задач: ${throwable.message}", Toast.LENGTH_SHORT).show()
            }
        )
    }
}