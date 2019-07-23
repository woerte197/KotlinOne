package com.example.usercenter.ui.activity

import android.animation.LayoutTransition
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.annotation.SuppressLint
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.support.graphics.drawable.AnimatedVectorDrawableCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.usercenter.R
import kotlinx.android.synthetic.main.activity_test_one.*

class TestOneActivity : AppCompatActivity() {
    var i = 0
    @SuppressLint("ObjectAnimatorBinding")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_one)

        shadowLayerView.clearShadowLayer()
        animImageView.isFocusable = true
        animImageView.isFocusableInTouchMode = true
        animImageView.requestFocus()
        animImageView.requestFocusFromTouch()

        edit.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                val animator = AnimatedVectorDrawableCompat.create(this, R.drawable.animated_vector_search)
                animImageView.setImageDrawable(animator)
                (animImageView.drawable as Animatable).start()
            }

        }

        val layoutTransition = LayoutTransition()
        val propertyValuesHolder = PropertyValuesHolder.ofFloat("left", 0f, 0f)
        val propertyValuesHolder1 = PropertyValuesHolder.ofFloat("top", 0f, 0f)
        val propertyValuesHolder2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0f, 1.5f, 1f)
        val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(Bottom, propertyValuesHolder, propertyValuesHolder1, propertyValuesHolder2)
        objectAnimator.duration = 1000
//        val objectAnimator = ObjectAnimator.ofFloat(null,"rotation",0f,90f,0f)
//        val objectAnimator2 = ObjectAnimator.ofFloat(null,"rotation",0f,40f,-40f,0f)
        layoutTransition.setAnimator(LayoutTransition.APPEARING, objectAnimator)
//        layoutTransition.setAnimator(LayoutTransition.APPEARING,objectAnimator2)
        layoutTransition.addTransitionListener(object : LayoutTransition.TransitionListener {
            override fun startTransition(transition: LayoutTransition?, container: ViewGroup?, view: View?, transitionType: Int) {
            }

            override fun endTransition(transition: LayoutTransition?, container: ViewGroup?, view: View?, transitionType: Int) {
            }
        })
        Bottom.layoutTransition = layoutTransition
        add.setOnClickListener {
            //            i++
////            val button = Button(this)
////            button.text = "button$i"
////            button.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
////            Bottom.addView(button)
            val a = Thread {
                throw NullPointerException("")
//                Log.e("sadasd", "sadsad")
            }
            a.start()
            Log.e("sadasd", a.id.toString())

        }
        del.setOnClickListener {
            //            if (i > 0) {
//                i--
//                Bottom.removeViewAt(0)
//            }
            Log.e("sadasd", android.os.Process.myTid().toString())
//            throw  NullPointerException("")


        }
    }
}
