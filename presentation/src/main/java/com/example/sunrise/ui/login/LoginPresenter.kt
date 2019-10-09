package com.example.sunrise.ui.login

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {




    fun registration(){
        viewState.showRegistrationScreen()
    }

    fun login(login: String, password: String){
        TODO()
    }





}