package com.example.usercenter.test

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class MyTestView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : TextView(context, attrs, defStyleAttr){



    fun setMyValue( char: Char){
        text = char.toString()
    }
}