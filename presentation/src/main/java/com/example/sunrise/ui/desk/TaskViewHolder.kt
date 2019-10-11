package com.example.sunrise.ui.desk

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.example.domain.model.Task
import com.example.sunrise.R

import androidx.core.content.ContextCompat





class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view){

    val description: TextView
    val reward:TextView
    val startDate:TextView
    val endDate:TextView
    val creationDate:TextView
    val creationDateText:TextView
    val startDateText: TextView
    val endDateText:TextView
    val status: ImageView

   init{
       description = view.findViewById(R.id.taskSingleRow_description_textView)
       description.isSingleLine = true
       reward = view.findViewById(R.id.taskSingleRow_reward_textView)
       creationDate = view.findViewById(R.id.taskSingleRow_creationDate_get_textView)
       startDate = view.findViewById(R.id.taskSingleRow_startDate_get_textView)
       endDate = view.findViewById(R.id.taskSingleRow_endDate_get_textView)
       status = view.findViewById(R.id.taskSingleRow_status_imageView)
       creationDateText = view.findViewById(R.id.taskSingleRow_creationDate_textView)
       startDateText = view.findViewById(R.id.taskSingleRow_startDate_textView)
       endDateText = view.findViewById(R.id.taskSingleRow_endDate_textView)


   }

    fun bind(task : Task){
        description.text = task.description
        when(task.status){


            101 -> {
                status.setImageResource(R.drawable.status_101)
                setDefaultBackground()
            }
            102 -> {
                status.setImageResource(R.drawable.status_102)
                setDefaultBackground()
            }
            103 ->{
                status.setImageResource(R.drawable.status_103)
                setComplectedBackground()
            }
        }
    }

    private fun setComplectedBackground() {
        itemView.setBackgroundColor(
            ContextCompat.getColor(
                itemView.context,
                R.color.field_background
            )
        )
    }

    private fun setDefaultBackground() {
        itemView.setBackgroundColor(Color.WHITE)

    }



}