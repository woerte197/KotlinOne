package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class CircleImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mBitmap: Bitmap? = null
    private var mPaint: Paint? = null
    private var mShader: BitmapShader? = null


    init {
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
        mPaint = Paint()
        mShader = BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var matrix = Matrix()
        var scale = width / mBitmap!!.width
        matrix.setScale(scale.toFloat(), scale.toFloat())
        mShader!!.setLocalMatrix(matrix)
        mPaint!!.shader = mShader
        var halfX = width/2
        var halfY = height/2
        canvas!!.drawCircle(halfX.toFloat(), halfY.toFloat(), (width/2).toFloat(),mPaint)

    }

}