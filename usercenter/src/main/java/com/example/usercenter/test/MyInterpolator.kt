package com.example.usercenter.test

import android.animation.TimeInterpolator


class MyInterpolator(valueCount: Int) : TimeInterpolator {
    override fun getInterpolation(input: Float): Float {
        return 1 - input
    }

}