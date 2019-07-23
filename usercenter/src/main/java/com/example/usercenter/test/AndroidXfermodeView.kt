package com.example.usercenter.test

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class AndroidXfermodeView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mPaint: Paint? = null
    private var mBitmap: Bitmap? = null
    private var otherBitmap: Bitmap? = null

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mPaint = Paint()
        mPaint!!.color = Color.RED
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
    }

    private fun makeBitmap(width: Int, height: Int): Bitmap? {
//        val w = if (width > 200) { 200 } else { width }
//        val h = if (height > 200) { 200 } else { height }
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val paint = Paint()
        paint.color = Color.GREEN
        canvas.drawRoundRect(RectF(0f,0f, width.toFloat(), height.toFloat()),30f , 30f, paint)
        return bitmap
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        otherBitmap = makeBitmap(width, height)
        val layerID = canvas!!.saveLayer(0f, 0f, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        canvas.drawBitmap(otherBitmap!!, 0f, 0f, mPaint)
        mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
        canvas.drawBitmap(mBitmap!!, 0f, 0f, mPaint)

        mPaint!!.xfermode = null

        canvas.restoreToCount(layerID)
    }


}



