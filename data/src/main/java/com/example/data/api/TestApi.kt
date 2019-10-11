package com.example.data.api

import com.example.domain.model.Task
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import kotlin.random.Random


class TestApi: SunriseApi {

    val tasks  = generateTasks(5)

    override fun getTasks(): Single<MutableList<Task>> {
        return Single.just(tasks).delay(1500, TimeUnit.MILLISECONDS)
    }


    private fun generateTasks(count : Int): MutableList<Task>{

        val tasks  = ArrayList<Task>()

        for( j in 1..count){
            var description = ""

            val status  = 0
            val id = Random.nextInt(1000000).toString()
            for(i in 1..15){
                description += Random.nextBytes(10).joinToString(separator="", transform={it.toChar().toString()}) + " "
            }

            tasks.add(Task(id, description, status))
        }

        return tasks

    }

}