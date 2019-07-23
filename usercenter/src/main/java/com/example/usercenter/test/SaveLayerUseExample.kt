package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class SaveLayerUseExample @kotlin.jvm.JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr){
    private var mBitmap:Bitmap? = null
    private var mPaint: Paint? = null

    init {
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
        mPaint = Paint()
        mPaint!!.color = Color.GRAY
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawBitmap(mBitmap,0f,0f,mPaint)
        val layerId = canvas.saveLayerAlpha(0f,0f, width.toFloat(), height.toFloat(),100)
//        canvas.skew(1.732f,0f)
        canvas.drawRect(0f,0f,150f,160f,mPaint)
        canvas.restoreToCount(layerId)
    }
}