package com.example.domain.interactor

import com.example.domain.model.Task
import io.reactivex.Completable
import io.reactivex.Single

interface SunriseInteractor {

    fun login(login : String?, password : String?): Completable

    fun getTasks(): Single<MutableList<Task>>
}