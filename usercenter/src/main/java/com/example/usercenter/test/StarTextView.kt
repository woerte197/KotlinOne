package com.example.usercenter.test

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.widget.TextView

class StarTextView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr) {

    private var mLinearGradient: LinearGradient? = null
    private var mPaint: Paint? = null
    private val mColors = intArrayOf(Color.BLACK, Color.GREEN, Color.BLACK)
    private val mPoints = floatArrayOf(0f, 0.5f, 1.0f)
    private var mDx = 0f
    private var mLength = 0f

    init {
        mPaint = paint
        mPaint!!.textSize = 40f
        mPaint!!.color = Color.RED
        mLength = mPaint!!.measureText(text.toString())
        mLinearGradient = LinearGradient(-mLength, 0f, 0f, 0f, mColors, mPoints, Shader.TileMode.CLAMP)
        val valueAnimator = ValueAnimator.ofFloat(0f, 2 * mLength)
        valueAnimator.addUpdateListener {
            mDx = it.animatedValue as Float
            postInvalidate()
        }
        valueAnimator.duration = 2000
        valueAnimator.repeatMode = ValueAnimator.RESTART
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        val matrix = Matrix()
        matrix.setTranslate( mDx,0f)
        mLinearGradient!!.setLocalMatrix(matrix)
        mPaint!!.shader = mLinearGradient
        super.onDraw(canvas)

    }


}