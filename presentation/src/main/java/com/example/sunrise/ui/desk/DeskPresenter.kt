package com.example.sunrise.ui.desk

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.domain.interactor.SunriseInteractor
import com.example.sunrise.AppDelegation
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@InjectViewState
class DeskPresenter  : MvpPresenter<DeskView>()  {

    val interactor : SunriseInteractor = AppDelegation.interactor!! //TODO


    fun getTasks(){

        interactor.getTasks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {viewState.showLoading()}
            .doFinally{viewState.hideLoading()  }
            .subscribe(
                {viewState.showTasks(it)}
                ,
                {viewState.showError("Ошибка!") })

    }


}