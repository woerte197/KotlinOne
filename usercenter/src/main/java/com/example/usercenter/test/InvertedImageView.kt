package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class InvertedImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mBitmap: Bitmap? = null
    private var mTargetBitmap: Bitmap? = null
    private var mPaint: Paint? = null
    private var mRevertBitmap: Bitmap? = null

    init {
        mPaint = Paint()
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
        mTargetBitmap = BitmapFactory.decodeResource(resources, R.drawable.testzhe)
        val matrix = Matrix()
        matrix.setScale(1f, -1f)
        mRevertBitmap = Bitmap.createBitmap(mBitmap,0,0,mBitmap!!.width,mBitmap!!.height,matrix,true)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val width = width /2
        val height = width* mBitmap!!.height/mBitmap!!.width
        canvas!!.drawBitmap(mBitmap,null, Rect(0,0,width,height),mPaint)
        var layerId = canvas.saveLayer(0f,0f, getWidth().toFloat(), getHeight().toFloat(),null,Canvas.ALL_SAVE_FLAG)
        canvas.translate(0f, height.toFloat())
        canvas.drawBitmap(mTargetBitmap,null, Rect(0,0,width,height),mPaint)
        mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN )
        canvas.drawBitmap(mRevertBitmap,null,Rect(0,0,width,height),mPaint)
        mPaint!!.xfermode = null
        canvas.restoreToCount(layerId)



    }

}