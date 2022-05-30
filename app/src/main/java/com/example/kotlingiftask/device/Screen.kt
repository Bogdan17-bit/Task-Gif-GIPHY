package com.example.kotlingiftask.device

import android.app.Activity
import android.graphics.Point

class Screen {

    companion object {

        fun getDisplaySize(activity: Activity) : Pair<Int, Int> {
            val display = activity.windowManager.defaultDisplay
            var size = Point()
            display.getSize(size)
            return Pair(size.x, size.y)
        }

    }

}