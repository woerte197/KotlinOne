package com.example.usercenter.test

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import com.example.usercenter.R

class LoadingImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {
    init {
        val mTop = top
        var mCount = 3
        var mIndex = 0
        var valueAnimator = ValueAnimator.ofInt(0, 100, 0)
        valueAnimator.addUpdateListener {
            var dy = it.animatedValue as Int
            top = mTop - dy
        }
        valueAnimator.duration = 3000
        valueAnimator.repeatMode = ValueAnimator.RESTART
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
                mIndex++
                when (mIndex % mCount) {
                    0 -> setImageResource(R.drawable.loading0)
                    1 -> setImageResource(R.drawable.light_progress_loading2)
                    2 -> setImageResource(R.drawable.loading2)
                }
            }

            override fun onAnimationEnd(animation: Animator?) {
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
                setImageResource(R.drawable.light_progress_loading1)
            }
        })
        valueAnimator.start()
    }

}