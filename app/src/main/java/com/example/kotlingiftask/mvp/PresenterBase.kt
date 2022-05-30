package com.example.kotlingiftask.mvp

abstract class PresenterBase <T : MvpView> : MvpPresenter<T> { // Базовий клас для Presenter

    private var view: T? = null

    override fun getView(): T {
        return view!!
    }

    override fun attachView(mvpView: T) {
        view = mvpView
    }

    override fun viewIsReady(): Boolean {
        return view == null
    }

    override fun detachView() {
        view = null
    }

    override fun destroy() {
        TODO("Not yet implemented")
    }
}