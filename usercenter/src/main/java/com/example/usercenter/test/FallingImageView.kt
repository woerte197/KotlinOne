package com.example.usercenter.test

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

class FallingImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    init {

    }

    fun setFallingPos(point: Point) {
        this.layout(point.x, point.y, point.x + width, point.y + height)
    }


}