package com.example.usercenter.test

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class AliPayView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPath: Path? = null
    private var mTurePath: Path? = null
    private var mTargetPath: Path? = null
    private var mPaint: Paint? = null
    private var mPathMeasure: PathMeasure? = null
    private val mRadius = 100f
    private val mPointX = 250f
    private val mPointY = 250f
    private var mValue: Float = 0.0f
    private var isNext: Boolean = false

    init {
        mPath = Path()
        mTargetPath = Path()
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint!!.style = Paint.Style.STROKE
        mPaint!!.strokeWidth = 4f
        mPaint!!.color = Color.BLACK
        mTargetPath!!.addCircle(mPointX, mPointY, mRadius, Path.Direction.CW)
        mTargetPath!!.moveTo(mPointX - mRadius / 2, mPointY)
        mTargetPath!!.lineTo(mPointX, mPointY + mRadius / 2)
        mTargetPath!!.lineTo(mPointX + mRadius / 2, mPointY - mRadius / 3)
        mPathMeasure = PathMeasure(mTargetPath, false)
        val valueAnimator = ValueAnimator.ofFloat(0f, 2f)
        valueAnimator.addUpdateListener {
            mValue = it.animatedValue as Float
            Log.e("sadasdsa", mValue.toString())
            invalidate()
        }
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.duration = 10000
        valueAnimator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawColor(Color.WHITE)
        when {
            mValue < 1f -> {
                mPathMeasure!!.getSegment(0f, mPathMeasure!!.length * mValue, mPath, true)
            }
            else -> {
                if (!isNext) {
                    mPathMeasure!!.nextContour()
                    isNext = true
                }
                mPathMeasure!!.getSegment(0f, mPathMeasure!!.length * (mValue - 1), mPath, true)
            }
        }
        canvas!!.drawPath(mPath, mPaint)


    }

}