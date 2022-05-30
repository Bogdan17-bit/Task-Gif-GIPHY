package com.example.kotlingiftask.fullscreen

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TableLayout
import com.example.kotlingiftask.R
import com.example.kotlingiftask.main.GifsDisplayPresenter

class FullscreenActivity : AppCompatActivity(), GifFullscreen.View {

    private lateinit var singleImageView : ImageView
    private val presenter = GifFullscreenPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fullscreen)
        singleImageView = findViewById(R.id.fullscreenImage)
    }

    override fun getSingleImageView(): ImageView {
        return singleImageView
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun getContext(): Context {
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.showImageFullscreen()
    }

    override fun getUrlImageFromIntent() : String {
        return intent.getStringExtra("imageURL")!!
    }

}