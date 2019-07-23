package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class BitmapShaderView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mBitmap: Bitmap? = null
    private var mPaint: Paint? = null

    init {
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
        mPaint = Paint()
        mPaint!!.color = Color.RED
        mPaint!!.style = Paint.Style.FILL
        val bitmapShader = BitmapShader(mBitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR)
        mPaint!!.shader = bitmapShader
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val top = height / 3
        val left = width / 3
        val bottom = height / 3 * 2
        val right = width / 3 * 2
        canvas!!.drawRect(top.toFloat(), left.toFloat(), bottom.toFloat(), right.toFloat(), mPaint)
    }


}