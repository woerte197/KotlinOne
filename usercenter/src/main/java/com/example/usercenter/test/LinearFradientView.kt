package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class LinearFradientView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private val mColors = intArrayOf(Color.RED, Color.BLUE, Color.GREEN)
    private val mPoint = floatArrayOf(0f, 0.5f, 1.0f)

    init {
        mPaint = Paint()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint!!.shader = LinearGradient(0f, 0f, width.toFloat() / 2, height.toFloat() / 2, mColors, mPoint, Shader.TileMode.REPEAT)
//        canvas!!.drawRect(0f, 0f, width.toFloat(), height.toFloat(), mPaint)
        mPaint!!.textSize = 20f
        canvas!!.drawText("你好啊！我叫王杨", 0f, 200f, mPaint)
    }


}