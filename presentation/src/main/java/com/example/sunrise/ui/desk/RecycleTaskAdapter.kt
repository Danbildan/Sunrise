package com.example.sunrise.ui.desk

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Task
import android.view.LayoutInflater
import com.example.sunrise.R


class RecycleTaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {


    private val taskList : MutableList<Task> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.li_task, parent, false)

        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])

    }

    override fun getItemCount() = taskList.size

    fun addTasks(tasks: List<Task>, refresh: Boolean) {

        if (refresh) {
            taskList.clear()
            taskList.addAll(tasks)
            notifyDataSetChanged()
            return
        }
        val itemChangedPosition = taskList.size
        taskList.addAll(tasks)
        notifyItemChanged(itemChangedPosition)
    }
}