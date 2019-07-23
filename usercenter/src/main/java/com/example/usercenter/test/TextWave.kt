package com.example.usercenter.test

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class TextWave @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mTargetBitmap: Bitmap? = null
    private var mBitmap: Bitmap? = null
    private var mPaint: Paint? = null
    private var mTextPaint: Paint? = null
    private var mPath: Path? = null
    private var mWaveItemLength = 1200f
    private var dx = 0f

    init {
        mPaint = Paint()
        mPaint!!.strokeWidth = 4f
        mPaint!!.color = Color.RED
        mPaint!!.style = Paint.Style.FILL
        mPath = Path()
        mTextPaint = Paint()
        mTextPaint!!.color = Color.BLACK
        mTextPaint!!.style = Paint.Style.FILL_AND_STROKE
        mTextPaint!!.textSize = 100f
        startAnimator()
    }

    private fun startAnimator() {
        val valueAnimator = ValueAnimator.ofFloat(0f, mWaveItemLength)
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.addUpdateListener {
            dx = it.animatedValue as Float
            postInvalidate()
        }
        valueAnimator.duration = 2000
        valueAnimator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        mTargetBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val bCanvas = Canvas(mBitmap)
        bCanvas.drawText("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 10f, 300f, mTextPaint)
        getWave()
        val aCanvas = Canvas(mTargetBitmap)
        aCanvas.drawColor(Color.BLACK,PorterDuff.Mode.CLEAR)
        aCanvas.drawPath(mPath, mPaint)
        canvas!!.drawBitmap(mBitmap, 0f, 0f, mPaint)
        val layerId = canvas!!.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(mBitmap, 0f, 0f, mPaint)
        mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(mTargetBitmap, 0f, 0f, mPaint)
        mPaint!!.xfermode = null
        canvas.restoreToCount(layerId)
    }

    private fun getWave() {
        mPath!!.reset()
        val originY = 300f
        val halfLen = mWaveItemLength / 2
        mPath!!.moveTo(-mWaveItemLength + dx, originY)
        var i = -mWaveItemLength
        while (i<= (width+mWaveItemLength)){
            mPath!!.rQuadTo(halfLen / 2, -100f, halfLen, 0f)
            mPath!!.rQuadTo(halfLen / 2, 100f, halfLen, 0f)
            i += mWaveItemLength
        }
        mPath!!.lineTo(width.toFloat(), height.toFloat())
        mPath!!.lineTo(0f, height.toFloat())
        mPath!!.close()
    }

}