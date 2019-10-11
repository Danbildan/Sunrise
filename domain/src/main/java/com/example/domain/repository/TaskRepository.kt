package com.example.domain.repository

import com.example.domain.model.Task
import io.reactivex.Single

interface TaskRepository {
    val SERVER : String
        get() = "server"

    val BD: String
        get() = "bd"

    fun getTasks(): Single<MutableList<Task>>

    fun insertTasks(tasks : MutableList<Task>)
}