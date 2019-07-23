package com.example.usercenter.ui.activity

import android.animation.*
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import com.example.usercenter.R
import com.example.usercenter.test.MyEvaluator
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : Activity() {
    private var isOpen = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        initEvent()
    }

    private fun initEvent() {
        test.setOnClickListener {
            //            val animator: ValueAnimator = AnimatorInflater.loadAnimator(this, R.animator.animator) as ValueAnimator
//            animator.addUpdateListener { animation ->
//                val off = animation!!.animatedValue as Int
//                test.layout(off, off, off + test.width, off + test.height)
//            }
//            val keyframe = Keyframe.ofObject(0f,'A')
//
            test.animate().scaleX(1.0f).scaleXBy(1.1f).setListener(object: Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                }

                override fun onAnimationCancel(animation: Animator?) {
                }

                override fun onAnimationStart(animation: Animator?) {
                }
            })

//            animator.start()
//            val propertyValuesHolder  = PropertyValuesHolder.ofFloat("Rotation",60f,-60f,40f,-40f,-20f,20f,10f,-10f,0f)
//            val propertyValuesHolderAlpha  = PropertyValuesHolder.ofFloat("alpha",0.1f,1f,0.1f,1f)
//            val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(test,propertyValuesHolder,propertyValuesHolderAlpha)
//            objectAnimator.duration = 2000
//            objectAnimator.start()
//            val keyFrame = Keyframe.ofFloat(0.1f, 20f)
//            val keyFrame1 = Keyframe.ofFloat(0.2f, -20f)
//            keyFrame.interpolator = BounceInterpolator()
//            val keyFrame2 = Keyframe.ofFloat(0.3f, 20f)
//            val keyFrame3 = Keyframe.ofFloat(0.4f, -20f)
//            val keyFrame4 = Keyframe.ofFloat(0.5f, 20f)
//            keyFrame4.interpolator = BounceInterpolator()
//            val keyFrame5 = Keyframe.ofFloat(0.6f, -20f)
//            val keyFrame6 = Keyframe.ofFloat(0.7f, 20f)
//            val keyFrame7 = Keyframe.ofFloat(0.8f, -20f)
//            val keyFrame8 = Keyframe.ofFloat(0.9f, 20f)
//            val keyFrame9 = Keyframe.ofFloat(1.0f, 36f)
//
//            val propertyValuesHolder = PropertyValuesHolder.ofKeyframe("rotation", keyFrame, keyFrame1, keyFrame2, keyFrame3, keyFrame4, keyFrame5, keyFrame6, keyFrame7, keyFrame8, keyFrame9)
//            val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(testView, propertyValuesHolder)
////            objectAnimator.addUpdateListener {
////                testView.setMyValue(it.animatedValue as Char)
////            }
//            objectAnimator.duration = 2000
//            objectAnimator.start()
        }
        mMenuImage.setOnClickListener {
            isOpen = if (!isOpen) {
                openMenu(menuOne, 0)
                openMenu(menuTwo, 1)
                openMenu(menuThree, 2)
                openMenu(menuFour, 3)
                openMenu(menuFive, 4)
                true
            } else {
                closeMenu(menuOne, 0)
                closeMenu(menuTwo, 1)
                closeMenu(menuThree, 2)
                closeMenu(menuFour, 3)
                closeMenu(menuFive, 4)
                false
            }
        }
    }

    private fun closeMenu(view: ImageView, index: Int) {
        if (view.visibility != View.VISIBLE) {
            view.visibility = View.VISIBLE
        }
        val radians = Math.toRadians(180.0) / 4 * index
        val pointX = -400 * Math.sin(radians)
        val pointY = -400 * Math.cos(radians)
        val objectAnimatorX = ObjectAnimator.ofFloat(view, "TranslationX", pointX.toFloat(), 0f)
        val objectAnimatorY = ObjectAnimator.ofFloat(view, "TranslationY", pointY.toFloat(), 0f)
        val objectAnimatorScaleX = ObjectAnimator.ofFloat(view, "ScaleX", 1f, 0f)
        val objectAnimatorScaleY = ObjectAnimator.ofFloat(view, "ScaleY", 1f, 0f)
        val objectAnimatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.1f)
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(objectAnimatorX, objectAnimatorY, objectAnimatorScaleX, objectAnimatorScaleY, objectAnimatorAlpha)
        animatorSet.duration = 2000

        animatorSet.start()
    }

    private fun openMenu(view: ImageView, index: Int) {
        if (view.visibility != View.VISIBLE) {
            view.visibility = View.VISIBLE
        }
        val pointX: Double
        val pointY: Double
        val radians: Double
        pointX = if (index > 2) {
            radians = Math.toRadians(90.0) / 2 * (index - 2)
            400 * Math.sin(radians)
        } else {
            radians = Math.toRadians(90.0) / 2 * index
            -400 * Math.sin(radians)
        }
        pointY = -400 * Math.cos(radians)
        val objectAnimatorX = ObjectAnimator.ofFloat(view, "TranslationX", 0f, pointX.toFloat())
        val objectAnimatorY = ObjectAnimator.ofFloat(view, "TranslationY", 0f, pointY.toFloat())
        val objectAnimatorScaleX = ObjectAnimator.ofFloat(view, "ScaleX", 0f, 1f)
        val objectAnimatorScaleY = ObjectAnimator.ofFloat(view, "ScaleY", 0f, 1f)
        val objectAnimatorAlpha = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(objectAnimatorX, objectAnimatorY, objectAnimatorScaleX, objectAnimatorScaleY, objectAnimatorAlpha)
        animatorSet.duration = 500
        animatorSet.interpolator = BounceInterpolator()
        animatorSet.start()
    }
}
