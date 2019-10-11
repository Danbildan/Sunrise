package com.example.domain.service

import com.example.domain.model.Task
import io.reactivex.Single

interface TaskService {

    fun getTasks(): Single<MutableList<Task>>
    fun insertTasks(tasks: MutableList<Task>)
}