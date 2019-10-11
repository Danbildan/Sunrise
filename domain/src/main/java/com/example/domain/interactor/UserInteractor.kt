package com.example.domain.interactor

import com.example.domain.model.Task
import com.example.domain.service.TaskService
import io.reactivex.Completable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class UserInteractor(val taskService: TaskService) : SunriseInteractor {

    companion object{
        const val LOGIN_IS_EMPTY: String = "login_is_empty"
        const val PASSWORD_IS_EMPTY: String = "password_is_empty"
    }


    override fun getTasks(): Single<MutableList<Task>> {

        return taskService.getTasks()

    }

    override fun login(login: String?, password: String?): Completable {
        return Completable.create {
            when {
                login.isNullOrEmpty() -> it.onError(Throwable(LOGIN_IS_EMPTY))
                password.isNullOrEmpty() -> it.onError(Throwable(PASSWORD_IS_EMPTY))
                else -> it.onComplete()
            }
        }.delay(1000, TimeUnit.MILLISECONDS)
    }



}