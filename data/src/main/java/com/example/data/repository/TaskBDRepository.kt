package com.example.data.repository

import com.example.data.database.SunriseDao
import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import io.reactivex.Single

class TaskBDRepository(val dao: SunriseDao) : TaskRepository{
    override fun insertTasks(tasks: MutableList<Task>) {
        dao.insertTasks(tasks)
    }

    override fun getTasks(): Single<MutableList<Task>> {
        return Single.fromCallable { return@fromCallable dao.getTasks()}
    }


}