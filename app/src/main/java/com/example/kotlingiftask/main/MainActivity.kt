package com.example.kotlingiftask.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TableLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlingiftask.R
import com.example.kotlingiftask.device.Network
import com.example.kotlingiftask.device.Screen
import com.example.kotlingiftask.fullscreen.FullscreenActivity


class MainActivity : GifsDisplay.View, AppCompatActivity() {

    private lateinit var tableLayout : TableLayout
    private val presenter = GifsDisplayPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        if (!Network.isNetworkAvailable(this)) {
            finish()
            Toast.makeText(this, "Сheck the Internet connection!", Toast.LENGTH_SHORT).show()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tableLayout = findViewById(R.id.tableGifs)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.setTrendingGifs()
    }

    override fun getTableGifs(): TableLayout {
        return tableLayout
    }

    override fun openInFullScreen(url : String) {
        val intent = Intent(this@MainActivity, FullscreenActivity::class.java)
        intent.putExtra("imageURL", url)
        startActivity(intent)
    }

    override fun getWidthActivity(): Int {
        return Screen.getDisplaySize(this).first
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun getContext(): Context {
        return this
    }
}