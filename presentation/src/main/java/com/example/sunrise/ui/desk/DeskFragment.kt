package com.example.sunrise.ui.desk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.domain.model.Task
import com.example.sunrise.R

class DeskFragment:  MvpAppCompatFragment(), DeskView {

    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var recycleAdapter : RecycleTaskAdapter

    @InjectPresenter
    lateinit var  presenter:  DeskPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fr_desk, container, false)
        swipeRefreshLayout = v.findViewById(R.id.swipe_refresh)

        swipeRefreshLayout.setOnRefreshListener { presenter.getTasks() }
        val recycleView : RecyclerView = v.findViewById(R.id.desk_recyclerView)
        recycleAdapter = RecycleTaskAdapter()
        recycleView.adapter = recycleAdapter
        recycleView.layoutManager = LinearLayoutManager(activity)
        recycleView.addItemDecoration(
            DividerItemDecoration(context
            ,DividerItemDecoration.VERTICAL)
        )

        return v
    }

    override fun showTasks(tasks: MutableList<Task>) = recycleAdapter.addTasks(tasks, true)

    override fun showError(errorMessage: String) {
        Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if(savedInstanceState == null){
            presenter.getTasks()
        }
    }



}