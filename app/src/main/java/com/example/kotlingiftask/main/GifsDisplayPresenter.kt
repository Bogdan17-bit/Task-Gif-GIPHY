package com.example.kotlingiftask.main

import android.widget.ImageView
import android.widget.TableRow
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlingiftask.api.NetworkService
import com.example.kotlingiftask.device.Network
import com.example.kotlingiftask.model.Gif
import com.example.kotlingiftask.model.JsonResponse
import com.example.kotlingiftask.mvp.PresenterBase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GifsDisplayPresenter : PresenterBase<GifsDisplay.View>(), GifsDisplay.Presenter {
    
    override fun setTrendingGifs() {

        NetworkService.apiService.getTrendingGifs()?.enqueue(object : Callback<JsonResponse?> {
            override fun onResponse(call: Call<JsonResponse?>, response: Response<JsonResponse?>) {
                val responseBody = response.body()
                fillTableGifs(responseBody!!.gifs)
            }

            override fun onFailure(call: Call<JsonResponse?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    override fun clearTable() {
        getView().getTableGifs().removeAllViews()
    }

    override fun fillTableGifs(gifs : List<Gif>) {

        clearTable()

        val numberGifsInRow : Int by lazy {
            getView().getWidthActivity() / 500 // 500 пікселей на кожну gif
        }

        var counterGifs = 0
        var tableRow = TableRow(getView().getContext())

        for(gif in gifs) {

            val imageView = ImageView(getView().getContext())
            imageView.tag = gif.images.parameters.url

            imageView.setOnClickListener{
                getView().openInFullScreen( imageView.tag.toString())
            }

            Glide.with(getView().getActivity())
                .load(gif.images.parameters.url)
                .centerCrop()
                .apply(RequestOptions().override(getView().getWidthActivity() / numberGifsInRow))
                .into(imageView)

            if(counterGifs == numberGifsInRow - 1) {
                tableRow.addView(imageView, counterGifs)
                getView().getTableGifs().addView(tableRow)
                tableRow = TableRow(getView().getContext())
                counterGifs = 0
            }

            else{
                tableRow.layoutParams = TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
                )
                tableRow.addView(imageView, counterGifs)
                counterGifs += 1
            }

        }

    }

}