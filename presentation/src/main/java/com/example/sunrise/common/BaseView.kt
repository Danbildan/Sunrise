package com.example.sunrise.common

import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {

    fun showError(errorMessage: String = "")
    fun showLoading()
    fun hideLoading()
}