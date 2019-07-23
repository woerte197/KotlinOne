package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class BitmapLayerView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mBitmap: Bitmap? = null
    private var mAlpahBitmap: Bitmap? = null
    private var mPaint: Paint? = null
    private var mTargetValue = 10

    init {
        mPaint = Paint()
        mPaint!!.strokeWidth = 4f
        mPaint!!.color = Color.GRAY
        mPaint!!.style = Paint.Style.FILL
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.icon_phone)
        mAlpahBitmap = mBitmap!!.extractAlpha()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val blurMaskFilter = BlurMaskFilter(10f, BlurMaskFilter.Blur.NORMAL)
        mPaint!!.maskFilter = blurMaskFilter
        canvas!!.drawBitmap(mAlpahBitmap, null, Rect(100+mTargetValue, 100+mTargetValue, 100+mTargetValue + mAlpahBitmap!!.width, 100+mTargetValue + mAlpahBitmap!!.height), mPaint)
        mPaint!!.maskFilter = null
        canvas!!.drawBitmap(mBitmap, null, Rect(100, 100, 100 + mBitmap!!.width, 100 + mBitmap!!.height), mPaint)
    }

}