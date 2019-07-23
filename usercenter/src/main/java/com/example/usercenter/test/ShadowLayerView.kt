package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class ShadowLayerView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private var mBitmap: Bitmap? = null

    init {
        mPaint = Paint()
        mPaint!!.color = Color.RED
        mPaint!!.textSize = 50f
        mPaint!!.strokeWidth = 4f
        mPaint!!.style = Paint.Style.STROKE
        mPaint!!.setShadowLayer(1.0f, 10f, 10f, Color.GREEN)
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.icon_phone)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawColor(Color.WHITE)
        canvas!!.drawText("王洋", 100f, 100f, mPaint)
        canvas.drawCircle(200f, 200f, 50f, mPaint)
        canvas!!.drawBitmap(mBitmap, null, Rect(500, 50, 500 + mBitmap!!.width, 50 + mBitmap!!.height), mPaint)
    }

    fun clearShadowLayer() {
        mPaint!!.clearShadowLayer()
        postInvalidate()
    }

}