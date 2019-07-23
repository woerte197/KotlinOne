package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.usercenter.R

class BackgroundImage @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mBitmap: Bitmap? = null
    private var mPaint: Paint? = null
    private var mDx = 0.0f
    private var mDy = 0.0f

    init {
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
        mPaint = Paint()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                mDx = event.x
                mDy = event.y
                postInvalidate()
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                mDx = event.x
                mDy = event.y
                postInvalidate()
            }
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> {
                mDx = -1f
                mDy = -1f
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mBitmap == null) {
            mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val tCanVans = Canvas(mBitmap)
            tCanVans.drawBitmap(mBitmap, null, Rect(0, 0, width, height), mPaint)
        }
        if (mDx != -1f && mDy != -1f) {
            mPaint!!.shader = BitmapShader(mBitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT)
            canvas!!.drawCircle(mDx, mDy, 150f, mPaint)
        }

    }


}