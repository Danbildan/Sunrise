package com.example.sunrise

import android.app.Application

import androidx.room.Room
import com.example.data.api.TestApi
import com.example.data.repository.TaskBDRepository
import com.example.data.repository.TaskServerRepository
import com.example.domain.interactor.UserInteractor

import com.example.domain.service.TaskServiceImpl

import com.example.data.database.SunriseDataBase
import com.example.domain.interactor.SunriseInteractor


class AppDelegation : Application() {

    companion object{
        var appDelegation: AppDelegation? = null
        private set

        var interactor: SunriseInteractor? = null
        private set
    }


    override fun onCreate() {
        super.onCreate()

        appDelegation = this
        prepareInteractor()

    }

    fun prepareInteractor() {

        val api = TestApi()

        val database : SunriseDataBase = Room.databaseBuilder(this, SunriseDataBase::class.java, "sunrise_database")
            .fallbackToDestructiveMigration()
            .build()

        val bdRepository = TaskBDRepository(database.getSunriseDao())
        val serverRepository = TaskServerRepository(api)

        val taskService  = TaskServiceImpl(serverRepository, bdRepository)
        interactor = UserInteractor(taskService)
    }


}