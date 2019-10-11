package com.example.sunrise.ui.login


import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.domain.interactor.SunriseInteractor
import com.example.domain.interactor.UserInteractor
import com.example.sunrise.AppDelegation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

    var interactor: SunriseInteractor = AppDelegation.interactor!! //TODO!!!!!!!!!!!



    fun registration(){
        viewState.showRegistrationScreen()
    }

    fun login(login: String, password: String){
        interactor.login(login, password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {viewState.showLoading()}
            .doFinally{viewState.hideLoading()  }
            .subscribe(
                {viewState.showDesk()}
            ,
                {
                    when(it.message){
                        UserInteractor.LOGIN_IS_EMPTY -> showError("Поле с логином пусто")
                        UserInteractor.PASSWORD_IS_EMPTY -> showError("Поле с паролем пусто")
                        else -> showError("Ошибка!")
                    }
                })
    }


    private fun showError(errorMessage : String){
        viewState.showError(errorMessage)

    }




}