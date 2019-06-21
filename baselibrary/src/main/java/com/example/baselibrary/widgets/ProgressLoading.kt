package com.example.baselibrary.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import com.example.baselibrary.R
import org.jetbrains.anko.find

class ProgressLoading(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    companion object {
        private lateinit var mDialog: ProgressLoading
        private var mAnimationDrawable: AnimationDrawable? = null
        fun create(context: Context):ProgressLoading {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window!!.attributes.gravity = Gravity.CENTER
            val lp = mDialog.window!!.attributes
            lp.dimAmount = 0.2f
            mDialog.window!!.attributes = lp
            val loadingView = mDialog.find<ImageView>(R.id.iv_loading)
            mAnimationDrawable = loadingView.background as AnimationDrawable
//            var rotateAnimation = RotateAnimation(0f,360f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f)
//            rotateAnimation.repeatCount
            return mDialog
        }

    }

    fun showLoading() {
        super.show()
        mAnimationDrawable?.start()
    }

    fun hideLoading(){
        super.hide()
        mAnimationDrawable?.stop()
    }


}