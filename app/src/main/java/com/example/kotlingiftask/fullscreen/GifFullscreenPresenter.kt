package com.example.kotlingiftask.fullscreen

import com.bumptech.glide.Glide
import com.example.kotlingiftask.mvp.PresenterBase

class GifFullscreenPresenter : PresenterBase<GifFullscreen.View>(), GifFullscreen.Presenter {

    override fun showImageFullscreen() {
        val urlImage : String = getView().getUrlImageFromIntent()
        Glide.with(getView().getActivity())
            .load(urlImage)
            .into(getView().getSingleImageView())
    }
}