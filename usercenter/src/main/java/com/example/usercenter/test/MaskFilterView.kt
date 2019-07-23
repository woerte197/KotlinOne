package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class MaskFilterView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private var mBitmap: Bitmap? = null
    init {
        setLayerType(LAYER_TYPE_SOFTWARE,null)
        mPaint = Paint()
        mPaint!!.color  = Color.RED
        mPaint!!.strokeWidth = 5f
        mPaint!!.textSize = 50f
        mPaint!!.style = Paint.Style.STROKE
        val maskFilter = BlurMaskFilter(10f, BlurMaskFilter.Blur.SOLID)
        mPaint!!.maskFilter = maskFilter
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.no_banner)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawColor(Color.WHITE)
        canvas.drawText("你好啊",100f,100f,mPaint)
        canvas.drawBitmap(mBitmap,null, Rect(300, 50, (300f+mBitmap!!.width).toInt(), (50f+mBitmap!!.height).toInt()),mPaint)
    }


}