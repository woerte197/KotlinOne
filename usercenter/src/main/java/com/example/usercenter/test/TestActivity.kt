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
import MySql
import android.content.ContentValues

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)
//        val animator = ValueAnimator.ofObject(MyEvaluator<Point>(), Point(0, 0), Point(500, 500))

        bt_test.setOnClickListener {
            val pointarray = IntArray(2)
            test_circle.getLocationOnScreen(pointarray)
            val point = Point(pointarray[0], pointarray[1])
            val animator = ValueAnimator.ofObject(MyEvaluator<Point>(), point, Point(pointarray[0]+50, pointarray[1]+50),point)
//            val translateAnimation = ValueAnimator.ofInt(1, 100, 0)
//            translateAnimation.duration = 3000
//            translateAnimation.duration = 3000
//            test_tv.animator.repeatCount = 2
            animator.interpolator = MyInterpolator(1)
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
            animator.duration = 1000
            animator.start()
        }

        test_tv.setOnClickListener {
            toast("test")
        }

        bt_close.setOnClickListener {
//            animator.cancel()
        }
        test_circle.setOnClickListener {
            var objectAnimator = ObjectAnimator.ofFloat(test_circle, "rotationY", 0f, 270f, 0f)
            objectAnimator.duration = 3000
            objectAnimator.start()
        }

       var mysql = MySql(this,"myKotlin",null,1)
        var sqlDatabase = mysql.writableDatabase
        val contentValue = ContentValues()
        contentValue.put("id",1)
        contentValue.put("uName","王洋")
        contentValue.put("uAge",12)
        contentValue.put("uSex","男")
        sqlDatabase.insert("user",null,contentValue)
        sqlDatabase.close()
    }

    private fun doAnimation(valueAnimator: ValueAnimator) {
        val value = valueAnimator.animatedValue as Point
        test_circle.layout(value.x, value.y, value.x + test_circle.width, value.y + test_circle.height)
    }
}
