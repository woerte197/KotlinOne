package com.example.usercenter.test

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.usercenter.R

class GetSegmentView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var paint: Paint? = null
    private var mPath: Path? = null
    private var mTargetPath: Path? = null
    private var mPathMeasure: PathMeasure? = null
    private var mCurAnimValue: Float = 0.0f
    private var mBitmap: Bitmap? = null
    private var pos: FloatArray = FloatArray(2)
    private var tan: FloatArray = FloatArray(2)

    init {
        paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint!!.style = Paint.Style.STROKE
        paint!!.strokeWidth = 4f
        paint!!.color = Color.BLACK
        mPath = Path()
        mTargetPath = Path()
        val options =  BitmapFactory.Options()

        options.inJustDecodeBounds = true

        BitmapFactory.decodeResource(resources, R.drawable.jiantou,options)
        //获取采样率
        val width = options.outWidth
        val height = options.outHeight
         options.inSampleSize = 8
        options.inJustDecodeBounds = false

        mBitmap=  BitmapFactory.decodeResource(resources,R.drawable.jiantou,options)

        mTargetPath!!.addCircle(100f, 100f, 50f, Path.Direction.CW)
        mPathMeasure = PathMeasure(mTargetPath, true)
        val valueAnimator = ValueAnimator.ofFloat(0f, 1f)
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.addUpdateListener {
            mCurAnimValue = it.animatedValue as Float
            invalidate()
        }
        valueAnimator.duration = 2000
        valueAnimator.start()

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas!!.drawColor(Color.WHITE)
        val length = mPathMeasure!!.length
        val stop = length * mCurAnimValue
//        mPathMeasure!!.getPosTan(stop, pos, tan)
//        val jiaodu = (Math.atan2(pos[0].toDouble(), pos[1].toDouble()) * 180 / Math.PI).toFloat()
        val matrix = Matrix()
//        matrix.postRotate(jiaodu, (mBitmap!!.width / 2).toFloat(), (mBitmap!!.height / 2).toFloat())
//        matrix.postTranslate(pos[0] - mBitmap!!.width / 2, pos[1] - mBitmap!!.height / 2)
        mPathMeasure!!.getMatrix(stop,matrix,PathMeasure.POSITION_MATRIX_FLAG)
        matrix.postTranslate((-mBitmap!!.width/2).toFloat(), (-mBitmap!!.height/2).toFloat())
//        var start: Float = ((stop - ((0.5 - Math.abs(mCurAnimValue - 0.5)) * length)).toFloat())
        mPath!!.reset()
        mPathMeasure!!.getSegment(0f, stop, mPath, true)
        canvas!!.drawPath(mPath, paint)
        canvas.drawBitmap(mBitmap, matrix, paint)
    }


}