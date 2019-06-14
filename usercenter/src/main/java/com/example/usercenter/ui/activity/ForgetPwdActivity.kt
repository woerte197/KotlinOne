package com.example.usercenter.ui.activity

import com.example.baselibrary.ext.enable
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.ForgetPwdPresenter
import com.example.usercenter.presenter.view.ForgetPwdView
import kotlinx.android.synthetic.main.activity_forget_pwd.*
import org.jetbrains.anko.startActivity

open class ForgetPwdActivity : BaseMvpActivity<ForgetPwdPresenter>(), ForgetPwdView {


    override fun initView() {
        mVerifyCodeBtn.setOnClickListener {
            mVerifyCodeBtn.requestSendVerifyNumber()
        }
        mNextBtn.enable(mMobileEt) { isRegisterBtnEnable() }
        mNextBtn.enable(mVerifyCodeEt) { isRegisterBtnEnable() }
        mNextBtn.setOnClickListener {
            startActivity<ResetPwdActivity>()
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

    override fun onBackPressed() {
        finish()
    }

    override fun setLayout(): Int {
        return R.layout.activity_forget_pwd
    }

    private fun isRegisterBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not()
    }
}
