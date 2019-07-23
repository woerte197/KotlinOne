package com.example.usercenter.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TopTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var top = 200f
    private var baseLineX = 0f
    private var mPaint: Paint? = null
    private val mString = "Top Line TextView"

    init {
        mPaint = Paint()
        mPaint!!.color = Color.RED
        mPaint!!.strokeWidth = 4f
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas!!.drawLine(baseLineX, top, 3000f, top, mPaint)
        var mBaseLineY = top - mPaint!!.fontMetrics.top
        canvas!!.drawText(mString,baseLineX,mBaseLineY,mPaint)
    }


}