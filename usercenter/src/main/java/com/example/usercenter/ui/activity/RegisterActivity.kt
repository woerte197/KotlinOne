package com.example.usercenter.ui.activity

import android.content.Intent
import com.example.baselibrary.ext.enable
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.injection.component.DaggerUserComponent
import com.example.usercenter.injection.module.UserModule
import com.example.usercenter.presenter.RegisterPresenter
import com.example.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

open class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {


    override fun initView() {
        mVerifyCodeBtn.setOnClickListener {
            mVerifyCodeBtn.requestSendVerifyNumber()
        }
        mRegisterBtn.enable(mMobileEt) { isRegisterBtnEnable() }
        mRegisterBtn.enable(mPwdEt) { isRegisterBtnEnable() }
        mRegisterBtn.enable(mVerifyCodeEt) { isRegisterBtnEnable() }
        mRegisterBtn.enable(mPwdConfirmEt) { isRegisterBtnEnable() }
        mRegisterBtn.setOnClickListener {
            mPresenter.register(mMobileEt.text.toString(), mPwdEt.text.toString(), "1234")
        }
    }

    override fun onRegisterResult(result: String) {
        toast(result)
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
        return R.layout.activity_register
    }

    private fun isRegisterBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not() &&
                mVerifyCodeEt.text.isNullOrEmpty().not() &&
                mPwdEt.text.isNullOrEmpty().not() &&
                mPwdConfirmEt.text.isNullOrEmpty().not()
    }

    override fun onError(error: String) {
        super.onError(error)
        startActivity(Intent(this, LoginActivity::class.java))
    }
}
