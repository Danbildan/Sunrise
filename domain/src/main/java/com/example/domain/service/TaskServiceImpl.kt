package com.example.domain.service

import com.example.domain.model.Task
import com.example.domain.repository.TaskRepository
import io.reactivex.Single
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class TaskServiceImpl(val serverRepository: TaskRepository, val bdRepository: TaskRepository): TaskService {


    override fun insertTasks(tasks: MutableList<Task>) {
        bdRepository.insertTasks(tasks)
    }

    override fun getTasks(): Single<MutableList<Task>> {
        return serverRepository
            .getTasks()
            .doOnSuccess{insertTasks(it)}
            .onErrorReturn {if(isNetworkError(it)) bdRepository.getTasks().blockingGet() else null}
    }
    private fun isNetworkError(throwable: Throwable) =
        throwable.javaClass == UnknownHostException::class.java ||
        throwable.javaClass == SocketTimeoutException::class.java ||
        throwable.javaClass == ConnectException::class.java
}