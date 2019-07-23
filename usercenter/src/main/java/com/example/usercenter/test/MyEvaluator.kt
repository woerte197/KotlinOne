package com.example.usercenter.test

import android.animation.TypeEvaluator
import android.graphics.Point

class MyEvaluator<T> : TypeEvaluator<T> {
    override fun evaluate(fraction: Float, startValue: T, endValue: T): T? {
        if (startValue is Int) {
            return ((startValue as Int).plus((endValue as Int) - (startValue as Int)) * fraction) as T
        }
        if (startValue is Float) {
            return ((endValue as Float).minus((endValue as Float) - (startValue as Float)) * fraction) as T
        }
        if (startValue is Char) {
            val startInt = (startValue as Char).toInt()
            val endStart = (endValue as Char).toInt()
            val result = (startInt + (endStart - startInt) * fraction).toChar()
            return result as T
        }
        if (startValue is Point) {
            val startPoint = startValue as Point
            val endPoint = endValue as Point
            val pointX = (startPoint.x + (endPoint.x - startPoint.x) * fraction).toInt()
            val pointY: Int =
                    if (fraction * 2 < 1) {
                        (startPoint.y + (endPoint.y - startPoint.y) * fraction).toInt()
                    } else {
                        endPoint.y
                    }
            return Point(pointX, pointY) as T
        }
        return null
    }

}