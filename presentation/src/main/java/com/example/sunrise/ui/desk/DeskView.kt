package com.example.sunrise.ui.desk

import com.example.domain.model.Task
import com.example.sunrise.common.BaseView

interface DeskView : BaseView {

    fun     showTasks(tasks : MutableList<Task>)

}