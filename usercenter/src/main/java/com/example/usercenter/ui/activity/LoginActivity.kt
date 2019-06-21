package com.example.usercenter.ui.activity

import android.view.animation.*
import android.widget.TextView
import com.example.baselibrary.ext.enable
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.data.protocol.UserInfo
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.LoginPresenter
import com.example.usercenter.presenter.view.LoginView
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*

class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView {
    override fun setLayout(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        mLoginBtn.enable(mMobileEt) { isLoginBtnEnable() }
        mLoginBtn.enable(mPwdEt) { isLoginBtnEnable() }
        mLoginBtn.setOnClickListener {
            mPresenter.login(mMobileEt.text.toString().trim(), mPwdEt.text.toString().trim(), "123213213")
//            var animation = ScaleAnimation(0.0f, 1.0f, 0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
//            var alphaAnimation = AlphaAnimation(0.0f, 1.0f)
//            var rotateAnimation = RotateAnimation(360.0f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
//            var translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f)
//            var animationSet = AnimationSet(true)
//            animationSet.addAnimation(animation)
//            animationSet.addAnimation(alphaAnimation)
//            animationSet.addAnimation(rotateAnimation)
//            animationSet.addAnimation(translateAnimation)
//            animation.duration = 3000
//            animation.interpolator = CycleInterpolator(2.0f)
//            animationSet.setAnimationListener(object : Animation.AnimationListener {
//                override fun onAnimationRepeat(animation: Animation?) {
//
//                }
//
//                override fun onAnimationEnd(animation: Animation?) {
//
//                }
//
//                override fun onAnimationStart(animation: Animation?) {
//                }
//            })
//            mLoginBtn.startAnimation(animation)

        }
        test5.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this,R.anim.scale_alpha_anim)
            val animation1 = AnimationUtils.loadAnimation(this,R.anim.scale_alpha_anim)
            val animation2 = AnimationUtils.loadAnimation(this,R.anim.scale_alpha_anim)
            val animation3 = AnimationUtils.loadAnimation(this,R.anim.scale_alpha_anim)
            test1.startAnimation(animation)
            animation1.startOffset = 600
            test2.startAnimation(animation1)
            animation2.startOffset = 1200
            test3.startAnimation(animation2)
            animation3.startOffset = 1800
            test4.startAnimation(animation3)
        }
        mHeaderBar.find<TextView>(R.id.mRightTv).setOnClickListener {
            startActivity<RegisterActivity>()
        }
        mForgetPwdTv.setOnClickListener {
            startActivity<ForgetPwdActivity>()
        }

    }

    override fun initDaggerInjection() {

        DaggerUserComponent.builder()
                .activityComponent(mActivityComponent)
                .userModule(UserModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun loginResult(result: UserInfo) {

    }

    private fun isLoginBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not()
    }

    override fun onError(error: String) {
        startActivity(intentFor<MainActivity>().singleTop().clearTop())
    }
}