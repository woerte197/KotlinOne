package com.example.usercenter.test

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class HeartView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mLeftPath: Path? = null
    private var mRightPath: Path? = null
    private var mPaint: Paint? = null
    private var mBoLangPath: Path? = null
    private var mPreX = 0.0f
    private var mPreY = 0.0f

    init {
        mLeftPath = Path()
        mRightPath = Path()
        mBoLangPath = Path()
        mPaint = Paint()
        mPaint!!.color = Color.RED
        mPaint!!.strokeWidth = 4f
        mPaint!!.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mLeftPath!!.moveTo(100f, 150f)
        mLeftPath!!.quadTo(10f, 20f, 100f, 250f)
        mRightPath!!.moveTo(100f, 150f)
        mRightPath!!.quadTo(190f, 20f, 100f, 250f)
//        mBoLangPath!!.moveTo(100f, 300f)
//        mBoLangPath!!.quadTo(200f, 200f, 300f, 300f)
//        mBoLangPath!!.quadTo(400f, 400f, 500f, 300f)
//        canvas!!.drawPath(mLeftPath, mPaint)
//        canvas!!.drawPath(mRightPath, mPaint)
        canvas!!.drawPath(mBoLangPath, mPaint)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                var x = event.x
                var y = event.y
                mPreX = x
                mPreY = y
                mBoLangPath!!.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                var x = (mPreX + event.x) / 2
                var y = (mPreY + event.y) / 2
                mBoLangPath!!.quadTo(mPreX, mPreY, x, y)
                mPreX = event.x
                mPreY = event.y
                postInvalidate()
            }
            MotionEvent.ACTION_UP -> {
            }
        }
        return super.onTouchEvent(event)
    }


}