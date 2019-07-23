package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.usercenter.R

class EraserView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mBitmap: Bitmap? = null
    private var mTargetmap: Bitmap? = null
    private var mPath: Path? = null
    private var mPaint: Paint? = null
    private var mTextPaint: Paint? = null
    private var pointX = 0f
    private var pointY = 0f


    init {
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        mBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog, options)
        mPaint = Paint()
        mPaint!!.color = Color.RED
        mPaint!!.style= Paint.Style.STROKE
        mPaint!!.strokeWidth = 50f
        mTextPaint = Paint()
        mTextPaint!!.color = Color.BLUE
        mTextPaint!!.style = Paint.Style.STROKE
        mTextPaint!!.strokeWidth = 1f
        mTextPaint!!.textSize = 30f
        mPath = Path()
        mTargetmap = Bitmap.createBitmap(mBitmap!!.width, mBitmap!!.height, Bitmap.Config.ARGB_8888)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                pointX = event.x
                pointY = event.y
                mPath!!.moveTo(pointX, pointY)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                mPath!!.quadTo(pointX, pointY, (event.x + pointX) / 2, (event.y + pointY) / 2)
                pointX = event.x
                pointY = event.y
            }
        }
        postInvalidate()
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawText("谢谢惠顾！",width/2f, height/2f,mTextPaint)
        val layerId = canvas!!.saveLayer(0f,0f, width.toFloat(), height.toFloat(),null,Canvas.ALL_SAVE_FLAG)
        val tCanvas = Canvas(mTargetmap)
        tCanvas.drawPath(mPath, mPaint)
        canvas!!.drawBitmap(mTargetmap, 0f, 0f, mPaint)

        mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_OUT)
        canvas!!.drawBitmap(mBitmap,  0f, 0f, mPaint)
        mPaint!!.xfermode = null
        canvas.restoreToCount(layerId)
    }

}