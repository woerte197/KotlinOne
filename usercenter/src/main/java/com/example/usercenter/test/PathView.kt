package com.example.usercenter.test

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View

class PathView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()
    override fun onDraw(canvas: Canvas?) {
        canvas!!.translate(200F, 200F)
//        path.moveTo(0f,0f)
//        path.lineTo(0F, 100F)
//        path.lineTo(100F, 100F)
//        path.lineTo(100F, 0F)
        val path = Path()
        val path1 = Path()
        path1.moveTo(0f,0f)
        path1.lineTo(100f,200f)
//        val path2 = Path()
        path.addRect(-50f, -50f, 50f, 50f, Path.Direction.CW)
//        path.addRect(-100f,-100f,100f,100f,Path.Direction.CW)
//        path.addRect(-150f,-150f,150f,150f,Path.Direction.CW)
        val pathMeasure = PathMeasure(path, false)
        pathMeasure.getSegment(0f,200f,path1,false)
        paint.color = Color.BLUE
        paint.strokeWidth = 8f
        paint.style = Paint.Style.STROKE
        canvas.drawPath(path1, paint)
        do {
            Log.e("pathMeasure", "${pathMeasure.length}")
        } while (pathMeasure.nextContour())
//        canvas.drawPath(path1, paint)
//        canvas.drawPath(path2, paint)
//        Log.e("pathMeasure1", "${pathMeasure1.length}")
    }


}