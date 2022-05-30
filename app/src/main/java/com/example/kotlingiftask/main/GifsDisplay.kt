package com.example.kotlingiftask.main

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.TableLayout
import android.widget.TextView
import com.example.kotlingiftask.model.Gif
import com.example.kotlingiftask.mvp.MvpPresenter
import com.example.kotlingiftask.mvp.MvpView

interface GifsDisplay {

    interface View : MvpView {  // інтерфейс для View

        fun getTableGifs() : TableLayout

        fun getActivity() : Activity

        fun getContext() : Context

        fun openInFullScreen(url : String)

        fun getWidthActivity() : Int // gif складатиме мінімум 500 пікселей в ширину, тому треба тільки width

    }

    interface Presenter : MvpPresenter<View> {  // інтерфейс для Presenter

        fun fillTableGifs(gifs : List<Gif>)

        fun clearTable()

        fun setTrendingGifs()

    }
}