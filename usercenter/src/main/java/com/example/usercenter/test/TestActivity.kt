package com.example.usercenter.test

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Point
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.usercenter.R
import kotlinx.android.synthetic.main.activity_test2.*
import org.jetbrains.anko.toast

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
        val animator = ValueAnimator.ofObject(MyEvaluator<Point>(), Point(0, 0), Point(500, 500))
        bt_test.setOnClickListener {
            //            val translateAnimation = TranslateAnimation(0f, 400f, 0f, 400f)
//            translateAnimation.duration = 3000
//            translateAnimation.fillAfter = true
//            test_tv.startAnimation(translateAnimation)
            animator.repeatCount = 2
            animator.addUpdateListener {
                doAnimation(it)
            }
            animator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {
                }

                override fun onAnimationEnd(animation: Animator?) {
                    toast("end")
                }

                override fun onAnimationCancel(animation: Animator?) {
                    toast("cancel")
                }

                override fun onAnimationStart(animation: Animator?) {
                    toast("start")
                }
            })
            animator.duration = 4000
            animator.start()
        }

        test_tv.setOnClickListener {
            toast("test")
        }

        bt_close.setOnClickListener {
            animator.cancel()
        }
        test_circle.setOnClickListener {
            var objectAnimator = ObjectAnimator.ofFloat(test_circle, "rotationY", 0f, 270f, 0f)
            objectAnimator.duration = 3000
            objectAnimator.start()
        }
    }

    private fun doAnimation(valueAnimator: ValueAnimator) {
        val value = valueAnimator.animatedValue as Point
        test_circle.layout(value.x, value.y, value.x + test_circle.width, value.y + test_circle.height)
    }
}
