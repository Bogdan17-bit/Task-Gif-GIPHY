package com.example.kotlingiftask.fullscreen

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.example.kotlingiftask.mvp.MvpPresenter
import com.example.kotlingiftask.mvp.MvpView

interface GifFullscreen {

    interface View : MvpView {  // інтерфейс для View

        fun getUrlImageFromIntent() : String

        fun getSingleImageView() : ImageView

        fun getActivity() : Activity

        fun getContext() : Context

    }

    interface Presenter : MvpPresenter<View> {  // інтерфейс для Presenter

        fun showImageFullscreen()

    }
}