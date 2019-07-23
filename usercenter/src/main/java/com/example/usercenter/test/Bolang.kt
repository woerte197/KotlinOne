package com.example.usercenter.test

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class Bolang @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mTargetBitmap: Bitmap? = null
    private var mBitmap: Bitmap? = null
    private var mPaint: Paint? = null
    private var dx = 0f
    private var length = 0f


    init {
        mPaint = Paint()
        mPaint!!.strokeWidth = 4f
        mPaint!!.color = Color.WHITE
        mPaint!!.style = Paint.Style.FILL_AND_STROKE
        mTargetBitmap = BitmapFactory.decodeResource(resources, R.drawable.bolang)
        length = mTargetBitmap!!.width.toFloat()
        startAnima()
    }

    private fun startAnima() {
        val valueAnimator = ValueAnimator.ofFloat(0f, length)
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.addUpdateListener {
            dx = it.animatedValue as Float
            postInvalidate()
        }
        valueAnimator.duration = 4000
        valueAnimator.start()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val bCanvas = Canvas(mBitmap)
        bCanvas.drawCircle(width / 2f, height / 2f, width / 2f, mPaint)
        canvas!!.drawBitmap(mBitmap,0f,0f,mPaint)
        val layerId = canvas!!.saveLayer(0f,0f, width.toFloat(), height.toFloat(),null,Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(mTargetBitmap, Rect(dx.toInt(),0, (dx+mBitmap!!.width).toInt(), (dx+mBitmap!!.height).toInt()), Rect(0,0,mBitmap!!.width,mBitmap!!.height),mPaint)
        mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        canvas.drawBitmap(mBitmap,0f,0f,mPaint)
        mPaint!!.xfermode = null
        canvas.restoreToCount(layerId)
    }
}