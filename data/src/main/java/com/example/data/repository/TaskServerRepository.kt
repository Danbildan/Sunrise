package com.example.data.repository

import com.example.data.api.SunriseApi
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import io.reactivex.Single

class TaskServerRepository(val api: SunriseApi) : TaskRepository{


    override fun insertTasks(tasks: MutableList<Task>) {

    }

    override fun getTasks(): Single<MutableList<Task>> {
        return api.getTasks()
    }


}