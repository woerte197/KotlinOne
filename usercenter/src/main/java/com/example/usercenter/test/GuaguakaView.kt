package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.os.Build
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.example.usercenter.R

class GuaguakaView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var mSrcBitmap: Bitmap? = null
    private var mTargetBitmap: Bitmap? = null
    private var mPaint: Paint? = null
    private var mTextPaint: Paint? = null
    private var mPath: Path? = null
    private var mDx = 0f
    private var mDy = 0f

    init {
        mPaint = Paint()
        mPaint!!.style = Paint.Style.STROKE
        mPaint!!.strokeWidth = 20f
        mTextPaint = Paint()
        mTextPaint!!.textSize = 20f
        mTextPaint!!.style = Paint.Style.STROKE
        mTextPaint!!.strokeWidth = 5f
        mTextPaint!!.color = Color.RED
        mTargetBitmap = BitmapFactory.decodeResource(resources, R.drawable.dog)
        mSrcBitmap = Bitmap.createBitmap(
                mTargetBitmap!!.width,
                mTargetBitmap!!.height,
                Bitmap.Config.ARGB_8888
        )
        mPath = Path()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                mDx = event.x
                mDy = event.y
                mPath!!.moveTo(mDx, mDy)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val endX = (event.x + mDx) / 2
                val endY = (event.y + mDy) / 2
                mPath!!.quadTo(mDx, mDy, endX, endY)
                mDy = event.y
                mDx = event.x
            }
        }
        postInvalidate()
        return super.onTouchEvent(event)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val canvasSrc = Canvas(mSrcBitmap)
        canvasSrc.drawPath(mPath, mPaint)
        canvas!!.drawText("谢谢惠顾！", width / 2f, height / 2f, mTextPaint)
        val layerId = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.saveLayer(0F, 0F, width.toFloat(), height.toFloat(), mPaint)
        } else {
            canvas.saveLayer(0F, 0F, width.toFloat(), height.toFloat(), null, Canvas.ALL_SAVE_FLAG)
        }
        canvas.drawBitmap(mTargetBitmap, 0f, 0f, mPaint)
        mPaint!!.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        canvas.drawBitmap(mSrcBitmap, 0f, 0f, mPaint)
        mPaint!!.xfermode = null
        canvas.restoreToCount(layerId)
    }

}