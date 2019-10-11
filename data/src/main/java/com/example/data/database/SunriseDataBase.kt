package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.model.Task


@Database(entities = [Task::class], version = 1)
abstract class SunriseDataBase : RoomDatabase() {
    abstract fun getSunriseDao() : SunriseDao

}