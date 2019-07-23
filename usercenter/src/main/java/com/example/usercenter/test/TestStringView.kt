package com.example.usercenter.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class TestStringView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private val string = "Hello World"
    private val baseLineX = 0f
    private val baseLineY = 200f

    init {
        mPaint = Paint()
        mPaint!!.color = Color.RED
        mPaint!!.strokeWidth = 4f
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawLine(baseLineX, baseLineY, 3000f, baseLineY, mPaint)
        mPaint!!.color = Color.GREEN
        mPaint!!.textSize = 120f
        mPaint!!.textAlign = Paint.Align.CENTER
        canvas.drawText(string, baseLineX, baseLineY, mPaint)
        val assent = mPaint!!.fontMetrics.ascent
        val top = mPaint!!.fontMetrics.top
        val bottom = mPaint!!.fontMetrics.bottom
        val descent = mPaint!!.fontMetrics.descent
        canvas.drawLine(baseLineX, baseLineY + top, 300f, baseLineY + top, mPaint)
        canvas.drawLine(baseLineX, baseLineY + descent, 300f, baseLineY + descent, mPaint)
        canvas.drawLine(baseLineX, baseLineY + assent, 300f, baseLineY + assent, mPaint)
        canvas.drawLine(baseLineX, baseLineY + bottom, 300f, baseLineY + bottom, mPaint)
    }
}