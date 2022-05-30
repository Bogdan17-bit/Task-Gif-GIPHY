package com.example.kotlingiftask.mvp

interface MvpPresenter <V : MvpView> { // базовий інтерфейс для Presenter

    fun attachView(mvpView : V)

    fun viewIsReady(): Boolean

    fun getView() : V

    fun detachView()

    fun destroy()

}