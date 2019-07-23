package com.example.usercenter.test

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

class RQuadView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPath: Path? = null
    private var mPaint: Paint? = null
    private val mItenLength = 1200f
    private var dx = 0f

    init {
        mPaint = Paint()
        mPaint!!.strokeWidth = 4f
        mPaint!!.color = Color.RED
        mPaint!!.style = Paint.Style.FILL
        mPath = Path()
//        mPath!!.moveTo(100f, 300f)
//        mPath!!.rQuadTo(100f, -100f, 200f, 0f)
//        mPath!!.rQuadTo(100f, 100f, 200f, 0f)
        startAnimator()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPath!!.reset()
        val originY = 300f
        val halfLen = mItenLength / 2
        mPath!!.moveTo(-mItenLength + dx, originY)
        var i = -mItenLength
        while (i<= (width+mItenLength)){
            mPath!!.rQuadTo(halfLen / 2, -100f, halfLen, 0f)
            mPath!!.rQuadTo(halfLen / 2, 100f, halfLen, 0f)
            i += mItenLength
        }
        mPath!!.lineTo(width.toFloat(), height.toFloat())
        mPath!!.lineTo(0f, height.toFloat())
        mPath!!.close()
        canvas!!.drawPath(mPath, mPaint)
    }

    fun startAnimator() {
        val animator: ValueAnimator = ValueAnimator.ofFloat(0f, mItenLength)
        animator.duration = 2000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.addUpdateListener {
            dx = it.animatedValue as Float
            postInvalidate()
        }
        animator.start()
    }
}