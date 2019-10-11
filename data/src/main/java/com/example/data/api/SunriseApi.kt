package com.example.data.api

import com.example.domain.model.Task
import io.reactivex.Single

interface SunriseApi {

    fun getTasks() : Single<MutableList<Task>>
}