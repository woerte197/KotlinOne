package com.example.usercenter.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class CanvansFlagView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null

    init {
        mPaint = Paint()
        mPaint!!.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
     /*

        canvas!!.save()
        canvas.rotate(40f)
        canvas.drawRect(100f,0f,200f,100f,mPaint)
        canvas.restore()
        mPaint!!.color = Color.GRAY
        canvas.drawRect(100f,0f,200f,100f,mPaint)*/
        /*canvas!!.save()
        canvas.clipRect(100,0,200,100)
        canvas.drawColor(Color.GRAY)
        canvas.restore()
        canvas.drawColor(Color.BLACK)*/
        canvas!!.drawColor(Color.RED)


    }
}


