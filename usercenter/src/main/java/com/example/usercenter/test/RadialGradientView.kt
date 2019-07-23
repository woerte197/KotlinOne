package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class RadialGradientView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private val mColors = intArrayOf(Color.RED, Color.BLACK, Color.GREEN, Color.BLUE)
    private val mPoint = floatArrayOf(0.2f,0.4f,0.6f,1.0f)
    private var radialGradient: RadialGradient? = null

    init {
        mPaint = Paint()
        mPaint!!.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        radialGradient = RadialGradient(width / 2.toFloat(), height / 2.toFloat(), width / 6.toFloat(), mColors,mPoint, Shader.TileMode.CLAMP)
        mPaint!!.shader = radialGradient
        canvas!!.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), (width / 2).toFloat(), mPaint)

    }


}