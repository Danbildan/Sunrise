package com.example.data.database



import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.Task


@Dao
interface SunriseDao {


    @Query("select * from task_table")
    fun getTasks(): MutableList<Task>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTasks(tasks : MutableList<Task>)
}